package com.niit.furnitureshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.furnitureshop.model.Product;

@Repository("productDAO")
@EnableTransactionManagement

public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory; 
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public void addProduct(Product product)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	
	@Transactional
	public void delete(String id)
	{
		Product product=new Product();
		product.setPid(id);
		sessionFactory.getCurrentSession().delete(product);
	}
	
	@Transactional
	public Product getProduct(String id)
	{
		String hql="from Product where pid="+"'"+id+"'";
		@SuppressWarnings("deprecation")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("uncheked")
		List<Product> list=(List<Product>) query.list();
		if(list!=null&& !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public Product getByName(String name)
	{
		String hql="from Product where pname="+"'"+ name +"'";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list= query.list();
		if(list!=null && !list.isEmpty())
		{
			return list.get(0);
		}
		return null;
		
	}
	
	@Transactional
	public List<Product> list()
	{
		@SuppressWarnings("uncheked")
		List<Product> list= (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
				
	}
}