package com.lzp.configs;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.lzp.beans.Yellow;

@PropertySource("classpath:/jdbc.properties")
@ComponentScan(value = { "com.lzp.configs" },excludeFilters = { 
    @Filter(type = FilterType.CUSTOM,classes = {TypeFilterCust.class}) },useDefaultFilters = false)
@Configuration
public class MainTest implements EmbeddedValueResolverAware{

	//@Profile("test")
	@Bean
	@Primary
	public Yellow yellow() {
		return new Yellow();
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		String driver = resolver.resolveStringValue("${jdbc.driver}");//解析表达式
		System.out.println(driver);
	}
	
}
