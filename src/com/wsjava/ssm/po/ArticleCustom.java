package com.wsjava.ssm.po;

/**
 * 文章扩展类
 */
public class ArticleCustom extends Article{
	
	private String timeDifference;//时间差
	
	private String picPath;//图片路径

	public String getTimeDifference() {
		return timeDifference;
	}

	public void setTimeDifference(String timeDifference) {
		this.timeDifference = timeDifference;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
}
