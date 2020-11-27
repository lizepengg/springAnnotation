package com.lzp.beans;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	
	//使用@value赋值可以使用
	//基本的数据类型
	//使用SPEL：#{}
	//也可以使用${},从配置文件中获取，但需要指定配置文件
	
	
	@Value("李四")
	private String name;
	
	@Value("#{24-1}")
	private Integer age;
	
	@Value(value = "${person.nickName}")
	private String nickName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickName=" + nickName + "]";
	}
	
	

}
