package com.niit.furnitureshop.controller;





import java.io.File;
import java.nio.file.Paths;

import javax.persistence.criteria.Path;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.furnitureshop.dao.CategoryDAO;
import com.niit.furnitureshop.dao.ProductDAO;
import com.niit.furnitureshop.dao.SupplierDAO;
import com.niit.furnitureshop.model.Category;
import com.niit.furnitureshop.model.Product;
import com.niit.furnitureshop.model.Supplier;



@Controller
public class ProductController{
@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	

	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	Supplier supplier;
	
	private Path path;
	
 //@RequestMapping("/Product")
//public String getProduct()
//{
//	return "product";
	//}
//	@RequestMapping("/product")
//	public ModelAndView getRegister(Model m)
//	{
//		m.addAttribute("product",new Product());
//		ModelAndView model = new ModelAndView("product");
//		
//		return model;
//		
//	}

	
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	public String addProduct(Model model, @ModelAttribute("product") Product product,HttpServletRequest request)
	{
		
		Category category=categoryDAO.getByName(product.getCategory().getCname());
		categoryDAO.addCategory(category);
		
		Supplier supplier=supplierDAO.getByName(product.getSupplier().getSname());
		supplierDAO.addSupplier(supplier);
		
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategory_id(category.getCid());
		product.setSupplier_id(supplier.getSid());
		
		productDAO.addProduct(product);

		MultipartFile file =product.getImage();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		path=(Path) Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getPid()+".jpg");
		
		if(file!=null &&!file.isEmpty())
		{
			try{
				file.transferTo(new File(path.toString()));
				System.out.println("image uploaded....");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw new RuntimeException("image saving failed",e);
			}
			
		}
		//FileUtil.upload(path.toString(), file, product.getpid()+".jpg");
		//System.out.println("image uploaded"+product.getpid());
		return "redirect:/product";
		//return "product";
	}
	
	@RequestMapping("product/remove/{pid}")
	public String deleteproduct(@PathVariable("pid") String id, ModelMap model) throws Exception {

	try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
 //redirectAttrs.addFlashAttribute(arg0, arg1)
	return "redirect:/product";
	}
	

	@RequestMapping("product/edit/{pid}")
	public String editproduct(@PathVariable("pid") String id, Model model) {
		System.out.println("editProduct");
		model.addAttribute("product", this.productDAO.getProduct(id));
		model.addAttribute("Productlist", this.productDAO.list());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());
	return "product";
	}
	
	
		@RequestMapping(value = "/product", method = RequestMethod.GET)
		public String listProduct(Model model){
			model.addAttribute("product",new Product());
			model.addAttribute("supplier",new Supplier());
			model.addAttribute("category",new Category());
			model.addAttribute("productList",this.productDAO.list());
			model.addAttribute("categoryList",this.categoryDAO.list());
			model.addAttribute("supplierList",this.supplierDAO.list());
			return "product";
		
}
		@RequestMapping(value="product/get/{pid}")
		public String getSelectedProduct(@PathVariable("pid") String id,Model model,RedirectAttributes redirectAttributes)
		{
			redirectAttributes.addFlashAttribute("selectedProduct",productDAO.getProduct(id));
			
			return "redirect:/backToHome";		
		}

		@RequestMapping(value="/backToHome",method=RequestMethod.GET)
		public String backToHome(@ModelAttribute("selectedProduct")
		final Product selectedProduct,final Model model)
		{
			model.addAttribute("selectedProduct",selectedProduct);
			model.addAttribute("categoryList",this.categoryDAO.list());
			return "item";
			
			
		}
		
	

}
