package org.coffee.barva;

import static org.junit.Assert.assertEquals;

import org.coffee.barva.dao.UserMapper;
import org.coffee.barva.domain.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/resources/config/*-context.xml"})
public class UserDaoTest {


	@Autowired
	private UserMapper userMapper;
	@Test
	public void test(){
	//	UserVO user=new UserVO();
		assertEquals(userMapper.getUser(null).size(), 4);
	}
}
