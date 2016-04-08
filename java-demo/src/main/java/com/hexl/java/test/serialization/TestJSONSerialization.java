package com.hexl.java.test.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.Date;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

public class TestJSONSerialization {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Person zhangsan=new Person();
		zhangsan.setAddress("beijing");
		zhangsan.setAge(30);
		zhangsan.setBirth(new Date());
		zhangsan.setName("zhangsan");
		
		//json序列化
		String personJson=null;
		ObjectMapper mapper=new ObjectMapper();
		StringWriter sw=new StringWriter();
		JsonGenerator gen=new JsonFactory().createJsonGenerator(sw);
		mapper.writeValue(gen, zhangsan);
		gen.close();
		personJson=sw.toString();
		
		//json反序列化
		Person ps =(Person)mapper.readValue(personJson, Person.class);
		
		System.out.println(personJson);
		System.out.println(ps.getName()+"--"+ps.getAge());
		
	}

}
