package com.example.demo.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	
	private final BoardMapper boardMapper;
	
	@Override
	public int boardInsert(BoardVO board) {
		return boardMapper.boardInsert(board);
	}

	@Override
	public int boardUpdate(BoardVO board) {
		return boardMapper.boardUpdate(board);
	}

	@Override
	public int boardDelete(Map<String, Object> map) {
		return boardMapper.boardDelete(map);
	}

	@Override
	public BoardVO getBoard(int bno) {
		return boardMapper.getBoard(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

	@Override
	public List<BoardVO> getListByWriter(BoardVO board) {
		return boardMapper.getListByWriter(board);
	}

}
