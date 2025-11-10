package com.example.demo.emp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmpServiceTest {

	@Autowired EmpService empService;
	
	@Test
	public void 단건조회() {
		//given
		
		EmpVO emp = new EmpVO();
		emp.setEmployeeId("100");
		
		EmpVO result = empService.getEmp(emp);
		
		assertEquals(result.getEmployeeId(), emp.getEmployeeId());
	}
	
	@Test
	public void 전체조회() {
		String firstName = "Alexander";
		EmpVO vo = new EmpVO();
		List<EmpVO> result = empService.getEmpList(vo);
		
		assertEquals(result.get(0).getFirstName(), firstName);
	}
}
