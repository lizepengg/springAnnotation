package com.lzp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lzp.dao.BookDao;

@Service
public class BookService {
	
	@Qualifier("bookDao")   //指定要用的类型的id
	@Autowired(required = false)   //这个注入不是必须的，容器中可以没有
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
	

}
