package com.niit.furnitureshop.dao;

import java.util.List;

import com.niit.furnitureshop.model.Category;


public interface CategoryDAO 
{
	public void addCategory(Category category);
	public Category getCategory(String id);
	public void delete(String id);
	public List<Category> list();
	public Category getByName(String name);


}