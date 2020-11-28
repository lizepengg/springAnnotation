package com.lzp.configs;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.lzp.beans.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//@Profile("test")   也可以标注在类上
@PropertySource("classpath:jdbc.properties")   //注册属性配置文件
@Configuration              //配置类相当于配置文件xml,在配置文件中配置中也同样在配置类中设置
public class MainConfigProfile implements EmbeddedValueResolverAware{  //表达式解析器，用于解析EL表达式
	
	@Value("${jdbc.username}")
	String user;
    private String driver;
    private StringValueResolver valueResolver;  //解析表达式
    
    @Bean("yello")
    public Yellow yellow() {
    	
    	return new Yellow();
    }

    @Profile("test")
	@Bean("testDataSource")
	public DataSource getDataSourceTest(@Value("${jdbc.password}") String password) throws Exception {		
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl("jdbc:mysql:///mybatis01");
		dataSource.setUser(user);
		dataSource.setPassword(password);		
		
		return dataSource;
	}
    
    @Profile("dev")
	@Bean("devDataSource")
	public DataSource getDataSourceDev(@Value("${jdbc.password}") String password) throws Exception {		
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl("jdbc:mysql:///mysql");
		dataSource.setUser(user);
		dataSource.setPassword(password);		
		
		return dataSource;
	}
    
    @Profile("pro")
	@Bean("proDataSource")
	public DataSource getDataSourcePro(@Value("${jdbc.password}") String password) throws Exception {		
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl("jdbc:mysql:///test");
		dataSource.setUser(user);
		dataSource.setPassword(password);		
		
		return dataSource;
	}
	
	//解析嵌入式的表达式
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		this.valueResolver=resolver;
		driver = resolver.resolveStringValue("${jdbc.driver}");
	}

}
