package org.coffee.barva.service.Impl;

import java.util.List;
import java.util.Map;

import org.coffee.barva.dao.BoardMapper;
import org.coffee.barva.dao.CommonMapper;
import org.coffee.barva.domain.BoardVO;
import org.coffee.barva.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private CommonMapper commonMapper;
	@Override
	public List<BoardVO> getBoard(Map<String,Object> map) {
		// TODO Auto-generated method stub	
		return boardMapper.getBoard(map);
	}
	@Override
	public int getTotalCount(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(board);
	}
	@Override
	public BoardVO insertBoard(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.insertBoard(board);
		int a=1;
		if(a==1)
			throw new Exception();
		return board;
	}
	@Override
	public BoardVO getBoardSeq(int seq) {
		// TODO Auto-generated method stub
		return boardMapper.getBoardSeq(seq);
	}
	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.updateBoard(board);
	}


}
