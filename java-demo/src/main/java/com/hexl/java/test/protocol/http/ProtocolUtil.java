package com.hexl.java.test.protocol.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProtocolUtil {

	
	public static Request readRequest(InputStream input) throws IOException{
		//读取编码
		byte[] encodeByte=new byte[1];
		input.read(encodeByte);
		byte encode=encodeByte[0];
		
		//读取命令长度
		byte[] commondLengthBytes=new byte[4];
		input.read(commondLengthBytes);
		int commandLength=ByteUtil.bytes2Int(commondLengthBytes);
		
		//读取命令
		byte[] commondBytes=new byte[commandLength];
		input.read(commondBytes);
		String command="";
		if(Encode.GBK.getValue()==encode)
			command=new String(commondBytes,"GBK");
		else
			command=new String(commondBytes,"UTF8");
		
		//组装返回
		Request req=new Request();
		req.setCommand(command);
		req.setEncode(encode);
		req.setCommandLength(commandLength);
		
		return req;
	}
	
	public static Response readResponse(InputStream input) throws IOException{
		//读取编码
		byte[] encodeByte=new byte[1];
		input.read(encodeByte);
		byte encode=encodeByte[0];
		
		//读取响应长度
		byte[] responsedLengthBytes=new byte[4];
		input.read(responsedLengthBytes);
		int responseLength=ByteUtil.bytes2Int(responsedLengthBytes);
		
		//读取响应
		byte[] responseBytes=new byte[responseLength];
		input.read(responseBytes);
		String responseStr="";
		if(Encode.GBK.getValue()==encode)
			responseStr=new String(responseBytes,"GBK");
		else
			responseStr=new String(responseBytes,"UTF8");
		
		//组装返回
		Response res=new Response();
		res.setEncode(encode);
		res.setResponse(responseStr);
		res.setResponseLength(responseLength);
		return res;
	}
	
	public static void writeResponse(OutputStream output,Response res) throws IOException{
		//将response响应返回给客户端
		output.write(res.getEncode());
		output.write(ByteUtil.int2ByteArray(res.getResponseLength()));
		if(Encode.GBK.getValue()==res.getEncode())
			output.write(res.getResponse().getBytes("GBK"));
		else
			output.write(res.getResponse().getBytes("UTF8"));
		output.flush();
	}
	
	public static void writeRequest(OutputStream output,Request req) throws IOException{
		output.write(req.getEncode());
		output.write(ByteUtil.int2ByteArray(req.getCommandLength()));
		if(Encode.GBK.getValue()==req.getEncode())
			output.write(req.getCommand().getBytes("GBK"));
		else
			output.write(req.getCommand().getBytes("UTF8"));
		output.flush();
	}
	
}
