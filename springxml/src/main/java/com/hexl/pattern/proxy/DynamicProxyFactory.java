package com.hexl.pattern.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class DynamicProxyFactory {
	private IUserDaoA target;
	public DynamicProxyFactory(IUserDaoA iUserDaoA){
		target=iUserDaoA;
	}
	//给目标对象生成代理对象
	public  Object getProxyInstance(){
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			
			public Object invoke(Object arg0, Method arg1, Object[] arg2)
					throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("--动态开始事物--");
				Object returnValue=arg1.invoke(target,arg2);
				System.out.println("--动态结束事物--");
				
				return returnValue;
			}
		});
	}
}
