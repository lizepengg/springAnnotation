package com.lzp.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(String username,Integer age) {
		
		String sql="insert into user(username,age) values(?,?)";
		
		jdbcTemplate.update(sql, username,age);
		System.out.println("插入成功");
	}

}
