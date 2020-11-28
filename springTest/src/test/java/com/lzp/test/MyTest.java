package com.lzp.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.lzp.beans.Car;
import com.lzp.beans.Person;
import com.lzp.configs.MainConfig;
import com.lzp.configs.MainConfig2;
import com.lzp.configs.MainLife;
import com.lzp.configs.MainPropertyValue;

public class MyTest {
	
	
	
	@Test
	public void test() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		Person bean = (Person) applicationContext.getBean("person");
		System.out.println(bean);
		
	}
	
	@Test
	public void test01() {
		
		//加载配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		//通过类型来获取实例
		Person bean = (Person) applicationContext.getBean(Person.class);
		System.out.println(bean);
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class); //根据类型来获取类的名称id
		for(String name: beanNamesForType) {
			System.out.println(name);
		}
		
	}
	
	@Test
	public void test02() {
		
		//加载配置类
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		//通过类型来获取实例
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for(String beanName:beanDefinitionNames) {    //获取到的是类名
			System.out.println(beanName);
		}		
		
	}
	
	@Test
	public void test03() {
		
		//scope为默认值时即singleton值为true,scope为prototype时结果为false
		ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		System.out.println("ioc容器初始化完成");
		Person bean = (Person) annotationConfigApplicationContext.getBean("person01"); //根据id获取bean
		Person bean2 = (Person) annotationConfigApplicationContext.getBean("person01");
		System.out.println(bean==bean2);
	}
	
	@Test
	public void test04(){
		ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		Map<String, Person> persons = annotationConfigApplicationContext.getBeansOfType(Person.class);//获取多个bean
		System.out.println(persons);
		
		String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
		for (String name : beanNamesForType) {
			System.out.println(name);
		}
		
		//动态的获取环境变量的值
		Environment environment = annotationConfigApplicationContext.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println(property);   //Windows 10
	}
	
	@Test
	public void testIMport() {
		ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
			
		System.out.println("----------");
		  for (String string : beanDefinitionNames) { System.out.println(string); }
		  
		  	//工厂bean获取的是调用getObject()方法返回的对象
			Object bean = annotationConfigApplicationContext.getBean("getMyFactoryBean");
			System.out.println("factory类型为"+bean.getClass());
			
			//获取到工厂bean本身的类型
			Object bean1 = annotationConfigApplicationContext.getBean("&getMyFactoryBean");
			System.out.println(bean1.getClass());
			
	}	
	
	@Test
	public void test06() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainLife.class);
		System.out.println("容器初始化完成");
		applicationContext.close();
	}
	
	@Test
	public void test07() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainPropertyValue.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}
		
		Person bean = (Person) applicationContext.getBean("getPerson");
		System.out.println(bean);
	}
	

}
