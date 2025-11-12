package com.example.demo.user.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.UserService;
import com.example.demo.user.service.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserMapper userMapper;
	
	@Override
	public UserVO getUser(String loginId) {
		return userMapper.getUser(loginId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.getUser(username);
		
		if(vo==null) {
			throw new UsernameNotFoundException("없는 아이디입니다.");
		}
		return vo;
	}

}
