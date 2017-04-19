package com.wsjava.ssm.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wsjava.ssm.mapper.UserMapper;
import com.wsjava.ssm.po.CmsResult;
import com.wsjava.ssm.po.User;
import com.wsjava.ssm.po.UserExample;
import com.wsjava.ssm.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	//注册时对用户名校验
	@Override
	@Transactional(readOnly = true)
	public CmsResult registUser(User user) throws Exception {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(user.getUsername());
		//查询数据库有无此用户名
		int countByExample = userMapper.countByExample(userExample);
		
		CmsResult cmsResult = new CmsResult();
		if(countByExample>0){
			cmsResult.setStatus(1);
			cmsResult.setMsg("用户名已存在");
			return cmsResult;
		}
		
		//对密码加密
		String password = MD5Encoder.encode(DigestUtils.md5(user.getPassword()));
		user.setPassword(password);
		userMapper.insertSelective(user);//添加操作
		
		cmsResult.setStatus(0);
		cmsResult.setMsg("注册成功");
		return cmsResult;
	}

	//登录时校验用户
	@Override
	@Transactional(readOnly = true)
	public CmsResult loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername());
		List<User> users = userMapper.selectByExample(example);
		
		CmsResult cmsResult = new CmsResult();
		int status = 0;
		String msg = "";
		//校验用户名
		if(users.isEmpty() || users==null){
			status = 1;
			msg = "用户名不存在";
		}
		
		//密码不为空时，校验
		if(!user.getPassword().isEmpty() && !users.isEmpty() && users!=null){
			//对密码加密
			String password = MD5Encoder.encode(DigestUtils.md5(user.getPassword()));
			if(!password.equals(users.get(0).getPassword())){
				status = 2;
				msg = "密码不正确";
			}
		}
		cmsResult.setStatus(status);
		cmsResult.setMsg(msg);
		return cmsResult;
	}

}
