package com.niit.furnitureshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.furnitureshop.dao.CategoryDAO;
import com.niit.furnitureshop.model.Category;
import com.niit.furnitureshop.model.Product;


@Controller
public class CategoryController{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	@RequestMapping("/category")
	public ModelAndView getRegister(Model m)
	{
		m.addAttribute("category",new Product());
		ModelAndView model = new ModelAndView("category");
		
		return model;
		
	}
 
	@RequestMapping(value="category/add", method=RequestMethod.POST)
	public String addUser(Model model, @ModelAttribute("category") Category category)
	{
		categoryDAO.addCategory(category);
		return "redirect:/category";
	}


@RequestMapping("category/remove/{cid}")
public String deleteCategory(@PathVariable("cid") String id, ModelMap model) throws Exception {

	try {
		categoryDAO.delete(id);
		model.addAttribute("message", "Successfully Added");
	} catch (Exception e) {
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
	}
	// redirectAttrs.addFlashAttribute(arg0, arg1)
	return "redirect:/category";
}


@RequestMapping("category/edit/{cid}")
public String editCategory(@PathVariable("cid") String id, Model model) {
	System.out.println("editCategory");
	model.addAttribute("category", this.categoryDAO.getCategory(id));
	model.addAttribute("listCategory", this.categoryDAO.list());
	return "category";
}


	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(Model model){
		model.addAttribute("category", category);
		model.addAttribute("categoryList",this.categoryDAO.list());
		return "category";
	
}
	


}