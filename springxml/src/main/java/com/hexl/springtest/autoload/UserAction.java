package com.hexl.springtest.autoload;

public class UserAction {
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void execute(){
		userService.save();
	}
}
