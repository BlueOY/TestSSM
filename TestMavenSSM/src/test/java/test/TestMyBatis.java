package test;

/**
 * 参考资料：http://blog.csdn.net/gebitan505/article/details/44455235/
 */

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.trajectory.service.ITestService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	private ApplicationContext ac = null;
	@Resource
	private ITestService testService = null;
	
//	@Before
//	public void before() {  
//		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");  
//		testService = (ITestService) ac.getBean("testService");  
//	}
	
	@Test
	public void test() {
		System.out.println("test");
		com.trajectory.pojo.Test test = testService.getTestById(1);
		System.out.println("test="+JSON.toJSONString(test));
		logger.info(JSON.toJSONString(test));
	}
	
//	@Test
//	public void test() {
//		System.out.println("test");
//	}

}
