package com.wsjava.ssm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wsjava.ssm.exception.BusinessException;
import com.wsjava.ssm.mapper.ArticleMapper;
import com.wsjava.ssm.mapper.ArticleMapperCustom;
import com.wsjava.ssm.po.Article;
import com.wsjava.ssm.po.ArticleCustom;
import com.wsjava.ssm.po.ArticleExample;
import com.wsjava.ssm.po.ArticleQueryVo;
import com.wsjava.ssm.service.ArticleService;
import com.wsjava.ssm.util.DateUtil;

public class ArticleServiceimpl implements ArticleService {
	
	@Autowired
	private ArticleMapperCustom articleMapperCustom;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	//文章列表查询
	@Override
	@Transactional(readOnly = true)
	public List<ArticleCustom> findArticleList(ArticleQueryVo articleQueryVo)
			throws Exception {
		
		List<ArticleCustom> articleList = articleMapperCustom.findArticleList(articleQueryVo);
		
		DateUtil dateUtil = new DateUtil();
		
		for (int i = 0; i < articleList.size(); i++) {
			//获取创建时间
			Date createTime = articleList.get(i).getCreateTime();
			String timeConversion = dateUtil.timeConversion(createTime);
			articleList.get(i).setTimeDifference(timeConversion);
			
			//获取图片路径
			String content = articleList.get(i).getContent();
			String picPath = content.substring(content.indexOf("src=\"")+5, content.lastIndexOf("\" title")).trim();
			articleList.get(i).setPicPath(picPath);;
			
		}
		
		return articleList;
	}

	//创建文章
	@Transactional(propagation = Propagation.REQUIRED)
	public int createArticle(Article article) throws Exception{
		
		//获取文章内容
		String content = article.getContent();
		if(content.lastIndexOf("<img")<0){
			throw new BusinessException("请上传图片");
		}
		
		article.setCreateTime(new Date());
		article.setUserId(1);
		return articleMapper.insertSelective(article);
	}
	
	//根据id查询文章
	@Transactional(readOnly = true)
	public Article queryById(Integer id) throws Exception{
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdEqualTo(id);
		List<Article> articles = articleMapper.selectByExample(example);
		ArticleCustom articleCustom = null;
		
		if(!articles.isEmpty() || articles != null){
			articleCustom = new ArticleCustom();
			//将articles的内容拷贝到(articleCustom)
			BeanUtils.copyProperties(articles.get(0), articleCustom);
			
			DateUtil dateUtil = new DateUtil();
			//获取创建时间
			Date createTime = articleCustom.getCreateTime();
			String timeConversion = dateUtil.timeConversion(createTime);
			articleCustom.setTimeDifference(timeConversion);
		}
		
		return articleCustom;
	}
	
	//更新文章
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateArticleById(Integer id,Article article) throws Exception{
		
		//获取文章内容
		String content = article.getContent();
		if(content.lastIndexOf("<img")<0){
			throw new BusinessException("请上传图片");
		}
		
		article.setId(id);
		return articleMapper.updateByPrimaryKeySelective(article);
	}

}
