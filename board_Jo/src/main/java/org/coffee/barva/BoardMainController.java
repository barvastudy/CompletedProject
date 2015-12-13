package org.coffee.barva;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.coffee.barva.domain.BoardMainVO;
import org.coffee.barva.service.BoardMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BooleanDeserializer;
import com.google.gson.Gson;

@Controller
public class BoardMainController {
	@Autowired
	BoardMainService boardMainService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardMainController.class);
	
	//@RequestMapping(value="/boardMain.do", method = RequestMethod.GET)
	public String controlPage(){
		return "board_0001";
	}
		
	@RequestMapping("boardMainSelect")
	public String boardMainSelect(BoardMainVO boardMainVO, Model model){
		
		logger.info("boardMainSelect called....!!!!!!");
		
		boardMainVO = boardMainService.boardMainSelect();
		
		model.addAttribute(boardMainVO);
		
		return "board_0002";
	}
	
	//@RequestMapping("boardMainSelectAll")
	@RequestMapping(value="/boardMain.do", method = RequestMethod.GET)
	public String boardMainSelectAll(BoardMainVO boardMainVO, Model model){
		logger.info("boardMainSelectAll called....!!!!!!");
		
		List<BoardMainVO> list = boardMainService.boardMainSelectAll();
		
		for(int i=0;i<list.size();i++){
			logger.info(list.get(i).toString());
		}
		
		model.addAttribute("boardMainVO",new Gson().toJson(list));
		
		return "board_0002";
	}
	
	@RequestMapping(value="/boardModify.do", method = RequestMethod.GET)
	public String boardModifySelect(BoardMainVO boardMainVO, Model model, @RequestParam("SEQ") String seq){
		logger.info("boardModifySelect called.....!!!!!!!");
		
		boardMainVO = boardMainService.boardModifySelect(seq);
		model.addAttribute(boardMainVO);
		
		logger.info(boardMainVO.getTitle() + "     " + boardMainVO.getContent());
		
		return "board_0002_01";
	}
	
	// update
	@RequestMapping(value="/updateBoard.do", method=RequestMethod.POST)
	public String updateBoard(BoardMainVO boardMainVO,HttpServletRequest request){
		
		logger.info("updateBoard called........!!!!!!!");
		
		/*String seq = request.getParameter("SEQ");
		String title = request.getParameter("TITLE");
		String content = request.getParameter("CONTENT");*/
		
		
		logger.info(boardMainVO.toString());
		//logger.info("seq: " + seq + ", title: " + title + ", content: " + content);
		
		boardMainService.updateBoard(boardMainVO);
		return "redirect:/boardMain.do";
	}
	
	/*@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public void insertBoard(BoardMainVO boardMainVO,HttpServletRequest request){
		
		logger.info("insertBoard.do called..........!!!!!!!!!!!!");
		
		logger.info(boardMainVO.toString());
		
		boardMainService.insertBoard(boardMainVO);
		
		//boardMainService
	}*/
	
	
	
	@RequestMapping(value="/insertBoardPopUp.do", method=RequestMethod.GET)
	public String insertBoardPopUp(){
		logger.info("insertBoardPopUp called...........!!!!!!!!");
		
		return "board_0002_02";
	}
	
	// insert
	@RequestMapping(value="/testMethod.do", method=RequestMethod.POST)
	public String testMethod(BoardMainVO boardMainVO,HttpServletRequest request){
		logger.info("testMethod......!!!!!");
		logger.info(boardMainVO.toString());
		
		boardMainService.insertBoard(boardMainVO);
		
		return "redirect:/boardMain.do";
	}
	
	@RequestMapping(value="/insertBoard1.do", method=RequestMethod.POST)
	public void insertBoard1(BoardMainVO boardMainVO,HttpServletRequest request){		
		logger.info("insertBoard1.do.......!!!!!");
		logger.info(boardMainVO.toString());
	}
	
	@RequestMapping(value="/deleteBoard.do", method=RequestMethod.GET)
	public String deleteBoard(@RequestParam("deleteWhere") String deleteWhere,HttpServletRequest request
			,@RequestParam(value="checkList",required=false, defaultValue="10") List<String> list
			){
		logger.info("deleteBoard.do.......!!!!!");
		
		for(String temp: list){
			logger.info(temp);
		}
		//boardMainService.deleteBoard(deleteWhere);
		boardMainService.deleteBoard(list);
		
		return "redirect:/boardMain.do";
	}
}
