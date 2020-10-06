package com.himanshu.ecom.service;

import com.himanshu.ecom.entity.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean findUser(String email,String password);
	
}
