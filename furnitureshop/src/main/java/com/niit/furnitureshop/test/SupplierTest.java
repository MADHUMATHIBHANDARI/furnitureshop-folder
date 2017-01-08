package com.niit.furnitureshop.test;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.furnitureshop.dao.SupplierDAO;
import com.niit.furnitureshop.model.Supplier;

public class SupplierTest
{
 public static void main(String[] args)
	   {
		   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		   context.scan("com.niit.furnitureshop");
		   context.refresh();
		   
		   
		   SupplierDAO  supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		   Supplier  supplier=(Supplier) context.getBean("supplier");
		   
		   supplier.setSid("123");
		   supplier.setSname("vardha furniture");
		   
		   supplier.setSphonenumber("12345");
		   supplier.setSaddress("Bangalore");
		   
		   
		   supplierDAO.addSupplier(supplier);
		 context.close();
		   
	}
}
