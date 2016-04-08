package com.hexl.controller;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hexl.pojo.City;
import com.hexl.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)		//��ʾ�̳���SpringJUnit4ClassRunner��
@ContextConfiguration(locations = {"classpath:mybatis/spring-mybatis.xml"})
public class CityController {

	@Resource(name="cityService")
	public ICityService cityService;
	
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	//ֱ�����õ��������sql
	@Test
	public void test1() {
		int cityId = 1;
		String cityName = this.cityService.getCityById(cityId);
		System.out.println(cityName);
	}
	//��session�����ֹ�����
	@Test
	public void test2() {
		
		SqlSession session = null; 
		try {
			
			SqlSessionFactory sf=sqlSessionFactoryBean.getObject();
			session = sf.openSession(false);//�򿪻Ự�����￪ʼ 
			//����һ
			City cc =(City)session.selectOne("com.hexl.dao.CityDao.selectByPrimaryKey", 1);
			//��������
			//CityDao citydao=session.getMapper(CityDao.class);
			//City cc=citydao.selectByPrimaryKey(1);
			session.commit();
			System.out.println(cc.getCity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        session.close();
	    }
	}
	//�������
	@Test
	@Transactional
	public void test3(){
		City city=new City();
		city.setId(902);
		city.setCity("����"+city.getCityid());
		City city2=new City();
		city2.setId(903);
		city2.setCity("����"+city2.getCityid());
		cityService.insert(city);
		int i=1/0;
		cityService.insert(city2);
	}
	
}

