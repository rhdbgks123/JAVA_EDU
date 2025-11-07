package com.yedam.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.emp.Employee;

@Mapper
public interface EmpMapper {
	List<Employee> selectall();
	Map selectone(int id);
}
