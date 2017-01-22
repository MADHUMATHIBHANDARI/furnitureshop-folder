package com.niit.furnitureshop.dao;

import java.util.List;


import com.niit.furnitureshop.model.Cart;
//An interface in java is a blueprint of a class. It has static constants and abstract methods only.
public interface CartDAO 
{
  //addcart method initialization
  public void addCart(Cart cart);
  // delete cart method initialization
  public void deleteCart(int id);
  //getcart method initialization
  public Cart getCart(String p_id);
 
  public List<Cart> list();
  public List<Cart> userCartList(String uname);
  
}
