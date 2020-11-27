package com.lzp.beans;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	
	public Dog() {
		System.out.println("dog 构造方法");
	}
	
	//对象创建并赋值之后，调用
	//@PostConstruct
	public void init() {
		System.out.println("dog 初始化方法");
	}
	
	//容器移除对象之前
	//@PreDestroy
	public void destory() {
		System.out.println("dog 销毁方法");
	}

}
