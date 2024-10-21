package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	@Override
	public List<Board> getBoardList() {
		System.out.println("게시글 모두 가져오기 성공");
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		System.out.println(id + "번 글을 불러옵니다.");
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
		
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
		System.out.println("게시글 작성 완료");
	}

	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
		System.out.println("게시글 삭제 완료");
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
		System.out.println("게시글 수정 완료");
	}

}
