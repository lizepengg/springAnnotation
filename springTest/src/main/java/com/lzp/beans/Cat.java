package com.lzp.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean,DisposableBean{
	
	public Cat() {
		System.out.println("cat构造方法执行。。。");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean属性赋值完成");     //自动执行
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub      //自动执行，无需调用
		System.out.println("开始销毁");
	}
	
	
	
	

}
