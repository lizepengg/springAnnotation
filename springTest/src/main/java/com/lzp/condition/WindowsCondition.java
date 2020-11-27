package com.lzp.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否是window环境
public class WindowsCondition implements Condition{

	/**
	 * ConditionContext判断条件能使用的上下文环境
	 * AnnotatedTypeMetadata  注释信息
	 */
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if (property.contains("Windows")) {
			return true;
		}
		
		//可以判断容器中bean的注册情况，也可以给容器中注册bean
		//BeanDefinitionRegistry registry = context.getRegistry();
		//registry.registerBeanDefinition(beanName, beanDefinition);注册bean
		//registry.containsBeanDefinition(beanName) 判断bean的注册情况
		
		return false;
	}

}
