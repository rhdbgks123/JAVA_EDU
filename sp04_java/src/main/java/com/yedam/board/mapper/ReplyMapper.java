package com.yedam.board.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.board.service.ReplyVO;

public interface ReplyMapper {
	
	//등록
	int replyInsert(ReplyVO reply);
	//수정
	int replyUpdate(ReplyVO reply);
	//삭제
	int replyDelete(Long rno);

	List<ReplyVO> getList(Long bno);
	
	ReplyVO	getReply(int rno);
}
