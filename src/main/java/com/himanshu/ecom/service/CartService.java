package com.himanshu.ecom.service;

import org.springframework.stereotype.Service;

import com.himanshu.ecom.entity.OrderHistory;

@Service
public interface CartService {
	
	public void  addToCart(OrderHistory orderHistory);

}
