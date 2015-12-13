package org.coffee.barva;

import org.coffee.barva.domain.BoardVO;
import org.coffee.barva.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("boardselect")
	public String boardSelect(BoardVO boardVO, Model model){
		
		logger.info("boardselect called.......");
		
		boardVO = boardService.boardSelect();
		model.addAttribute(boardVO);
		
		return "result";
	}
}
