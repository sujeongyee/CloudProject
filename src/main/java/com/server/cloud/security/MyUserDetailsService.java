package com.server.cloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.server.cloud.command.UserVO;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	@Autowired
	private UserMapper userMapper;


	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo=userMapper.login(username);


		if (vo == null) {
			System.out.println(vo.toString());
			throw new UsernameNotFoundException("User not found with username: " + username);
		}else {
			return new MyUserDetails(vo);
		}
	}
}


