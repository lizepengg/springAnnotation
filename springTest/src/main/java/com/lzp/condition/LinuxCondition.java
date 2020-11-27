package com.lzp.condition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是Linux环境
public class LinuxCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		
		//是否是linux系统
		//1.能获取到ioc使用的beanFactory
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2.获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3.获取当前环境信息
		Environment environment = context.getEnvironment();
		
		//4.获取到bean定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		
		String property = environment.getProperty("os.name");
		if (property.contains("Linux")) {
			return true;
		}
		
		/**
		 * 在运行配置中，修改虚拟机的参数  -Dos.name=Linux 既可以打印出linux使用的信息
		 */
		
		
		return false;
	}

}
