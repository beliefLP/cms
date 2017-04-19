package com.wsjava.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author wushuai
 *
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取请求路径
		StringBuffer requestURL = request.getRequestURL();
		
		//判断session
		HttpSession session = request.getSession();
		//从session中获取身份信息
		String username = (String) session.getAttribute("username");
		if(username != null){
			//若用户已登录，则重定向到列表页面
			if(requestURL.lastIndexOf("doLogin.action")>=0){
				response.sendRedirect(request.getContextPath() + "/details/queryArticle.action");
			}
			return true;
		}
		
		//判断URL
		if(requestURL.lastIndexOf("/details/doCreate.action")<0 && 
			requestURL.lastIndexOf("/details/createArticle.action")<0){
			return true;
		}
		
		//跳转到登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
