package com.himanshu.ecom.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.ecom.dao.OrderDAO;
import com.himanshu.ecom.entity.OrderHistory;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Transactional
	@Override
	public void addOrderDetails(List<Integer> allorder,int userId) {
		
		
		orderDao.addOrderDetails(allorder, userId);
		
		
	}

	@Override
	public List<OrderHistory> findUserById() {

		return orderDao.findUserById();
		
	}

}
