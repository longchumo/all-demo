package com.hexl.hessianitf;


import java.net.MalformedURLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class HessianClient {    
     @SuppressWarnings("resource")
     @Test
     public void testService() throws MalformedURLException {
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         HelloService hello = (HelloService) context.getBean("hessianClient");
         System.out.println(hello.helloWorld("jimmy.yang"));
        
     }
}