package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		System.out.println("게시글 목록 불러오기 완료");
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id + "번 글을 읽어옵니다");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}
	
	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성..");
		boardDao.insertBoard(board);
	}
	@Transactional
	@Override
	public void removeBoard(int id) {
		System.out.println("게시글 삭제합니다");
		boardDao.deleteBoard(id);
	}
	@Transactional
	@Override
	public void modifyBoard(Board board) {
		System.out.println("게시글 수정합니다.");
		boardDao.updateBoard(board);
	}

	@Override
	public List<Board> search(SearchCondition condition) {
		System.out.println("게시글 검색");
		return boardDao.search(condition);
	}

}
