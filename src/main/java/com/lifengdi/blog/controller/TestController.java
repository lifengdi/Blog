package com.lifengdi.blog.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifengdi.blog.bean.City;
import com.lifengdi.blog.mybatis.mapper.CityMapper;

/**
 * 
 * @author LiFengdi
 * @date 2017年11月11日 下午7:47:05
 */
@RestController
public class TestController {
	
	@Resource  
    private CityMapper cityMapper;
	
	@RequestMapping("/hello/{name}")
	String hello(@PathVariable String name, @RequestParam String param) {
		return "Hello " + name + " param:" + param;
	}
	
	@RequestMapping("/findCity")  
    City findCity2(@RequestParam int id){  
        return cityMapper.selectCityById(id);  
    }
}

