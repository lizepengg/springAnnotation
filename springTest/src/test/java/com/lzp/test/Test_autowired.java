package com.lzp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.lzp.beans.Yellow;
import com.lzp.configs.MainPropertyValue;
import com.lzp.configs.MainTest;
import com.lzp.configs.TypeFilterCust;
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
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test");
		annotationConfigApplicationContext.register(MainTest.class);
		annotationConfigApplicationContext.refresh();
		
		String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Yellow.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
		annotationConfigApplicationContext.close();
	}
	
	@Test
	public void test02() {
		
		//使用命令行参数  -Dspring.profile.active=test
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainTest.class);
		String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(TypeFilterCust.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
		annotationConfigApplicationContext.close();
	}
	
	
}
