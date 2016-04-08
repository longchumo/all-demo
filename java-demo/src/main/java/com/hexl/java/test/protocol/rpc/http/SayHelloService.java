package com.hexl.java.test.protocol.rpc.http;

import java.util.Map;

public class SayHelloService implements BaseService {

	public Object execute(Map<String, Object> args) {
		// TODO Auto-generated method stub
		String[] helloArg=(String[])args.get("args1");
		if(helloArg[0].equals("hello"))
			return "hello too";
		else
			return "byebye";
	}

}
