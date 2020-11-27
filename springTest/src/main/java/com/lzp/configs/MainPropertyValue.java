package com.lzp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.lzp.beans.Person;
import com.lzp.dao.BookDao;

//使用@PropertySource读取外部属性文件中k/v保存到运行环境变量中，加载在完外部文件之后，使用${}从文件中获取值
@PropertySource(value = {"classpath:person.properties"})
@Configuration
@ComponentScan(value = "com.lzp")
public class MainPropertyValue {
	
	
	@Bean
	public Person getPerson() {
		return new Person();
	}
	
	@Primary     //优先使用这个来装配 ，但要指定id就用指定的那个来
	@Bean
	public BookDao getBookDao() {
		return new BookDao();
	}

}
