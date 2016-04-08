package com.hexl.hessianitf.impl;

import com.hexl.hessianitf.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String helloWorld(String message) {
		// TODO Auto-generated method stub
		return "hello," + message;

	}

}
