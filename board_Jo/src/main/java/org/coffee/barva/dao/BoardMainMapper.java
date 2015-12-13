package org.coffee.barva.dao;

import java.util.List;

import org.coffee.barva.domain.BoardMainVO;

public interface BoardMainMapper {
	public BoardMainVO boardMainSelect();
	public List<BoardMainVO> boardMainSelectAll();
	public BoardMainVO boardModifySelect(String seq);
	public void updateBoard(BoardMainVO boardMainVO);
	public void insertBoard(BoardMainVO boardMainVO);
	public void insertBoard(String title, String content, String seq);
	public void deleteBoard(String deleteWhere);
	public void deleteBoard(List<String> list);
}
