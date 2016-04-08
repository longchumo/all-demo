package com.hexl.springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//指定为切面类
@Aspect
public class Aop {

	//重复执行代码，指定切入点表达式，拦截哪些方法；
	@Pointcut("execution(* com.hexl.springtest.aop.OrderDao.*(..))")
	public void pointcut() {
	}
	@Before("pointcut()")
	public void begin() {
		System.out.println("开始事物/异常");
	}
	@After("pointcut()")
	public void commit() {
		System.out.println("提交事物/异常");
	}
	@Around("pointcut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕前");
		pjp.proceed();
		System.out.println("环绕后");
	}
}
