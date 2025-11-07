package com.yedam.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyController {
	@Autowired ReplyService replyService;

	//등록
	@PostMapping("/reply")
	public int insertReply(@RequestBody ReplyVO reply){
		return replyService.replyInsert(reply);
		// {result:"success", data:""}
	}
	
	//삭제
	@DeleteMapping("/reply/{rno}")
	public int deleteReply(@PathVariable("rno") Long rno) {
		return replyService.replyDelete(rno);
	}
	//전체조회
	@GetMapping("/board/{bno}/reply")
	public List<ReplyVO> selectReply(@PathVariable("bno") Long bno){
		return replyService.getList(bno);
	}
}
