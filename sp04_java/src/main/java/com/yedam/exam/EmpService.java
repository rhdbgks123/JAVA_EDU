package com.yedam.exam;

public class EmpService {

	EmpRepository empRepository;
	AuthRepository authRepository;
	
	public void register() {
		empRepository.insert();
		authRepository.insert();
	}
}
