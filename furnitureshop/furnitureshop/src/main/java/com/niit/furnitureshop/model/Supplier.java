package com.niit.furnitureshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Entity
@Component
public class Supplier {
@Id
private String sid;

private String sname;
private String sphonenumber;
private String saddress;
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSphonenumber() {
	return sphonenumber;
}
public void setSphonenumber(String sphonenumber) {
	this.sphonenumber = sphonenumber;
}
public String getSaddress() {
	return saddress;
}
public void setSaddress(String saddress) {
	this.saddress = saddress;
}


}
