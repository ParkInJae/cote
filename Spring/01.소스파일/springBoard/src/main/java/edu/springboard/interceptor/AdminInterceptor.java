package edu.springboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.springboard.vo.UserVO;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		UserVO loginUser = (UserVO) session.getAttribute("loginUser");

		if (loginUser != null && loginUser.getUauthorization().equals("A")) {
			// 관리자
			return true;
		} else {
			// 관리자가 아니다
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("<script>" + "alert('관리자만 접근 가능합니다.');" + "location.href='"
					+ request.getContextPath() + "';</script>");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
