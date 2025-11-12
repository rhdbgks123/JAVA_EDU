package com.example.demo.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.service.ReplyService;
import com.example.demo.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReplyController {
	@Autowired ReplyService replyService;

	//등록
	@PostMapping("/reply")
	public Map<String, Object> insertReply(@RequestBody ReplyVO reply){
		int cnt = replyService.replyInsert(reply);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", reply);
		return map;
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
