package com.tildev.myspringboot.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String serverIp = request.getLocalAddr();
		String serverPort = String.valueOf(request.getServerPort());
		
		String requestUri = request.getRequestURI();
		// proxy
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		request.getParameterMap();

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
