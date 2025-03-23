package edu.springMVC1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.springMVC1.vo.BoardVO;

/*
 클래스 상단에 requestmapping 어노테이션을 사용하게 되면 베이스 uri를 지정할 수 있다.
 베이스 uri를 지정하게 되면 dispatcher servlet이 더 빨리 가상경로 매핑 메소드를 찾을 수 있다. 
 */
@RequestMapping(value="/board")
@Controller
public class BoardController {

	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list() {
		return "board/list";
	}
	
	@RequestMapping(value="/view.do")
	public String view() {
		return "board/view";//jsp 위치
	}
	
	@RequestMapping(value="/write.do",method=RequestMethod.GET)
	public String write() {
		// 화면 포워드
		return "board/write";
	}
	
	
	/*public String writeOk(String title,String content) {
		System.out.println("title:"+title);
		System.out.println("content:"+content);*/
	/*
	 컨트롤러에서 매개변수의 명칭과 파라미터의 키값이 같으면 자동 매핑되어 값이 대입된다.
	 이때 매개변수를 vo로 둘 경우 vo의 필드명과 파라미터의 키값이 같으면 자동 매핑되어 객체를
	 생성한다. 
	 */
	@RequestMapping(value="/write.do",method=RequestMethod.POST)
	public String writeOk(BoardVO boardVO, String other) {
		
		System.out.println(boardVO.getTitle());
		System.out.println(boardVO.getWriter());
		System.out.println(boardVO.getPassword());
		System.out.println(boardVO.getWriteDate());
		System.out.println(boardVO.getContent());
		
		System.out.println(other);
		
		//타 가상경로 재요청
		return "redirect:/board/list.do";
	}
}





