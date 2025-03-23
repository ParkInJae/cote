package edu.springboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.springboard.service.NoticeService;
import edu.springboard.util.PagingUtil;
import edu.springboard.vo.NoticeVO;
import edu.springboard.vo.SearchVO;

@RequestMapping(value="/login/notice")
@Controller
public class Notice2Controller {

	@Autowired
	public NoticeService noticeService;
	
	@RequestMapping(value="/list.do")
	public String list(Model model,SearchVO searchVO
			,@RequestParam(value="nowpage"
						,required = false
						,defaultValue="1")int nowpage) {
		
		//DB에서 공지사항의 전체 게시글 갯수를 조회하세요.
		int total = noticeService.selectTotal(searchVO);
		
		// 현재 페이지 번호, 전체 게시글 개수,  한 페이지당 게시글 개수 
		PagingUtil paging = new PagingUtil(nowpage, total, 2); 
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<NoticeVO> list = noticeService.list(searchVO);
		
		model.addAttribute("list",list);
		model.addAttribute("paging",paging);
		
		
		return "notice/list";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.GET)
	public String write(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		
		/*
		 LoginInterceptor를 사용하여 글등록 화면 요청시 로그인이 안되어 있으면
		 로그인 페이지로 이동하도록 servlet-context.xml 을 수정하세요. 
		 */
		
		return "notice/write";
	}
	
	
}




