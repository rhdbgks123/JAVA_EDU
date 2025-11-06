package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;



public interface BoardMapper {

	
	//등록
	int boardInsert(BoardVO board);
	//수정
	int boardUpdate(BoardVO board);
	//삭제
	int boardDelete(int boardno);
	//단건조회
	
	//전체조회
//	@Select("select * from tbl_board")
	List<BoardVO> getList();
	//페이징 - 전체건수 조회
	List<BoardVO> getListByWriter(BoardVO board);
	
	
	
}
