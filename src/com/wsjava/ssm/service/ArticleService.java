package com.wsjava.ssm.service;

import java.util.List;

import com.wsjava.ssm.po.Article;
import com.wsjava.ssm.po.ArticleCustom;
import com.wsjava.ssm.po.ArticleQueryVo;

public interface ArticleService {
	
	//创建文章
	public int createArticle(Article article) throws Exception;
	
	//文章列表查询
	public List<ArticleCustom> findArticleList(ArticleQueryVo articleQueryVo) throws Exception;
	
	//根据文章id查询信息
	public Article queryById(Integer id) throws Exception;
	
	//更新文章
	public int updateArticleById(Integer id,Article article) throws Exception;
}
