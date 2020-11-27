package com.lzp.configs;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.lzp.beans.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	/**
	 * AnnotationMetadata:当前类的注解信息
	 * BeanDefinitionRegistry：BeanDefinition注册类
	 * 把需要注册到容器中bean，使用调用BeanDefinitionRegistry.registerBeanDefinition()方法手动注册进入
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		
		boolean containsBeanDefinition = registry.containsBeanDefinition("com.lzp.beans.Red");
		boolean containsBeanDefinition2 = registry.containsBeanDefinition("com.lzp.beans.Blue");
		
		//指定bean的定义信息（bean的类型，作用域等）
		BeanDefinition beanDefinition=new RootBeanDefinition(RainBow.class);
		if (containsBeanDefinition&&containsBeanDefinition2) {
			
			//注册一个bean，指定bean的名称
			registry.registerBeanDefinition("rainbow",beanDefinition);
		}
		
	}

}
