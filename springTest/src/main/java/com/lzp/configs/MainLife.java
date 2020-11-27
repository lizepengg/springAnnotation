package com.lzp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.lzp.beans.Car;
import com.lzp.beans.Cat;

@ComponentScan("com.lzp")
@Configuration
public class MainLife {
	
	
	//@Scope("prototype")
	@Bean(initMethod = "init",destroyMethod = "end")
	public Car getCar() {
		return new Car();
	}
	
	@Bean
	public Cat getCat() {
		return new Cat();
	}

}
