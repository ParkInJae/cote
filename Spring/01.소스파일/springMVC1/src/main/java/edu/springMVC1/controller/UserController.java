package edu.springMVC1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.springMVC1.vo.UserVO;

@Controller
public class UserController {

	@RequestMapping(value="/login.do")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/join.do",method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public String join(UserVO vo, int age) {
		
		System.out.println("id:"+vo.getId());
		System.out.println("password:"+vo.getPassword());
		System.out.println("name"+vo.getName());
		System.out.println("phone:"+vo.getPhone());
		System.out.println("address:"+vo.getAddress());
		
		System.out.println("age:"+age);
		
		return "redirect:/";
	}
	/*public String join(String id, String password, String name
			, String phone, String address) {
		
		System.out.println("id:"+id);
		System.out.println("password:"+password);
		System.out.println("name"+name);
		System.out.println("phone:"+phone);
		System.out.println("address:"+address);
		
		return "redirect:/";
	}*/
	
	
	@RequestMapping(value="/mypage.do")
	public String mypage(Model model) {
		
		
		UserVO vo = new UserVO();
		vo.setId("tester1");
		vo.setName("테스터");
		vo.setPhone("010-1111-1111");
		vo.setAddress("백제대로 572");
		
		model.addAttribute("user", vo);
		
		return "user/mypage";
	}
}







