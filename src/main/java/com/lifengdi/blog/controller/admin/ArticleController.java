package com.lifengdi.blog.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {

	@RequestMapping("/add")
	ModelAndView index(HttpServletRequest request) {
		System.out.println(request.getHeader("User-Agent"));
		System.out.println("11111");
		ModelAndView modelAndView = new ModelAndView("/admin/article/add");
//		modelAndView.addObject("obj", "><$Thanks & Regards");
		modelAndView.addObject("title", "文章发布");
        return modelAndView;
		
	}
}

