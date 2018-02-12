package com.lifengdi.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lifengdi.blog.bean.User;
import com.lifengdi.blog.bean.UserKey;
import com.lifengdi.blog.controller.BaseController;
import com.lifengdi.blog.mybatis.mapper.UserMapper;
import com.lifengdi.blog.util.MD5Util;
import com.lifengdi.blog.util.StringUtil;

@Controller
@RequestMapping("/blog/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/login")
	ModelAndView login(String loginId, String password) {
		ModelAndView modelAndView = new ModelAndView("/admin/index");
		modelAndView.addObject("title", "后台管理首页");
		
		UserKey userKey = new UserKey();
		userKey.setLoginid(loginId);
		User user = userMapper.selectByPrimaryKey(userKey);
		if (user != null && checkPassword(user, password)) {
			// 登录成功之后将信息放入session中 并加载用户菜单
			// session时间默认2小时
			session.setMaxInactiveInterval(60 * 120);
			session.setAttribute(SESSION_ADMIN_USER_INFO, user);
			// TODO 加载用户菜单
		}
		
        return modelAndView;
		
	}
	
	@RequestMapping("/logout")
	ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("/admin/login");
		modelAndView.addObject("title", "后台管理首页");
		
		session.invalidate();
		
        return modelAndView;
		
	}
	
	/**
	 * 判断用户密码是否正确
	 * @author LiFengdi
	 * @date 2018年2月12日 下午4:37:25
	 * @param user
	 * @param passWorld
	 * @return
	 */
	private boolean checkPassword(User user, String password) {
		
		try {
			if (user.getPassword() != null && StringUtil.isNotBlank(passWord)) {
				passWord = passWord + user.getRandom();
				return user.getPassword().equals(MD5Util.MD5Encode(passWord));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}

