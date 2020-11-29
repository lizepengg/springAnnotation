package com.lzp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspects {
	
	/* 抽取公共切点表达式 
	 * 1.本类引用
	 * 2.其他类引用
	 * */
	@Pointcut("execution(public int com.lzp.aop.MathCalculator.*(..))")
	public void ponitCut() {}
	
	
	@Before("ponitCut()")     //切入点为方法。
	public void logStart(JoinPoint joinPoint) {
		System.out.println("除法运行。。。参数列表是："+joinPoint.getSignature().getName());
	}
	
	@After("ponitCut()")  //外部切面使用需要用ponitCut()的全类名方法名
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName()+"除法结束。。。");
	}
	
	@AfterReturning(value = "ponitCut()",returning = "result")
	public void logReturn(Object result) {
		System.out.println("除法正常返回，运行结果是："+result);
	}
	
	@AfterThrowing(value = "ponitCut()",throwing = "exception")
	public void logException(Exception exception) {
		System.out.println("除法异常输出的错误信息是"+exception);
	}

	@Around("ponitCut()")
	public Object logRound(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("方法开始执行");
		Object proceed = pjp.proceed();
		System.out.println("方法执行结束");
		return proceed;
	}
}
