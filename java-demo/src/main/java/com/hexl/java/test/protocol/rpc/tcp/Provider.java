package com.hexl.java.test.protocol.rpc.tcp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Provider {

	//所有服务
	private static Map<String,Object> services=new HashMap<String,Object>();
	
	static{
		services.put(SayHelloService.class.getName(), new SayHelloServiceImpl());
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(1234);
		while(true){
			Socket sk=server.accept();
			//读取服务信息
			ObjectInputStream in=new ObjectInputStream(sk.getInputStream());
			String itfName=in.readUTF();//接口名称
			String mtdName=in.readUTF();//接口方法
			Class<?>[] paraTypes=(Class<?>[])in.readObject();//参数类型
			Object[] arguments=(Object[])in.readObject();//参数
			
			//执行调用
			Class serviceItfClass=Class.forName(itfName);//得到接口的class
			Object service=services.get(itfName);//取得服务实现的对象
			Method mtd=serviceItfClass.getMethod(mtdName, paraTypes);//获得要执行的方法
			Object result=mtd.invoke(service, arguments);
			ObjectOutputStream oos=new ObjectOutputStream(sk.getOutputStream());
			oos.writeObject(result);
			
		}
	}

}
