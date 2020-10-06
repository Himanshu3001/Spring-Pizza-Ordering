package com.himanshu.ecom.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "OrderHistory")
public class OrderHistory {

	
	  @Id
	  
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	  @Column(name = "OrderID") int orderId;
	 
	
	int itemId;
	int userId;
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
	  CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
	  
	  @JoinTable( name="OrderHistory", joinColumns = @JoinColumn(name="itemId"),
	  inverseJoinColumns = @JoinColumn(name="userId")
	  
	  )
	 
	 
	
	private List<User> users;

	
	  public int getOrderId() { return orderId; }
	  
	  public void setOrderId(int orderId) { this.orderId = orderId; }
	 

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User theUser)
	{
		if(users==null)
		{
			users=new ArrayList<>();
		}
		users.add(theUser);
		
	}

}