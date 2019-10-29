package org.kpu.dhcar.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	
	// 컨트롤러보다 먼저 수행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("login");
		// 로그인이 되어있지 않은 상태이므로 로그인 페이지로 리다이렉트하고, false로 설정하여 컨트롤러로 넘어가지 않음
		if(obj == null) {
			response.sendRedirect("/dhcar");
			return false;
		}
		// true로 설정하여 컨트롤러로 넘어감
		return true;
	}
	
	// 컨트롤러 수행 후 뷰 처리하기 직전에 수행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
