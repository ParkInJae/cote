package edu.springSecurity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.springSecurity.vo.UserVO;

public class UserAuthenticationService implements UserDetailsService {

	SqlSession sqlSession;
	
	public UserAuthenticationService(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Map<String,Object> user 
			= sqlSession.selectOne("edu.springSecurity.mapper.userMapper.selectOneById", username);
		
				
		String username_map = (String)user.get("userid");
		String passwd_map = (String)user.get("passwd");
		
		int enabled_map = (Integer)user.get("enabled");
		
		boolean enabled = false;
		
		if(enabled_map == 1) { 
			enabled = true; 
		}else {
			enabled = false; 
		}
		 

		
		List<GrantedAuthority> autoriteis = new ArrayList<>();
		autoriteis.add(new SimpleGrantedAuthority((String)user.get("authority")));
		
		
		UserVO vo = new UserVO(username_map,passwd_map,enabled
								,true,true,true
								,autoriteis,(String)user.get("authority"));
		
		return vo;
	}

}
