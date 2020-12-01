package com.lzp.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lzp.extend.ExtConfig;
import com.lzp.extend.MyBeanFactoryPostProcessor;
import com.lzp.tx.TxConfig;
import com.lzp.tx.UserService;

public class Test_tx {

	@Test
	public void test() {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

		UserService bean = applicationContext.getBean(UserService.class);

		bean.addUser("li", 23);

		applicationContext.close();

	}

	@Test
	public void test01() {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

		
		
		//自己发布一个事件
		//applicationContext.publishEvent(new String("自定义发布的事件"));

		applicationContext.close();

	}

}
