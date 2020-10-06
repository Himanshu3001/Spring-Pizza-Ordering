package com.himanshu.ecom.dao;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himanshu.ecom.entity.Item;
@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	HttpServletResponse httpServletResponse;
	
	

	@Override
	public List<Item> displayItems() {
		//Item item = null;
		//List<Item> items = new LinkedList<Item>();
		
		Session session=sessionFactory.getCurrentSession();
		
	
		Query<Item> query=session.createQuery("from Items",Item.class);
		
		List<Item> allItems=query.getResultList();
		
		
		
		System.out.println(allItems);
		
		
		return allItems;
		
	}



	/*
	 * @Override public Item findItemById(int id) {
	 * 
	 * Session session=sessionFactory.getCurrentSession();
	 * 
	 * Item theItem=session.get(Item.class, id);
	 * 
	 * return theItem; }
	 */



	
	@Override
	public List<Item> findItemById(List<Integer> itemIDs) {
		
		//Item item= new Item();
		Session session=sessionFactory.getCurrentSession();
		
		
		Query<Item> query=session.createQuery("SELECT i from Items i where i.itemId IN :itemIDs").setParameter("itemIDs",itemIDs);
		
		List<Item> item1=null;
		try {
		item1=query.getResultList();
		}catch (Exception e) {
			System.out.println("Caught:" + e);
		}
		finally {
			System.out.println("in finally");
		
	//		redirectMethod(httpServletRequest, httpServletResponse);
			
		}
		if(item1==null)
		{
			System.out.println("Null------->>>>");
			return null;
		}
	
		System.out.println(item1);
		
		
		
		return item1;
	}
	
	/*
	 * public void redirectMethod(HttpServletRequest request,HttpServletResponse
	 * response) {
	 * 
	 * try { RequestDispatcher
	 * dispatcher1=request.getRequestDispatcher("/orderpizza");
	 * dispatcher1.forward(request, response); }catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
	


}
