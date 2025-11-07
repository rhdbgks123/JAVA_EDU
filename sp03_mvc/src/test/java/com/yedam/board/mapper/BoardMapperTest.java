package com.yedam.board.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardMapperTest {

	@Autowired BoardMapper boardMapper;
	
	@Test
	void 삭제() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", 9);
		map.put("result", "");
		int result = boardMapper.boardDelete(map);
		System.out.println(map.get("result"));
	}
}
