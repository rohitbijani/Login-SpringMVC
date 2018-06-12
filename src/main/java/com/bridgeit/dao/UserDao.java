package com.bridgeit.dao;

import com.bridgeit.model.Login;
import com.bridgeit.model.User;

public interface UserDao {
	
	public void register(User user);
	public User validate(Login login);

}
