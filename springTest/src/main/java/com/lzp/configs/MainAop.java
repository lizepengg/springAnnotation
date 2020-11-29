package com.lzp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.lzp.aop.MathCalculator;
import com.lzp.aop.MyAspects;

/**
 * aop动态代理
 * 指在程序运行期间动态的将某段代码切入到指定方法位置进行运行的编程方式
 * 1、导入aop模块spring-aspects,aspectjweaver的依赖
 * 2、定义一个业务类（mathCalculator），在业余逻辑运行的时候将日志进行打印(方法之前，方法运行结束、方法出现异常，xxx)
 * 3.定义一个日志切面，切面类里面的方法需要动态感知mathCalculator.div运行
 * 通知方法：前置通知，后置通知，返回通知，异常通知，环绕通知(JoinPoint.procced())
 * 4.给切面类的目标方法标注何时何地的运行
 * 5.将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6.必须告诉Spring哪个类是切面类（给切面类上加一个注解：@Aspect）
 * 7.给配置类中添加@EnableAspectJAutoProxy(开启注解的aop模式)
 * 		在spring中有许多@EnableXXXX功能是开启相应的功能
 * 
 * 三步：
 * 1.将业务逻辑组件和切面类都加入到容器中，告诉spring容器哪个是切面类
 * 2.在切面类上的每一个通知方法上标注通知注解，告诉spring何时何地运行（切入点表达式）
 * 3.开启基于注解的aop模式：@EnableAspectJAutoProxy
 *  * 
 */

@EnableAspectJAutoProxy   
@Configuration
public class MainAop {
	
	//注册业务逻辑类
	@Bean 
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	@Bean
	public MyAspects logAspects() {
		return new MyAspects();
	}

}
