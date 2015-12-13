package org.coffee.barva.service;

import org.coffee.barva.dao.BoardMapper;
import org.coffee.barva.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public BoardVO boardSelect() {
		return boardMapper.boardSelect();
	}
}
