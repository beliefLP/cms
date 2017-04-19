package com.wsjava.ssm.exception;


/**
 * 自定义异常类
 * @author wushuai
 *
 */
public class BusinessException extends Exception{
	
	private static final long serialVersionUID = 1L;
	//异常信息
	private String massage;
	
	public BusinessException(String massage){
		super(massage);
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}
	
	
	
}
