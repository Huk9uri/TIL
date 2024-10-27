package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BoardController {

	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("/list")
	public String list(Model model) {
		// 서비스를 통해서 게시글들을 가져와야 한다.
		List<Board> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		
		// list라는 boardlist를 boards 넣어서
		// 모델 바구니 담아서
		// board/ list.jsp 보냈잖아
		
		
		return "/board/list";
	}
	
	@GetMapping("/writeform")
	public String writeform() {
		return "/board/writeform";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		System.out.println("작성 완료 ");
		//게시글 등록 --> 1.전체 목록으로 간다.
		//게시글 등록 --> 2.상세 보기로 간다.
		// 모두 리다이렉트로 보낸다.
		// 왜? -- 고민해보기 
		//게시글 등록 --> 1.전체 목록으로 간다.
		
		//작성한다. 라는 요청이 남아있어
		// 새로운 요청을 받지
		// 요청이 덮어써지니까
		return "/board/list";
		//list라는 요청 다시 호출
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	//post 요청으로 처리 해볼것
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		//
		// 삭제를 하고 목록 화면으로 보내겠다.
		
		return "redirect:list";
		// 클라이언트에게 list get 방식 요청 해 
	}
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("id") int id, Model model) {
		//게시글을 하나 가지고 와서
		// updateform으로 넘겨야 한다.		// 지금은 readBoard만 있어서 이걸로 하지만
		model.addAttribute("board",boardService.readBoard(id)); // 담았으니까 일단 가져갈 수 있어.
										// 조회수가 올라가버림..
										// 쌩 게시글 하나 가져오는 메소드를 하나 구비하는 게 좋을듯
		return "board/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?=id="+board.getId();
	}
	
	@GetMapping("/search")
	public String search(@ModelAttribute SearchCondition condition, Model model) {
		model.addAttribute("boards", boardService.search(condition));
		return "/board/list";
	}
	
	
	
	
	

}
