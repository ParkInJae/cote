package edu.springboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.springboard.service.UserService;
import edu.springboard.util.PagingUtil;
import edu.springboard.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService; //userController 생성시 userService 의존 자동 주입
	
	@RequestMapping(value="/join.do",method=RequestMethod.GET)
	public String join() {
		return "user/join";
	}
	
	@RequestMapping(value="/join.do",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		
		int result = userService.insert(userVO);
		
		if(result>0) {
			System.out.println("등록완료");
		}else {
			System.out.println("등록실패");
		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/user/modify.do", method=RequestMethod.GET)
	public String modify() {
		return "user/modify";
	}
	
	@RequestMapping(value="/user/modify.do",method=RequestMethod.POST)
	public String modify(UserVO userVO) {
		
		int result = userService.update(userVO);
		
		if(result>0) {
			return "redirect:/";
		}else {
			return "redirect:modify.do";
		}
		
		
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO userVO,HttpServletRequest request) {
		
		UserVO vo = userService.selectByLogin(userVO);
		
		if(vo == null) {
			//일치하는 회원 정보 x

			return "redirect:login.do";
		}else {
			//일치하는 회원 정보 o
			
			//세션에 로그인 정보 넣기
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			
			return "redirect:/";
		}
		
		
	}
	
	@RequestMapping(value="/user/list.do")
	public String list(Model model,HttpServletRequest request
			,@RequestParam(value="nowPage", required=false, defaultValue ="1")int nowPage) {
		
		/*
		 * //권한 체크 : 로그인 된 회원 권한이 관리자인지 HttpSession session = request.getSession();
		 * 
		 * if(session.getAttribute("loginUser") == null ||
		 * !((UserVO)session.getAttribute("loginUser"))
		 * .getUauthorization().equals("A")) { return "redirect:/"; }
		 */
		
		//AdminInterceptor를 사용하여 권한 체크 할 수 있도록
		//servlet-context.xml을 수정하세요.
		
		int total = userService.selectTotal();
		
		PagingUtil paging = new PagingUtil(nowPage,total,5);
		
		Map<String,Integer> pagingParam =new HashMap<String,Integer>();
		pagingParam.put("start", paging.getStart());
		pagingParam.put("perPage", paging.getPerPage());
		
		//비지니스 로직 : DB에 있는 전체 회원 목록 데이터가져오기
		 List<UserVO> list= userService.selectAll(pagingParam);
		
		//모델 객체 사용하여 조회 데이터 화면으로 포워딩
		model.addAttribute("list", list);
		model.addAttribute("paging",paging);
		
		return "user/list";
	}
	
	
	@RequestMapping(value="/user/view.do")
	public String view(int uno,Model model,HttpServletRequest request) {
		//권한 체크 : 로그인 된 회원 권한이 관리자인지
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null 
				|| 
			!((UserVO)session.getAttribute("loginUser"))
							.getUauthorization().equals("A")) {
			return "redirect:/";
		}
				
				
		UserVO vo = userService.selectOne(uno);
		
		model.addAttribute("vo",vo);
		
		return "user/view";
		
	}
	
	@RequestMapping(value="/user/modify2.do",method=RequestMethod.GET)
	public String modify2(int uno, Model model) {
		
		UserVO vo = userService.selectOne(uno);
		model.addAttribute("vo",vo);
		
		return "user/modify2";
	}
	
	@RequestMapping(value="logout.do")
	public String logout(HttpServletRequest request) {
		
		request.getSession().invalidate();
		
		return "redirect:/";
	}
	
}









