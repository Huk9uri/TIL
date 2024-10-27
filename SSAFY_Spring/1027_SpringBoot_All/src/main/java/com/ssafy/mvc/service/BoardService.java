package com.ssafy.mvc.service;

import com.ssafy.mvc.model.dto.Board;

public interface BoardService {
	// 1. 게시글 작성
	public void write(Board board);
	// 2. 게시글 삭제
	public void remove(int id);
	// 3. 게시글 수정
	public void modify(Board board);
	
}
