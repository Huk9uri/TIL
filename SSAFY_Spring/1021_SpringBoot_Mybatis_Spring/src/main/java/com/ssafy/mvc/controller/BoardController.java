package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.service.BoardService;


/* @Component 삼형제
 * 1. controller
 * 2. service
 * 3. repository
 * 인터셉터, 파일 다운로드 뷰, 필터 --> 컴포넌트
*/

@Controller
public class BoardController {
	
	private BoardService boardService;
	
	public BoardController(BoardService boardService){
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		// 게시글들을 가져와야한다.
		List<Board> boards = boardService.getBoardList();
		for(Board board : boards) {
			System.out.println(board.toString());
		}
		//////////////////////////////////
		model.addAttribute("boards",boards);
		//포워드 : 
		//리다이렉트 : 
		return "/board/list";
	}
	

}
