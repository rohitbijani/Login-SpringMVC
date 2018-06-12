package com.bridgeit.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.dao.UserDao;
import com.bridgeit.model.Login;
import com.bridgeit.model.User;

public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void register(User user) {
			
		if (user!=null) {
			userDao.register(user);
		}
	}

	@Override
	public User validateUser(Login login) {
		System.out.println(login.getUsername());
		User user=userDao.validate(login);
		if(user!=null) {
			return user;
		}
		return null;
	}

}
