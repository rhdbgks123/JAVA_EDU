package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

public interface ReplyService {
	
	//등록
	int replyInsert(ReplyVO reply);
	//수정
	int replyUpdate(ReplyVO reply);
	//삭제
	int replyDelete(Long rno);
	//단건조회
	ReplyVO getReply(int rno);
	//전체조회
	List<ReplyVO> getList(Long bno);
	
}
