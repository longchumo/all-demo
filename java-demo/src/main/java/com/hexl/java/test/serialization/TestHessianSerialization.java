package com.hexl.java.test.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

public class TestHessianSerialization {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		Person zhangsan=new Person();
		zhangsan.setAddress("beijing");
		zhangsan.setAge(30);
		zhangsan.setBirth(new Date());
		zhangsan.setName("zhangsan");
		
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		//hessian序列化输出
		HessianOutput ho=new HessianOutput(os);
		ho.writeObject(zhangsan);
		byte[] zhangsanbyte=os.toByteArray();
		
		ByteArrayInputStream is=new ByteArrayInputStream(zhangsanbyte);
		//hessian反序列化
		HessianInput hi=new HessianInput(is);
		Person ps =(Person)hi.readObject();
		System.out.println(ps.getName()+"--"+ps.getAge());
		
	}

}
