package com.himanshu.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himanshu.ecom.entity.OrderHistory;

@Service
public interface OrderService {

	public void addOrderDetails(List<Integer> allorder,int userId);
	
	public List<OrderHistory> findUserById();

}