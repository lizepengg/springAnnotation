package com.lzp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.lzp.configs.MainPropertyValue;
import com.lzp.dao.BookDao;
import com.lzp.service.BookService;

public class Test_autowired {

	@Test
	public void test() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainPropertyValue.class);
		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);
		
		BookDao bean = (BookDao) applicationContext.getBean("bookDao");
		System.out.println(bean);
		
		((AbstractApplicationContext) applicationContext).close();
	}
}
