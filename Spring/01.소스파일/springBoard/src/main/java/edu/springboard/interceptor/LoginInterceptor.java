package edu.springboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.springboard.service.UserService;
import edu.springboard.util.PagingUtil;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//매핑 경로 컨트롤러 메소드 호출 전에 실행
		System.out.println("컨트롤러 메소드 실행 전 호출!!");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) {
			//로그인 X
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			
			response
				.getWriter()
				.append("<script>alert('로그인 후 이용하세요.');"
						+"location.href='"
						+request.getContextPath()
						+"/login.do';</script>")
				.flush();
			
			return false;
		}else {
			//로그인 O
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러 메소드가 호출 된 후 dispatcherservlet이 화면을 처리하기 전에 실행
		// modelAndView 객체 사용하면 처리된 request attribute에 접근 할 수 있다.
		System.out.println("화면 전환 전 호출!!");
		
		//model에 담긴 attribute 접근하는 방법
		PagingUtil paging = (PagingUtil)modelAndView.getModel().get("paging");
		
		System.out.println("paging start =>"+paging.getStart());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// dispatcher servlet이 화면 처리를 한 후에 실행
		System.out.println("화면 전환 후 호출!!");
		
	}

}
