package com.hexl.java.test.protocol.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(4567);
		while(true){
			Socket client=server.accept();
			//读取客户端请求数据
			InputStream input=client.getInputStream();
			Request req=ProtocolUtil.readRequest(input);
			OutputStream output=client.getOutputStream();
			//组装相应
			Response res=new Response();
			res.setEncode(Encode.UTF8.getValue());
			if(req.getCommand().equals("HELLO")){
				res.setResponse("server:hi,ni ye hello");
			}else
				res.setResponse("server:bye");
			
			res.setResponseLength(res.getResponse().length());
			ProtocolUtil.writeResponse(output, res);
			client.shutdownOutput();
		}
	}

}
