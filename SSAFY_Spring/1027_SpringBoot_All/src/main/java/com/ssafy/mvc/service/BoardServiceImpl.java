package com.ssafy.mvc.service;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;
	
	public BoardServiceImpl() {
		this.boardDao = boardDao;
	}

	@Override
	public void write(Board board) {
		boardDao.insert(board);
	}

	@Override
	public void remove(int id) {
	}

	@Override
	public void modify(Board board) {
		// TODO Auto-generated method stub
		
	}
	
	
}
