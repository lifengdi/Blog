package com.lifengdi.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * @author LiFengdi
 * @date 2017年11月11日 下午6:47:04
 */
@SpringBootApplication
@MapperScan("com.lifengdi.blog.mybatis.mapper")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


