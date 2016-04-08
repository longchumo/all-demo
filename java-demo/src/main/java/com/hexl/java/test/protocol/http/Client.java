package com.hexl.java.test.protocol.http;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/*
 * 模拟http协议请求与相应，包括：
 * 客户端组装请求
 * 服务端处理请求
 * 协议对客户端和服务端请求的解析
 */
public class Client {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//构建请求
		Request req=new Request();
		req.setCommand("HELLO");
		req.setCommandLength(req.getCommand().length());
		req.setEncode(Encode.UTF8.getValue());
		
		System.out.println("commondlength="+req.getCommandLength());
		System.out.println("commond="+req.getCommand());
		//向服务器发送数据
		Socket client=new Socket("127.0.0.1",4567);
		OutputStream output=client.getOutputStream();
		ProtocolUtil.writeRequest(output, req);
		
		//读取响应数据
		InputStream input=client.getInputStream();
		Response res=ProtocolUtil.readResponse(input);
		client.shutdownOutput();
		
		System.out.println("responselength:"+res.getResponseLength());
		System.out.println("response:"+res.getResponse());
	}

}
