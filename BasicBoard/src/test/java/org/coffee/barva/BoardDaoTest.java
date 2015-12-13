package org.coffee.barva;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.coffee.barva.dao.BoardMapper;
import org.coffee.barva.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
"file:src/main/resources/config/*-context.xml"})
public class BoardDaoTest {
	private Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private BoardMapper boardMapper;
	@Test
	public void test(){
		Map<String,Object> map=new HashMap<String,Object>();
		BoardVO board=new BoardVO();
		board.setTitle("1");
		map.put("board",board);
		map.put("startNum", 2);
		map.put("pageCount", 20);
		assertEquals(boardMapper.getBoard(map).size(),10);

	}
}
