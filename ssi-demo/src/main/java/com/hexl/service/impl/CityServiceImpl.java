package com.hexl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexl.dao.CityDao;
import com.hexl.pojo.City;
import com.hexl.service.ICityService;

@Service("cityService")
public class CityServiceImpl implements ICityService {
	@Autowired
	private CityDao cityDao;
	@Override
	public String getCityById(int cityId) {
		// TODO Auto-generated method stub
		City city=cityDao.selectByPrimaryKey(cityId);
		System.out.println("ddd"+city.getCity());
		return city.getCity();
	}

}