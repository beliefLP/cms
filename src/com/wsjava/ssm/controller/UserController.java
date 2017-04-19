package com.wsjava.ssm.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsjava.ssm.po.CmsResult;
import com.wsjava.ssm.po.User;
import com.wsjava.ssm.service.UserService;

@Controller
public class UserController {
	
	Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	// 返回注册页面
	@RequestMapping(value="/doRegist", method = {RequestMethod.GET })
	public String doRegist() throws Exception {
		return "regist";
	}

	// 注册
	@RequestMapping(value = "/regist", method = { RequestMethod.POST })
	public @ResponseBody CmsResult regist(User user)
			throws Exception {
		logger.info("regist "+user);
		CmsResult cmsResult = userService.registUser(user);
		return cmsResult;
	}

	// 返回登录页面
	@RequestMapping(value = "/doLogin", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String doLogin() throws Exception {
		return "login";
	}

	// 登录
	@RequestMapping(value = "/login", method = { RequestMethod.GET,
			RequestMethod.POST })
	public @ResponseBody
	CmsResult login(HttpSession session,User user) throws Exception {
		logger.info("login "+user);
		CmsResult cmsResult = userService.loginUser(user);
		//在session中保存用户身份信息
		session.setAttribute("username", user.getUsername());
		return cmsResult;
	}

	
	//登出
	@RequestMapping(value = "/logout", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String logout(HttpSession session) throws Exception{
		//清除session
		session.invalidate();
		//重定向到文章列表页
		return "redirect:/details/queryArticle.action";
	}

}
