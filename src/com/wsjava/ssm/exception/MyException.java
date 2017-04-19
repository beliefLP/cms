package com.wsjava.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//全局异常
public class MyException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		BusinessException businessException = null;
		if(ex instanceof BusinessException){
			businessException = (BusinessException) ex;
		} else {
			businessException = new BusinessException("未知错误");
		}
		
		String massage = businessException.getMassage();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("massage", massage);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}
}
