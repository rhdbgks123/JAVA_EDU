package com.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/datasource-context.xml")
public class BoardMapperTest {

	@Autowired BoardMapper boardMapper;
	
	@Disabled
	@Test
	void 전체조회() {
		//given
		
		//when
//		List<BoardVO> list = boardMapper.getList();
		BoardVO board = new BoardVO();
//		board.setBoardno(3);
//		board.setBoardtitle("업데이트");
		board.setContent("업데이트테스트");
//		board.setWriter("user03");
		
//		int result = boardMapper.boardUpdate(board);
		
		int result = boardMapper.boardDelete(4);
		
		
		//then
		assertEquals(result, 1);
	}
	@Test
	void 검색() {
		BoardVO board = BoardVO.builder().title("2").writer("").build();
		List<BoardVO> list = boardMapper.getListByWriter(board);
	}
}
