package com.niit.furnitureshop.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.furnitureshop.dao.ProductDAO;
import com.niit.furnitureshop.model.Product;

public class ProductTest
{
 public static void main(String[] args)
	   {
		   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		   context.scan("com.niit.furnitureshop");
		   context.refresh();
		   ProductDAO  productDAO=(ProductDAO)context.getBean("productDAO");
		   Product  product=(Product) context.getBean("product");
		   
		   product.setPid("123");
		    product.setPname("Sofa");
		  
		   product.setPprice(5000);
		   
		   
		    productDAO.addProduct(product);
		   // ProductDao.delete("123");
		   
	}
}
