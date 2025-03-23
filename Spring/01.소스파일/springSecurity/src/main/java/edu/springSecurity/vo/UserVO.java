package edu.springSecurity.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/*
 해당 VO 객체는 security에서 로그인 또는 권한 인증시에만 사용하는 객체 타입으로서
 별도의 기능을 목적으로는 사용할 수 없다.
 필요시 타 VO를 추가하여 사용할 것을 권장한다. 
  
 */
public class UserVO extends User {

	private String userid;
	private String authority;
	private boolean enabled;
	
	
	public UserVO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,
			String authority) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	
		this.userid = username;
		this.authority = authority;
		this.enabled = enabled;
	
	}


	public String getUserid() {
		return userid;
	}


	public String getAuthority() {
		return authority;
	}


	public boolean isEnabled() {
		return enabled;
	}
	
	



}
