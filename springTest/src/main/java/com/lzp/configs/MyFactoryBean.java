package com.lzp.configs;

import org.springframework.beans.factory.FactoryBean;

import com.lzp.beans.Color;


//创建一个spring定义的factorybean
public class MyFactoryBean implements FactoryBean<Color>{

	//返回的对象，就会注册到容器中
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Color();
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	//true:在容器中将会是单例
	//否则是多例
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
