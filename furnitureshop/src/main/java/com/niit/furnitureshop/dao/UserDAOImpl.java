package com.niit.furnitureshop.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.furnitureshop.model.User;
@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

@Transactional
	public void addUser(User user) {
	sessionFactory.getCurrentSession().saveOrUpdate(user);
		
		
	}

}
