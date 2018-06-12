package com.bridgeit.service;

import com.bridgeit.model.Login;
import com.bridgeit.model.User;

public interface UserService {

	public void register(User user);
	
	public User validateUser(Login login);	

}
