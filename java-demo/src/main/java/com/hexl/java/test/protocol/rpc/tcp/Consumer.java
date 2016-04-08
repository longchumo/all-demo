package com.hexl.java.test.protocol.rpc.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class Consumer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//接口名称
		String itfName=SayHelloService.class.getName();
		//需要远程执行的方法
		Method mtd=SayHelloService.class.getMethod("sayHello", java.lang.String.class);
		//需要传递到远端的参数
		Object[] aguments={"hello"};
		Socket sk=new Socket("127.0.0.1",1234);
		
		//将方法名称和参数传递到远端
		ObjectOutputStream output=new ObjectOutputStream(sk.getOutputStream());
		output.writeUTF(itfName);
		output.writeUTF(mtd.getName());
		output.writeObject(mtd.getParameterTypes());
		output.writeObject(aguments);
		
		//从远端读取方法执行结果
		ObjectInputStream input=new ObjectInputStream(sk.getInputStream());
		Object result=input.readObject();
		
		//使用代理对象来处理，直接返回String对象
		System.out.println(result);
	}

}
