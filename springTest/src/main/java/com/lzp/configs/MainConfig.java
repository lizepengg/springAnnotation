package com.lzp.configs;

import java.awt.print.Book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.lzp.beans.Person;
import com.lzp.service.BookService;

//配置类==配置文件xml
@Configuration // 告诉这是一个配置类
//@ComponentScan(value="com.lzp")                //用于扫描指定包下的所有组件或文件
//@ComponentScans中的value属性可以指定多个ComponentScan扫描组件
@ComponentScan(value = "com.lzp", includeFilters = {
		/*
		 * @Filter(type = FilterType.ANNOTATION, classes = { Controller.class}) ,
		 * 
		 * @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
		 */
		@Filter(type = FilterType.CUSTOM,value = {MyTypeFilter.class})//自定义扫描规则
		},useDefaultFilters = false)
//@ComponentScan中value：指定要扫描的包
//excludeFilters =Filter[]  指定扫描的时候按照什么规则来排除哪些组件
//includeFilters=Filter[]  指定扫描的时候只扫描那些组件,需要关闭默认的扫描策略usedefaultFilters=false
//组件为@controller，@Service,@Repository和@component注解标记的类
//FilterType.ANNOTATION  按照注解方式过滤
//FilterType.ASSIGNABLE_TYPE 按照给定类型及其子类进行过滤
//FilterType.ASPECTJ  按照aspectj表达式的方式，不太常用
//FilterType.REGEX  使用正则来指定
//FilterType.CUSTOM  使用自定义规则
public class MainConfig {

	// 给容器中注册一个bean，类型为返回值类型，id默认是使用方法名作为id。也可以通过bean的value属性来指定id
	@Bean("person")
	public Person person01() {
		return new Person("lzisi", 23);
	}
}
