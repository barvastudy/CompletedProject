//package org.coffee.barva.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.log4j.Logger;
//import org.coffee.barva.dao.BoardMapper;
//import org.coffee.barva.domain.BoardVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class TestController {
//	private Logger log=Logger.getLogger(this.getClass());
//	@Autowired
//	private BoardMapper boardMapper;
//	@RequestMapping("insertBoard.do")
//	public void insertBoard(HttpServletResponse response) throws IOException{
//		BoardVO boardVO=new BoardVO();
//		for(int i=0;i<30000;i++){
//			boardVO.setContent(String.valueOf(i));
//			boardVO.setTitle(String.valueOf(i));
//			boardVO.setUser(1);
//			boardMapper.insertBoard(boardVO);
//		}
//		 PrintWriter i=response.getWriter();
//		 i.print("success");
//	}
//	@RequestMapping("test.do")
//	public String test(){
//		BoardVO board=new BoardVO();
//		log.info(board);
//		log.info(boardMapper.getBoard(null).size());
//		board.setTitle("34");
//		log.info(boardMapper.getBoard(board).size());
//		board=new BoardVO();
//		board.setContent("34");
//		log.info(boardMapper.getBoard(board).size());
//		board=new BoardVO();
//		board.setUser(2);
//		log.info(boardMapper.getBoard(board).size());
//		
//		return "home";
//	}
//	@RequestMapping("/")
//	public String test1(){
//		return "home";
//	}
//}
