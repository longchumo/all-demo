package com.hexl.springtest.springzhujie;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component("userAction")
@Controller
public class UserAction {
	@Resource(name="userService")
	private UserService userService;
	
	
	public void execute(){
		userService.save();
	}
}
