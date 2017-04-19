package com.wsjava.ssm.mapper;

import java.util.List;

import com.wsjava.ssm.po.ArticleCustom;
import com.wsjava.ssm.po.ArticleQueryVo;

public interface ArticleMapperCustom {
	
	//文章列表查询
	public List<ArticleCustom> findArticleList(ArticleQueryVo articleQueryVo) throws Exception;
	
}
