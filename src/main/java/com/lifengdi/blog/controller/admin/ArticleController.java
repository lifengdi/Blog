package com.lifengdi.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lifengdi.blog.bean.ArticleWithBLOBs;
import com.lifengdi.blog.bean.User;
import com.lifengdi.blog.controller.BaseController;
import com.lifengdi.blog.mybatis.mapper.ArticleMapper;
import com.lifengdi.blog.page.resource.PageResourceAdmin;
import com.lifengdi.blog.util.StringUtil;
import com.lifengdi.blog.util.SubStringHtmlUtil;

@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController{
	
	private static final String TITLE_ADD = "文章发布";
	private static final String TITLE_EDIT = "文章修改";
	
	@Autowired
	private ArticleMapper articleMapper;

	@RequestMapping("/add")
	ModelAndView add(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView(PageResourceAdmin.ARTICLE_ADD);
		modelAndView.addObject("title", TITLE_ADD);
        return modelAndView;
		
	}
	
	@RequestMapping("/update")
	ModelAndView update(HttpServletRequest request, int articleId) {
		ModelAndView modelAndView = new ModelAndView(PageResourceAdmin.ARTICLE_ADD);
		String title = TITLE_EDIT;
		if (articleId <= 0) {
			title = TITLE_ADD;
			modelAndView.addObject("title", title);
			return modelAndView;
		}
		
		ArticleWithBLOBs articleWithBLOBs = articleMapper.selectByPrimaryKey(articleId);
		
		modelAndView.addObject("title", title);
		modelAndView.addObject("articleInfo", articleWithBLOBs);
        return modelAndView;
		
	}
	
	@RequestMapping("/save")
	Object save(ArticleWithBLOBs article) {
		if (article == null) {
			return null;
		}
		int rs = -1;
		User user = getCurrentUser();
		if (article.getId() != null) {
			rs = articleMapper.updateByPrimaryKeyWithBLOBs(article);
		} else {
			if (StringUtil.isBlank(article.getIntro())) {
				article.setIntro(SubStringHtmlUtil.subStringHTML(article.getContent(), 500, "..."));
			}
			article.setOwnerid(user.getId());
			rs = articleMapper.insert(article);
		}
		
		if (rs > 0) {
			return success();
		} else {
			return fail();
		}
		
	}
}

