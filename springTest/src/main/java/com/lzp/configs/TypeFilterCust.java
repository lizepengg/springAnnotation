package com.lzp.configs;

import java.io.IOException;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class TypeFilterCust implements TypeFilter{

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// TODO Auto-generated method stub
		
		//metadataReader正在读的类的相关信息
		//metadataReaderFactory其他类的信息
		
//		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//		System.out.println(annotationMetadata);
//		
		String className = metadataReader.getClassMetadata().getClassName();
		//System.out.println(className);   //输出当前扫描包的相关信息
		if (className.contains("TypeFilterCust")) {
			return true;
		}
		
		return false;         //是否正确匹配
	}

}
