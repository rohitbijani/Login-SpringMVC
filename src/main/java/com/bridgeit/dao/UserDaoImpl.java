package com.bridgeit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bridgeit.model.Login;
import com.bridgeit.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void register(User user) {
	    String sql = "insert into login values(?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] {user.getUsername(), user.getPassword(), user.getEmail(), user.getPhone()});
	}

	@Override
	public User validate(Login login) {
		String sql = "select * from login where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    if(users.size() > 0 ) {
	    	return  users.get(0);
	    }
	    
	    return null;
	}

}

class UserMapper implements RowMapper<User> {
	
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setEmail(rs.getString("email"));
	    user.setPhone(rs.getInt("phone"));
	    
	    return user;
	  }
}
