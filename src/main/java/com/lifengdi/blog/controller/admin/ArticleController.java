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
import com.lifengdi.blog.util.StringUtil;
import com.lifengdi.blog.util.SubStringHtmlUtil;

@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController{
	
	@Autowired
	private ArticleMapper articleMapper;

	@RequestMapping("/add")
	ModelAndView add(HttpServletRequest request) {
		System.out.println(getCurrentUser().getName());
		ModelAndView modelAndView = new ModelAndView("/admin/article/add");
		modelAndView.addObject("title", "文章发布");
        return modelAndView;
		
	}
	
	@RequestMapping("/save")
	Object save(ArticleWithBLOBs article) {
		ModelAndView modelAndView = new ModelAndView("/admin/article/add");
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
        return modelAndView;
		
	}
}

