package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;
import com.example.demo.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper replyMapper; 
	
	@Override
	public int replyInsert(ReplyVO reply) {
		// TODO Auto-generated method stub
		return replyMapper.replyInsert(reply);
	}

	@Override
	public int replyUpdate(ReplyVO reply) {
		// TODO Auto-generated method stub
		return replyMapper.replyUpdate(reply);
	}

	@Override
	public int replyDelete(Long rno) {
		// TODO Auto-generated method stub
		return replyMapper.replyDelete(rno);
	}

	@Override
	public ReplyVO getReply(int rno) {
		// TODO Auto-generated method stub
		return replyMapper.getReply(rno);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		// TODO Auto-generated method stub
		return replyMapper.getList(bno);
	}

}
