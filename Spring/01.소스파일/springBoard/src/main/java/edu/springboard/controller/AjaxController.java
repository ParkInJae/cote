package edu.springboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.springboard.service.NoticeService;
import edu.springboard.service.UserService;
import edu.springboard.util.PagingUtil;
import edu.springboard.vo.NoticeVO;
import edu.springboard.vo.SearchVO;
import edu.springboard.vo.UserVO;

@RequestMapping(value="/ajax")
@Controller
public class AjaxController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public NoticeService noticeService;
	
	@RequestMapping(value="/example.do") //url 경로 매핑
	public String example() {
		return "ajax/index"; //포워드 jsp 위치 파일명
	}
	
	//@ResponseBody
	/*@RequestMapping(value="/text.do")
	public void text(HttpServletResponse rsp) throws IOException {
		
		rsp.setCharacterEncoding("UTF-8");
		rsp.getWriter().append("testData").flush();
		
	}*/
	/*
	 @ResponseBody 어노테이션을 사용하면 굳이 response 객체를 직접 선언하지
	 않고도 ajax의 응답값을 return 키워드로 반환할 수 있다.
	 
	 해당 어노테이션은 반환되는 값을 요청 servlet 페이지에 그대로 출력하는 기능을
	 갖는다.  
	  
	 @ResponseBody 어노테이션을 사용하여 응답값을 반환할때도 마찬가지로 
	 text, json 데이터만 반환할 수 있다.
	 */
	@ResponseBody
	@RequestMapping(value="/text.do")
	public String text() throws IOException {
		return "testData";
	}
	
	@ResponseBody
	@RequestMapping(value="/param.do")
	public String param(String param1) {
		
		System.out.println("prameter : "+param1);
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value="/checkID.do", method = RequestMethod.GET)
	public String checkID(String uid) {
		String msg = "";
		
		int isId = userService.selectCntByUid(uid);
		
		/*
		 ajax 요청시 컨트롤러에서는 response 문자셋을 지정할 수 없으므로
		 주로 응닶은 영문으로 작성 하여 화면에서 제어합니다. 
		 */
		if(isId > 0) {
			//id 중복 o
			msg = "fail";
		}else {
			//id 중복 x
			msg = "success";
		}
		
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/cntFreeByUid.do")
	public String cntFreeByUid(String uid) {
		
		int result = noticeService.selectCntFreeByUid(uid);
		
		return result+"";
	}
	
	@ResponseBody
	@RequestMapping(value="/findLoginUser.do")
	public UserVO findLoginUser(HttpServletRequest request) {
		//현재로그인 된 유저의 모든 정보 조회하여 응답하기
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		UserVO resultVO = userService.selectOne(loginUser.getUno());
		
		return resultVO; //{uid : '', upassword:'',....}<-jackson 라이브러리가
	}
	
	@ResponseBody
	@RequestMapping(value="/list.do")
	public List<UserVO> list() {
		UserVO user1 = new UserVO();
		user1.setUname("홍길동");
		
		UserVO user2 = new UserVO();
		user2.setUname("김길동");
		
		UserVO user3 = new UserVO();
		user3.setUname("박길동");
		
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		return list; //[{},{},{}]
	}
	
	@ResponseBody
	@RequestMapping(value="/otherTypeCall.do")
	public Map<String,Object> otherTypeCall(){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		PagingUtil paging = new PagingUtil(1,30,5);
		
		UserVO user1 = new UserVO();
		user1.setUname("홍길동");
		
		UserVO user2 = new UserVO();
		user2.setUname("김길동");
		
		UserVO user3 = new UserVO();
		user3.setUname("박길동");
		
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		resultMap.put("paging",paging);
		resultMap.put("list",list);
		
		return resultMap;// { paging :  paging , list : [{uname : '' },{uname : ''},{uname : ''}]}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/noticeList.do")
	public List<NoticeVO> noticeList(){
		
		SearchVO searchVO = new SearchVO();
	 	searchVO.setStart(0);
	 	searchVO.setPerPage(10);
	 	
	 	List<NoticeVO> list = noticeService.list(searchVO);
	 	
	 	return list; //[{},{},{},{},{},{},{},{},{},{}]
	}
	
	@ResponseBody
	@RequestMapping(value="/noticeView.do")
	public NoticeVO noticeView(int nno) {
		return noticeService.selectOne(nno);
	}
	
	@RequestMapping(value="/example02.do")
	public String example02() {
		return "ajax/example";
	}
	
	@ResponseBody
	@RequestMapping(value="/login.do",method=RequestMethod.POST, produces = "application/text;charset=utf8")
	public String login(UserVO userVO,HttpServletRequest request) {
		
		UserVO vo = userService.selectByLogin(userVO);
		
		if(vo == null) {
			//일치하는 회원 정보 x

			return "fail";
		}else {
			//일치하는 회원 정보 o
			
			//세션에 로그인 정보 넣기
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			
			return vo.getUname();
		}
	}
	
	
}







