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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TestXMLSerialization {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Person zhangsan=new Person();
		zhangsan.setAddress("beijing");
		zhangsan.setAge(30);
		zhangsan.setBirth(new Date());
		zhangsan.setName("zhangsan");
		
		//将person对象序列化为xml
		XStream xs=new XStream(new DomDriver());
		//设置person别名
		xs.alias("person",Person.class);
		String personXML=xs.toXML(zhangsan);
		//XML反序列化为person
		
		Person ps =(Person)xs.fromXML(personXML);
		
		System.out.println(personXML);
		System.out.println(ps.getName()+"--"+ps.getAge());
		
	}

}
