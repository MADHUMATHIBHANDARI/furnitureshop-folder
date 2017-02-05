package com.niit.furnitureshop.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.furnitureshop.dao.UserDAO;
import com.niit.furnitureshop.model.User;

public class UserTest {
	
public static void main(String[] args){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.furnitureshop");
	context.refresh();
	
	UserDAO userDAO=(UserDAO)context.getBean("userDAO");
	User user=(User) context.getBean("user");
	
	user.setName("madhu");
	user.setPassword("mam");;
	user.setAddress("mvm");
	user.setEmail("madhu96");
	user.setPhonenumber("987654321");
	
	userDAO.addUser(user);
	
}

}
