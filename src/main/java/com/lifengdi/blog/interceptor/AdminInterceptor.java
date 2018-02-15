package com.lifengdi.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lifengdi.blog.bean.User;
import com.lifengdi.blog.controller.BaseController;

public class AdminInterceptor extends BaseController implements HandlerInterceptor {
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		User user = (User)arg0.getSession().getAttribute(SESSION_ADMIN_USER_INFO);
		return user != null && user.getIsadmin().intValue() == 1;
	}

}

