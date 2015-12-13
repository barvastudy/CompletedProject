package org.coffee.barva.service;

import java.util.List;

import org.coffee.barva.dao.BoardMainMapper;
import org.coffee.barva.domain.BoardMainVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardMainServiceImpl implements BoardMainService{
	@Autowired
	BoardMainMapper boardMainMapper;
	
	@Override
	public BoardMainVO boardMainSelect(){
		return boardMainMapper.boardMainSelect();
	}

	@Override
	public List<BoardMainVO> boardMainSelectAll() {
		// TODO Auto-generated method stub
		return boardMainMapper.boardMainSelectAll();
	}

	@Override
	public BoardMainVO boardModifySelect(String seq) {
		// TODO Auto-generated method stub
		return boardMainMapper.boardModifySelect(seq);
	}

	@Override
	public void updateBoard(BoardMainVO boardMainVO) {
		// TODO Auto-generated method stub
		boardMainMapper.updateBoard(boardMainVO);
	}

	@Override
	public void insertBoard(BoardMainVO boardMainVO) {
		// TODO Auto-generated method stub
		boardMainMapper.insertBoard(boardMainVO);
	}

	@Override
	public void insertBoard(String title, String content, String seq) {
		// TODO Auto-generated method stub
		boardMainMapper.insertBoard(title,content,seq);
	}

	@Override
	public void deleteBoard(String deleteWhere) {
		// TODO Auto-generated method stub
		boardMainMapper.deleteBoard(deleteWhere);
	}

	@Override
	public void deleteBoard(List<String> list) {
		// TODO Auto-generated method stub
		boardMainMapper.deleteBoard(list);
	}
}
