package com.wsjava.ssm.po;

/**
 * 文章包装类型
 */
public class ArticleQueryVo {
	
	//Article的扩展类
	private ArticleCustom articleCustom;

	//用户信息
	private User user;

	public ArticleCustom getArticleCustom() {
		return articleCustom;
	}

	public void setArticleCustom(ArticleCustom articleCustom) {
		this.articleCustom = articleCustom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
