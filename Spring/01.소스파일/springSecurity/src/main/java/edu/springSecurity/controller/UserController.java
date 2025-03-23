package edu.springSecurity.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/joinOk.do",method=RequestMethod.POST)
	public String joinOk(String userid, String passwd, String name) {

		BCryptPasswordEncoder epwe = new BCryptPasswordEncoder();
		
		Map<String,String> user = new HashMap<>();
		user.put("userid",userid);
		user.put("passwd",epwe.encode(passwd));
		user.put("name",name);		
		
		sqlSession.insert("edu.springSecurity.mapper.userMapper.insert",user);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
}





