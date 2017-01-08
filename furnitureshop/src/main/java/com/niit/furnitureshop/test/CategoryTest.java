package com.niit.furnitureshop.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.furnitureshop.dao.CategoryDAO;
import com.niit.furnitureshop.model.Category;


public class CategoryTest {
	
	
   public static void main(String[] args)
   {
	   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	   context.scan("com.niit.furnitureshop");
	   context.refresh();
	   CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	   Category category=(Category) context.getBean("category");
	   
	   category.setCid("123");
	   category.setCname("Sofa");
	   category.setCdesc("Brown Sofa");
	   
	   categoryDAO.addCategory(category);
	   //CategoryDao.delete("123");
	   //List<Category> list=(List<Category>)categoryDAO.getCategory("123");
	   
	   //System.out.println(categoryDAO.getCategory("123"));
	   //context.close();
	   
   }
}
