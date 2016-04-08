package com.hexl.pattern.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Proxy;

public class CglibProxyFactory implements MethodInterceptor {
	private Object target;
	public CglibProxyFactory(Object target){
		this.target=target;
	}
	
	public  Object getProxyInstance(){
		//1、工具栏
		Enhancer en=new Enhancer();
		//2、设置父类
		en.setSuperclass(target.getClass());
		//3、设置回调函数
		en.setCallback(this);
		//4、创建子类(代理对象)
		
		return en.create();
		
	}

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		//执行目标对象的方法
		System.out.println("--开始事物");
		Object returnValue=method.invoke(target, args);
		System.out.println("--结束事物");
		return returnValue ;
	}
}
