package com.yedam.emp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.config.DataSourceConfig;
import com.yedam.config.MybatisConfig;
import com.yedam.config.RootConfig;
import com.yedam.emp.mapper.EmpMapper;

@SpringJUnitConfig(classes = {DataSourceConfig.class, MybatisConfig.class, RootConfig.class})
public class EmployeeTest {

	@Autowired EmpMapper empMapper;
	
	@Test
	public void 단건조회() {
		int empid = 100;
		String lastName = "King";
		
		//when
		Map map = empMapper.selectone(100);
		
		//then
		assertEquals(map.get("LAST_NAME"), lastName);
	}
	
}
