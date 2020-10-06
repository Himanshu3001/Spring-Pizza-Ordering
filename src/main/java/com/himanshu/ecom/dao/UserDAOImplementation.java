package com.himanshu.ecom.dao;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.himanshu.ecom.entity.User;

@Repository
@EnableTransactionManagement
@org.springframework.transaction.annotation.Transactional
public class UserDAOImplementation implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Override
	public void saveUser(User user) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(user);
		HttpSession session1=httpServletRequest.getSession();
		session1.setAttribute("currentUserID", user.getId());
		System.out.println("setting session in reg.  " + session1.getAttribute("currentUserID"));
		
		
	}

	@Override
	public boolean findUser(String email, String password) {
		
		Session session=sessionFactory.getCurrentSession();
		//session.find(User.class, "id");
		boolean isValidUser =false;
		User theUser= null;
		//String sqlQuery="from User u where u.email=? and u.password=?";
		try {
			Query q=session.createQuery("from User u where u.email=:email and u.password=:password",User.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			
			theUser=(User)q.getSingleResult();
			
			/*
			 * System.out.println(" getSingleResult"+ theUser);// Returns item object(current user) 
			 * System.out.println(theUser.getId());
			 */
			
			HttpSession session1=httpServletRequest.getSession();
					
			session1.setAttribute("currentUserID", theUser.getId());
			System.out.println("adding id in session:" + session1.getAttribute("currentUserID"));
			
			if(theUser!= null)
			{
				isValidUser=true;
			}
			
			
			
		}catch (Exception e) {
			//System.out.println("error:" + e);
		}
			
		return isValidUser;
		
	
	}

	
		

	
}
