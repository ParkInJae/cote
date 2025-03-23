package edu.springMVC1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.springMVC1.vo.BoardVO;

@Controller
public class ElJSTLController {

	
	@RequestMapping(value="/el.do")
	public String el(Model model) {
		
		
		model.addAttribute("data1","10");
		model.addAttribute("data2",10);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목입니다.");
		
		model.addAttribute("vo",vo);
		
		BoardVO vo2 = new BoardVO();
		vo2.setTitle("안녕하세요.반갑습니다.");
		vo2.setPassword("1234");
		vo2.setWriteDate("2024-11-19");
		vo2.setWriter("홍길동");
		vo2.setContent("첫번째 게시글을 작성해요 하하하");
		
		model.addAttribute("details", vo2); //request.setAttribute("details",vo2);
		//위 details 안에 들어있는 객체의 데이터를 el.jsp 맨 아래 전부 각 필드값을 출력하세요.
		
		
		return "el";
	}
	
	@RequestMapping(value="/jstl.do")
	public String jstl(Model model) {
		
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		BoardVO vo1 = new BoardVO();
		vo1.setTitle("첫번째 제목입니다.");
		
		BoardVO vo2 = new BoardVO();
		vo2.setTitle("두번째 제목입니다.");
		
		BoardVO vo3 = new BoardVO();
		vo3.setTitle("세번째 제목입니다.");
		
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		
		model.addAttribute("list", list);
		
		
		
		return "jstl";
	}
	
	
}





