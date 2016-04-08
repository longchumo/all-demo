package com.hexl.springtest.springzhujie;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")//userService加入IOC容器
public class UserService  {
	//从IOC容器找到对象，注入该属性
	@Resource(name="userDao")
	private UserDao userDao;
	
	public void save(){
		userDao.save();
	}
}
