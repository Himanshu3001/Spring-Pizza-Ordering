package com.himanshu.ecom.dao;

import java.util.List;

import com.himanshu.ecom.entity.OrderHistory;

public interface OrderDAO {
	
	public void addOrderDetails(List<Integer> allorder,int orderId);
	
	public List<OrderHistory> findUserById();

}
