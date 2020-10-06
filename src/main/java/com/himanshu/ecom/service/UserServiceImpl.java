package com.himanshu.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.himanshu.ecom.dao.UserDAO;
import com.himanshu.ecom.entity.User;

@Service
public class UserServiceImpl implements UserService {
		
		 @Autowired
		 private UserDAO userdao;
		
		@Override
		@Transactional
		public void saveUser(User user) {
			userdao.saveUser(user);
				
		}
		
		@Override
		public boolean findUser(String email, String password) {
			
			
			return userdao.findUser(email, password);
		}


	
		

}
