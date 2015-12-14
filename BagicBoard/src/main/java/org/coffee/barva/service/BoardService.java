package org.coffee.barva.service;

import java.util.List;
import java.util.Map;

import org.coffee.barva.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoard(Map<String,Object> map);
	public BoardVO getBoardSeq(int seq);
	public int getTotalCount(BoardVO board);
	public BoardVO insertBoard(BoardVO board)throws Exception;
	public int updateBoard(BoardVO board);
}
