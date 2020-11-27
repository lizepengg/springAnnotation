package com.lzp.configs;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
/**
 * 自定义扫描规则
 * @author lzp
 * @date 2020年11月25日下午5:33:39
 * @version
 */
public class MyTypeFilter implements TypeFilter{
	
	/**
	 * metadataReader:读取到正在扫描的类的信息
	 * metadataReaderFactory:可以获取到其他任何类的信息
	 */
	

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		
		//获取类的注解信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//获取当前正在扫描的类的信息，包括类名和接口名等
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//获取当前类的资源信息，包括类路径等
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("--------->"+className);   //输出正在扫描的类
		
		if(className.contains("er")) {
			return true;  //匹配到相应的组件或类
		}
		
		
		return false;  //false就代表什么都没有匹配到
	}

}
