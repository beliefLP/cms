package com.wsjava.ssm.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wsjava.ssm.exception.BusinessException;
import com.wsjava.ssm.po.Article;
import com.wsjava.ssm.po.ArticleCustom;
import com.wsjava.ssm.po.ArticleQueryVo;
import com.wsjava.ssm.service.ArticleService;

@Controller
@RequestMapping("/details")
public class ArticleController {
	
	Logger logger = Logger.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	//返回创建文章页面
	@RequestMapping("/doCreate")
	public String doCreate(Integer id,Model model) throws Exception{
		if(id != null){
			Article article = articleService.queryById(id);
			model.addAttribute("article", article);
		}
		return "/article/creatArticle";
	}
	
	/**
	 * 创建文章
	 * @param id 文章id
	 * @param article
	 * @return 重定向到创建文章页面
	 * @throws Exception
	 */
	@RequestMapping("/createArticle")
	public String createArticle(Integer id,Article article,Model model) throws Exception{
		if(StringUtils.isBlank(article.getContent()) || 
				StringUtils.isBlank(article.getSubTitle()) ||
				StringUtils.isBlank(article.getTitle()) ){
			throw new BusinessException("录入信息不全");
		}
		logger.info("createArticle"+article);
		//id为null时，创建，否则，为更新
		if(id == null){
			articleService.createArticle(article);
		} else {
			articleService.updateArticleById(id, article);
		}
		return "redirect:doCreate.action";
	}
	
	//文章查询列表
	@RequestMapping("/queryArticle")
	public ModelAndView queryArticle(ArticleQueryVo articleQueryVo) throws Exception{
		
		//调用service查询数据库
		List<ArticleCustom> articleList = articleService.findArticleList(articleQueryVo);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articleList", articleList);
		// 指定视图
		modelAndView.setViewName("article/articleList");
		
		return modelAndView;
	}
	
	/**
	 * 文章详情
	 * @param id 文章id
	 * @param model
	 * @return
	 */
	@RequestMapping("/articleDetail")
	public String articleDetail(Integer id,Model model) throws Exception{
		if(id == null){
			throw new BusinessException("该文章不存在");
		}
		logger.info("articleDetail id "+id);
		Article article = articleService.queryById(id);
		logger.info(article);
		model.addAttribute("article", article);
		return "/article/articleDetail";
	}
	
}
