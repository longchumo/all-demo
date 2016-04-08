package com.hexl.java.test.protocol.rpc.tcp;

public class SayHelloServiceImpl implements SayHelloService {

	public String sayHello(String hello) {
		// TODO Auto-generated method stub
		if(hello.equals("hello"))
			return "hello too";
		else
			return "byebye";
	}

}
