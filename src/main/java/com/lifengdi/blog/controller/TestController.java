package com.lifengdi.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lifengdi.blog.bean.City;
import com.lifengdi.blog.mybatis.mapper.CityMapper;

/**
 * 
 * @author LiFengdi
 * @date 2017年11月11日 下午7:47:05
 */
@Controller
public class TestController {
	
	@Resource  
    private CityMapper cityMapper;
	
	@RequestMapping("/asd")
	String hello() {
		System.out.println("22222");
		return "/login";
	}
	
	@RequestMapping("/index")
	String index(HttpServletRequest request) {
		System.out.println(request.getHeader("User-Agent"));
		System.out.println("11111");
		return "index";
	}
	
	@RequestMapping("/")
	ModelAndView test() {
		
		return new ModelAndView("/index");
	}
	
	@RequestMapping("/findCity")  
	ModelAndView findCity2(@RequestParam int id){  
		System.out.println("33333444");
		City selectCityById = cityMapper.selectCityById(id);
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("city", selectCityById);
        return modelAndView;  
    }
}

