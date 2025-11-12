package com.yedam.board.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.board.BoardVO;
import com.yedam.board.mapper.BoardMapper;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	@Autowired BoardMapper boardMapper;
	
	@GetMapping("/board")
	public String selectall(Model model, HttpServletRequest req, @CookieValue("JSESSIONID") String sessionid) {
		model.addAttribute("list", boardMapper.getList());
		System.out.println("client ip : " + req.getRemoteAddr());
		System.out.println("user-agent : " + req.getHeader("user-agent"));

		System.out.println("coockies : " + req.getCookies());
		System.out.println("COOKIES2 " + sessionid);
		return "board/list";
	}
//	@GetMapping("/board/register")
//	public String registerpage() {
//		return "board/register";
//	}
	
	@PostMapping("/board/register")
	public String register(BoardVO board) {
		if(board.getBno() > 0)
			boardMapper.boardUpdate(board);
		else
			boardMapper.boardInsert(board);
		return "redirect:/board";
	}

	@GetMapping("/board/register")
	public String updatepage(Model model, @RequestParam(name="bno", required = false) Integer bno) {
		BoardVO vo = new BoardVO();
		if(bno != null)
		{
			vo = boardMapper.getBoard(bno);
		}
		model.addAttribute("board", vo);
		return "board/register";
	}
	
	@PostMapping("/board/delete")
	public String delete(@RequestParam Map<String, Object> map) {
	    boardMapper.boardDelete(map);
		return "redirect:/board";
	}

}
