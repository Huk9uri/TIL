package com.ssafy.mvc.model.dao;

import com.ssafy.mvc.model.dto.Board;

public interface BoardDao {
	// 1. 게시글 작성
	public int insert(Board board);
	// 2. 게시글 삭제
	public int delete(int id);
	// 3. 게시글 수정
	public void update(Board board);
	
}
