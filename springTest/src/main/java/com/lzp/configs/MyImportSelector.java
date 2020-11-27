package com.lzp.configs;

import java.util.Map;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{

	/**
	 * AnnotationMetadata:可以获取当前标注@import注解的类的所有注解信息
	 * 会获取到mainConfig中的两个注解的信息
	 */
	//返回值,就是导入到容器中的组件的全类名
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
				
		//不要返回null,会出现空指针异常，返回值就是导入到容器中的组件的全类名
		return new String[] {"com.lzp.beans.Yellow","com.lzp.beans.Blue"};
	}

}
