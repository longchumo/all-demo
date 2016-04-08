package com.hexl.java.test.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

public class TestJavaSerialization {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Person zhangsan=new Person();
		zhangsan.setAddress("beijing");
		zhangsan.setAge(30);
		zhangsan.setBirth(new Date());
		zhangsan.setName("zhangsan");
		
		//定义一个字节数组输出流
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		//对象输出流
		ObjectOutputStream out=new ObjectOutputStream(os);
		//将对象写入到字节数组输出，进行序列化
		out.writeObject(zhangsan);
		byte[] zhangsanbyte=os.toByteArray();
		
		//字节数组输入流
		ByteArrayInputStream is=new ByteArrayInputStream(zhangsanbyte);
		//反序列化，从流中读取对象
		ObjectInputStream in=new ObjectInputStream(is);
		Person ps =(Person)in.readObject();
		
		System.out.println(ps.getName()+"--"+ps.getAge());
		
	}

}
