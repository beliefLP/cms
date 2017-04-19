package com.wsjava.ssm.service;

import com.wsjava.ssm.po.CmsResult;
import com.wsjava.ssm.po.User;

public interface UserService {
	
	//用户注册
	public CmsResult registUser(User user) throws Exception;
	
	//用户登录
	public CmsResult loginUser(User user) throws Exception;
	
}
