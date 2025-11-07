package com.yedam.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired BoardService boardService;
	
	//JSON 반환
	
	@GetMapping("/api/board")
	@ResponseBody
	public List<BoardVO> selectJson() {
		return boardService.getList();
	}
	
	//전체조회
	@GetMapping("/board")
	public String selectall(Model model) {
		model.addAttribute("list", boardService.getList());
		return "board/list";
	}
//	@GetMapping("/board/register")
//	public String registerpage() {
//		return "board/register";
//	}
	
	@PostMapping("/board/register")
	public String register(BoardVO board) {
		if(board.getBno() > 0)
			boardService.boardUpdate(board);
		else
			boardService.boardInsert(board);
		return "redirect:/board";
	}

	@GetMapping("/board/register")
	public String updatepage(Model model, @RequestParam(name="bno", required = false) Integer bno) {
		BoardVO vo = new BoardVO();
		if(bno != null)
		{
			vo = boardService.getBoard(bno);
		}
		model.addAttribute("board", vo);
		return "board/register";
	}
	
	@PostMapping("/board/delete")
	public String delete(@RequestParam Map<String, Object> map) {
	    boardService.boardDelete(map);
		return "redirect:/board";
	}
	
	@GetMapping("/board/info/{bno}")
	public String info(@PathVariable("bno") int bno, Model model) {
		model.addAttribute("board",boardService.getBoard(bno));
		return "board/info";
	}

}
