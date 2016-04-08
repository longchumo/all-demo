package com.hexl.springtest.springxml;

public class User {
	private String userName;
	private String cardId;
	public User(){
		System.out.println("User对象创建,无参数");
	}
	public User(String name){
		this.userName=name;
		System.out.println("User对象创建，带参数"+name);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
