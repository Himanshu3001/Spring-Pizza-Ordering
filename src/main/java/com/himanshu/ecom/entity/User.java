package com.himanshu.ecom.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.himanshu.ecom.annotations.Email;

@Entity
public class User {

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Email
	private String email;
	private String password;
	private String mobile;
	private String city;
	
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
	
	@JoinTable(
			name="Order",
			joinColumns = @JoinColumn(name="userId"),
			inverseJoinColumns = @JoinColumn(name="itemId")
			
			)
	private List<Item> items;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", city="
				+ city + "]";
	}
	
	
	
}
