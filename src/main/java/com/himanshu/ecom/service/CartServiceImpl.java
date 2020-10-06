package com.himanshu.ecom.service;

import org.springframework.transaction.annotation.Transactional;

import com.himanshu.ecom.dao.CartDAO;
import com.himanshu.ecom.entity.OrderHistory;

public class CartServiceImpl implements CartService {

	private final CartDAO cartDao;
	
	 public CartServiceImpl(CartDAO dao) {
		
		this.cartDao=dao;
	}
	

	@Transactional
	@Override
	public void addToCart(OrderHistory orderHistory) {
		
		cartDao.addToCart(orderHistory);
		
	}

}
