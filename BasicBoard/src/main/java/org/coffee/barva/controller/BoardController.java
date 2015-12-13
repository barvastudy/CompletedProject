package org.coffee.barva.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.coffee.barva.domain.BoardVO;
import org.coffee.barva.service.BoardService;
import org.coffee.barva.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("board")
@SessionAttributes("user")
public class BoardController {
	private Logger log=Logger.getLogger(this.getClass());
	@Autowired
	private BoardService boardServiceImpl;
	@RequestMapping(value="boardList.do",method=RequestMethod.GET)
	public String boardList(
			@RequestParam(value="page",required = false,defaultValue = "1")int page,
			@RequestParam(value="pageCount",required = false,defaultValue = "20")int pageCount,
			@RequestParam(value="searchCondition",required = false)Integer searchCondition,
			@RequestParam(value="searchKeyword",required = false)String searchKeyword,
			Model model){
		BoardVO board=null;
		if(searchCondition!=null&&searchCondition!=0&&searchKeyword!=null&&!searchKeyword.equals("")){
			board=new BoardVO();
			switch(searchCondition){
			case 1:
				board.setSeq(Integer.parseInt(searchKeyword));
				break;
			case 2:
				board.setTitle(searchKeyword);
				break;
			case 3:
				board.setContent(searchKeyword);
				break;
			case 4:
				board.setUser(Integer.parseInt(searchKeyword));
				break;
			}
		}
	
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startNum",((page-1)*pageCount)+1);
		map.put("pageCount", pageCount);
		map.put("board",board);
		log.info(board);
		log.info(map.toString());
		model.addAttribute("totalCount",boardServiceImpl.getTotalCount(board));
		log.info(boardServiceImpl.getTotalCount(board));
		model.addAttribute("boardList",boardServiceImpl.getBoard(map));
		model.addAttribute("pageCount",pageCount);
		model.addAttribute("page",page);
		model.addAttribute("searchCondition",searchCondition);
		model.addAttribute("searchKeyword",searchKeyword);								
		return "board/boardListView";
	}
	@RequestMapping(value="board.do",method=RequestMethod.GET)
	public String getBoard(int seq,Model model){
		log.info(boardServiceImpl.getBoardSeq(seq));
		model.addAttribute("board",boardServiceImpl.getBoardSeq(seq));
		return "board/boardView";
	}
	@RequestMapping(value="insertBoard.do",method=RequestMethod.GET)
	public String insertBoardView(){
		return "board/insertBoardView";
	}
	@RequestMapping(value="insertBoard.do",method=RequestMethod.POST)
	public String insertBoard(BoardVO board,Model model) throws Exception{
		model.addAttribute("board",boardServiceImpl.insertBoard(board));
		return "board/boardView";
		
	}
	@RequestMapping(value="updateBoard.do",method=RequestMethod.GET)
	public String updateBoardView(int seq,Model model){
		model.addAttribute("board",boardServiceImpl.getBoardSeq(seq));
		return "board/boardUpdateView";
	}
	@RequestMapping(value="updateBoard.do",method=RequestMethod.POST)
	public String updateBoard(BoardVO board){
		boardServiceImpl.updateBoard(board);
		return "redirect:/board/board.do?seq="+board.getSeq();
	}
	
	@RequestMapping(value="deleteBoard.do",method=RequestMethod.GET)
	public String deleteBoard(int seq){
		return "redirect:/board/boardList.do";
	}
}
