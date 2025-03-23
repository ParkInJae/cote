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
import edu.springboard.vo.UserVO;

@Controller
public class NoticeController {

	@Autowired
	public NoticeService noticeService;
	
	@RequestMapping(value="/board/list.do")
	public String list(Model model,SearchVO searchVO
			,@RequestParam(value="nowpage"
						,required = false
						,defaultValue="1")int nowpage) {
		
		//DB에서 공지사항의 전체 게시글 갯수를 조회하세요.
		int total = noticeService.selectTotal(searchVO);
		
		PagingUtil paging = new PagingUtil(nowpage, total, 5);
		
		searchVO.setStart(paging.getStart());
		searchVO.setPerPage(paging.getPerPage());
		
		List<NoticeVO> list = noticeService.list(searchVO);
		
		model.addAttribute("list",list);
		model.addAttribute("paging",paging);
		
		
		return "notice/list";
	}
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public String write(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")== null) {
			//return "redirect:list.do";
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			response.getWriter().append("<script>alert('로그인 후 이용하세요.');"
									+"location.href='"
									+request.getContextPath()
									+"/login.do'</script>").flush();;
			
		}
		
		return "notice/write";
	}
	
	
	@RequestMapping(value="/board/writeOk.do",method=RequestMethod.POST)
	public String write(NoticeVO vo,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		vo.setUno(loginUser.getUno());
		
		System.out.println(vo.getNno()); //0
		
		
		vo.setTitle((String)request.getAttribute("title"));
		vo.setContent((String)request.getAttribute("content"));
		
		int result = noticeService.insert(vo);
		
		if(result>0) {
			//int maxNno = noticeService.selectMaxNo();
			return "redirect:view.do?nno="+vo.getNno();
			
		}else {
			return "redirect:write.do";
		}
		
		
	}
	
	@RequestMapping(value="/board/view.do")
	public String view(int nno, Model model) {
		
		NoticeVO vo = noticeService.selectOne(nno);
		
		model.addAttribute("vo", vo);
		
		return "notice/view";
	}
	
	@RequestMapping(value="/board/delete.do",method =RequestMethod.POST)
	public String delete(int nno) {
		
		int result = noticeService.changeState(nno);
		
		return "redirect:list.do";
	}
	
}








