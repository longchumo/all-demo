package com.hexl.java.test.serialization;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7706689488150055928L;
	private String name;
	private int age;
	private String address;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
