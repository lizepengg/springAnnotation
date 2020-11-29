package com.lzp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.lzp.aop.MathCalculator;
import com.lzp.beans.Yellow;
import com.lzp.configs.MainAop;
import com.lzp.configs.MainPropertyValue;
import com.lzp.configs.MainTest;
import com.lzp.configs.TypeFilterCust;
import com.lzp.dao.BookDao;
import com.lzp.service.BookService;

public class Test_aop {
	
	@Test
	public void test02() {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainAop.class);
		
		MathCalculator bean = applicationContext.getBean(MathCalculator.class);
		int div = bean.div(12, 3);
		System.out.println("运行结果为"+div);
		
		applicationContext.close();
	}
	
	
}
