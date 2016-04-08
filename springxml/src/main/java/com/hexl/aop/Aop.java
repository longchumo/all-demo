package com.hexl.aop;

import org.aspectj.lang.ProceedingJoinPoint;



public class Aop {

	//重复执行代码，指定切入点表达式，拦截哪些方法；
	public void pointcut() {
	}
	public void begin() {
		System.out.println("开始事物/异常");
	}
	public void commit() {
		System.out.println("提交事物/异常");
	}
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕前");
		pjp.proceed();
		System.out.println("环绕后");
	}
}
