package com.hexl.service;

import com.hexl.pojo.City;

public interface  ICityService {
	public String getCityById(int cityId);
	
	public int insert(City record);
}
