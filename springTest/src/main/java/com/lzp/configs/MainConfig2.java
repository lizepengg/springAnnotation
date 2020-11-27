package com.lzp.configs;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.lzp.beans.Color;
import com.lzp.beans.Person;
import com.lzp.beans.Red;
import com.lzp.condition.LinuxCondition;
import com.lzp.condition.WindowsCondition;

@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})    //快速的向容器中导入组件
public class MainConfig2 {

	/*
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE	 *prototype 
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON	 * singleton
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST	 *request 
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION   session
	 * 
	 * prototype 多实例  ioc容器启动时并不会创建对象放到容器中，而是在那会获取那会创建
	 * singleton  单例（默认值） ioc容器启动会调用方法创建对象放到容器中，以后每次获取直接从容器中拿(map.get())
	 * request 同一个request中一个实例
	 * session 同一个session中一个实例
	 * 
	 * 懒加载；针对单实例bean:默认在容器启动的时候创建对象
	 * 使用懒加载后，在容器启动时，不创建对象，在第一次使用（获取）bean创建对象，并初始化
	 * 单例模式下使用@Lazy注解
	 */
	
	//@Scope("prototype")
	@Lazy   //懒加载
	@Bean()   //默认是单实例的bean
	public Person person01() {
		System.out.println("创建person对象。。。。");
		return new Person("lzisi", 23);
	}
	
	/**
	 * @Conditional(Condition[])   按照一定条件进行判断，满足条件给容器中注册bean
	 * 此注解也可以用在类上，只有满足条件才能将类中的bean注册到容器中。
	 * 
	 * 
	 * 
	 * 如果是windows，就给容器中注册bill gates
	 * 如果是Linux，就给容器中注册Linus
	 * 
	 */
	
	@Conditional({WindowsCondition.class})   
	@Bean("Bill Gates")
	public Person person02() {
		return new Person("bill", 62);
	}
	
	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person03() {
		return new Person("linus", 48);
	}
	
	@Bean
	public MyFactoryBean getMyFactoryBean() {
		return new MyFactoryBean();    //实际获得的是color类型的实例
	}
	
}
