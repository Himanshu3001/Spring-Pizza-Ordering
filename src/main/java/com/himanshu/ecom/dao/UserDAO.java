package com.himanshu.ecom.dao;

import com.himanshu.ecom.entity.User;

public interface UserDAO {
	
	public void saveUser(User user);
	
	public boolean findUser(String email,String password);

}
