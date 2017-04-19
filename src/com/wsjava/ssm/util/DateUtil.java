package com.wsjava.ssm.util;

import java.util.Date;

/**
 * 工具类
 * @author wushuai
 *
 */
public class DateUtil {
	
	
	/**
	 * 
	 * @param createTime 创建时间 
	 * @return 
	 */
	public String timeConversion(Date createTime){
		Date date = new Date();
		//获取当前时间毫秒值
		long currenMillisecond = date.getTime();
		//获取创建时间毫秒值
		long createMillisecond = createTime.getTime();
		//计算差值
		long subtract = currenMillisecond-createMillisecond;
		//将毫秒值转换为分
		int min = (int) (subtract/1000/60);
		//将毫秒值转换为小时
		int hour = (int) (subtract/1000/60/60);
		//将毫秒值转换为天
		int day = (int) (subtract/1000/60/60/24);
		
		String timeDifference = "";
		if (min<=0) {
			timeDifference = "刚刚";
		} else if (min<60) {
			timeDifference = min+"分钟前";
		} else if (hour<=24) {
			timeDifference = hour+"小时前";
		} else{
			timeDifference = day+"天前";
		}
		
		return timeDifference;
	}
	
}
