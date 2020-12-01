package com.lzp.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional()        //标注这是一个事务方法
	public void addUser(String username,Integer age) {
		userDao.insert(username, age);
	}

}
