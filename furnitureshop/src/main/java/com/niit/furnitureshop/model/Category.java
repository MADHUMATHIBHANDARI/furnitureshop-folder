package com.niit.furnitureshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Category {
@Id
private String cid;

private String cname;
private String cdesc;

public String getCid()
{
	return cid;

}
public void setCid(String cid){
	this.cid=cid;
}
public String getCname(){
	return cname;
}
public void setCname(String cname){
	this.cname=cname;
}
public String getCdesc(){
	return cdesc;
}
public void setCdesc(String cdesc){
	this.cdesc=cdesc;
}
}
