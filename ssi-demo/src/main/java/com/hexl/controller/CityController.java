package com.hexl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hexl.service.ICityService;

@Controller
@RequestMapping("/city")
public class CityController {
	@Resource(name="cityService")
	private ICityService cityService;
	//http://localhost:8080/ssi-demo/city/showCity.html?id=1
	@RequestMapping("/showCity")
	public String toIndex(HttpServletRequest request,Model model){
		int cityId = Integer.parseInt(request.getParameter("id"));
		String cityName = this.cityService.getCityById(cityId);
		model.addAttribute("cityname", cityName);
		System.out.println("contrler");
		return "showCity";
	}
}
