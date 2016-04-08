package com.hexl.springtest.springzhujie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("userDao")
@Repository
public class UserDao {
	public void save(){
		System.out.println("保存了");
	}
}
