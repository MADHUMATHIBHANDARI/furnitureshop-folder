package com.niit.furnitureshop.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product
{
	@Id
	private String pid;
	private String pname;
	private String pdescription;
	private int pprice;
	private String category_id;
	private String supplier_id;
	
	@Transient
	private MultipartFile image;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false,updatable=false,insertable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id",nullable=false,updatable=false,insertable=false)
	private Supplier supplier;
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	
	
	
	public MultipartFile getImage()
	{
		return image;
		}
	
	public void setImage(MultipartFile image){
	this.image = image;
}
	
}
