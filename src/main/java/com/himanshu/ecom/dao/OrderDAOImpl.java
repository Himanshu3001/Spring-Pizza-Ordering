package com.himanshu.ecom.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.himanshu.ecom.entity.Item;
import com.himanshu.ecom.entity.OrderHistory;

@Repository
@EnableTransactionManagement
@org.springframework.transaction.annotation.Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	HttpServletRequest httpServletRequest;

	@Override
	public void addOrderDetails(List<Integer> allorder, int userId)
	{
		Session session = sessionFactory.getCurrentSession();

		int n = allorder.size();

		int temp;

		OrderHistory order[] = new OrderHistory[n];

		HttpSession session1 = httpServletRequest.getSession();

		System.out.println("adding id in session:" + session1.getAttribute("currentUserID"));

		userId = (Integer) session1.getAttribute("currentUserID");
		System.out.println(" userId:" + userId);

		for (int i = 0; i < n; i++)
		{
			temp = allorder.get(i);
			System.out.println("i:" + i + "temp:" + temp);
			order[i] = new OrderHistory();
			order[i].setItemId(temp);
			order[i].setUserId(userId);
			session.save(order[i]);
			System.out.println(" final order :" + order[i]);
		}
	}

	@Override
	public List<OrderHistory> findUserById() {
		
		Session session=sessionFactory.getCurrentSession();
		HttpSession session1 = httpServletRequest.getSession();
		int userID = (Integer) session1.getAttribute("currentUserID");
		
		Query<OrderHistory> query=session.createQuery("SELECT i from OrderHistory i where i.userId IN :userID").setParameter("userID",userID);
		

		//Query<Item> query=session.createQuery("SELECT i from Items i where i.itemId IN :itemIDs").setParameter("itemIDs",itemIDs);
		
	
		List<OrderHistory> item1=query.getResultList();
	
		System.out.println(item1);
		
		return item1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
