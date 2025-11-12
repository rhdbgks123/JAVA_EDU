package com.example.demo.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails{
	
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	private List<String> role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(String r : role) {
			list.add(new SimpleGrantedAuthority(r));
		}
		return list;
	}
	@Override
	public String getUsername() {
		return loginId;
	}
	@Override
	public boolean isAccountNonExpired() {
//		return UserDetails.super.isAccountNonExpired();
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
//		return UserDetails.super.isAccountNonLocked();
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
//		return UserDetails.super.isCredentialsNonExpired();
		return true;
	}
	@Override
	public boolean isEnabled() {
//		return UserDetails.super.isEnabled();
		return true;
	}
}
