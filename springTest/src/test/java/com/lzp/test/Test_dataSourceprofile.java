package com.lzp.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.AliasRegistry;

import com.lzp.beans.Yellow;
import com.lzp.configs.MainConfigProfile;

public class Test_dataSourceprofile {

	@Test
	public void test() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigProfile.class);
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		((AbstractApplicationContext) applicationContext).close();
	}
	
	@Test
	public void test02() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		
		//设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		//注册主配置文件
		applicationContext.register(MainConfigProfile.class);
		//启动刷新容器
		applicationContext.refresh();
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
		
		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		
		applicationContext.close();
	}
}
