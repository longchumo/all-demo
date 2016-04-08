package com.hexl.java.test.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TansferBytesTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		testInput();
	}
	
	/*
	 * 1、只有BufferedReader可以读一行
	 * 2、InputStreamReader用于将字节流转化成字符流
	 */
	public static void testInput() throws Exception{
		InputStream in=System.in;
		//每次只读取一个字节
		//int content=in.read();
		InputStreamReader isr=new InputStreamReader(in);
		BufferedReader bfr=new BufferedReader(isr);
		String content=bfr.readLine();
		System.out.println("控制台输入="+content);
	}
	
	public static void writeFile() throws IOException{
		FileOutputStream fos=new FileOutputStream("F:\\a.txt");
		OutputStreamWriter wt=new OutputStreamWriter(fos,"utf-8");
		wt.write("大家好");
		//关闭资源
		wt.close();
	}
	/*
	 * 1、utf8写入的信息不能直接用FileReader读入；
	 * 2、如果需要进行转码，则只能通过Input(Output)StreamReader进行转换；
	 */
	public static void readFile() throws IOException{
		FileInputStream fis=new FileInputStream("F:\\a.txt");
		InputStreamReader rd=new InputStreamReader(fis,"utf-8");
		int content=0;
		while((content=rd.read())!=-1)
			System.out.println((char)content);
		//关闭资源
		fis.close();
	}
	
}
