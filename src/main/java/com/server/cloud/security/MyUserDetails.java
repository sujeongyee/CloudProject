package com.server.cloud.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.server.cloud.command.UserVO;

public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails{

	
	private UserVO userVO;
	
	
	public MyUserDetails(UserVO vo) {
		this.userVO = vo;
	} 
	
	
	//화면에서 권한도 쓰고싶으면 getter만들면됨
		public String getRole() {
			return userVO.getRole();
	}
		//?는 GrantedAuthority를 상속받는 모든타입이 들어갈수 있다는 뜻
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			
			//uservo가 가지고 있는 권한을 리스트에 담아서 반환시키면, 스프링 시큐리티가 참조해서 사용한다.
			List<GrantedAuthority>list=new ArrayList<>();
			
			list.add(new GrantedAuthority() {
				
				@Override
				public String getAuthority() {
					// TODO Auto-generated method stub
					return userVO.getRole();
				}
			});
			
			
			return list;
		}
		
		
		
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return userVO.getPassword();
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return userVO.getUsername();
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;//계정이 만료되었나? true=네
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;//계정이 락이 걸렸나?
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;//비밀번호 만료되었나?
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;//사용할수있ㄴ느 계정인가?
		}


	
	
}
