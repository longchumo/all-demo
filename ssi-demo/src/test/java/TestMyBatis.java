

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hexl.service.ICityService;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:mybatis/spring-mybatis.xml"})

public class TestMyBatis {
	@Resource
	private ICityService cityService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		String user = cityService.getCityById(1);
		 System.out.println(user);
		// logger.info("值："+user.getUserName());
	}
}