package com.himanshu.ecom.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himanshu.ecom.entity.OrderHistory;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addToCart(OrderHistory orderHistory) {
		Session session=sessionFactory.getCurrentSession();
		
		session.save(orderHistory);
		
		
		
	}

	
	
	
}
