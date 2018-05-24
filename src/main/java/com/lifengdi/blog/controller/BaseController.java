package com.lifengdi.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lifengdi.blog.bean.User;
import com.lifengdi.blog.common.HttpStatusCodeEnum;
import com.lifengdi.blog.util.ResponseHelper;

@Controller
public class BaseController {
	
	@Autowired
	public HttpSession session;
	
	public static final String SESSION_ADMIN_USER_INFO = "adminUserInfo";
	public static final String SESSION_ADMIN_USER_MENU = "adminUserMenu";

	public Object success() {
		return ResponseHelper.getResponseJson(HttpStatusCodeEnum.SUCCESS.getCode(), null, null);
	}
	public Object success(Object data) {
		return ResponseHelper.getResponseJson(HttpStatusCodeEnum.SUCCESS.getCode(), null, data);
	}
	
	public Object success(Object data, String message) {
		return ResponseHelper.getResponseJson(HttpStatusCodeEnum.SUCCESS.getCode(), message, data);
	}
	
	public Object success(int httpStatusCode, Object data, String message) {
		return ResponseHelper.getResponseJson(httpStatusCode, message, data);
	}
	
	public Object success(HttpStatusCodeEnum httpStatus, Object data, String message) {
		return ResponseHelper.getResponseJson(httpStatus.getCode(), message, data);
	}
	
	public Object fail() {
		return ResponseHelper.getResponseJson(HttpStatusCodeEnum.FAIL.getCode(), null, null);
	}

	
	public Object fail(Object data) {
		return ResponseHelper.getResponseJson(HttpStatusCodeEnum.FAIL.getCode(), null, data);
	}

	public Object fail(Object data, String message) {
		return ResponseHelper.getResponseJson(HttpStatusCodeEnum.FAIL.getCode(), message, data);
	}
	
	public Object fail(int httpStatusCode, Object data, String message) {
		return ResponseHelper.getResponseJson(httpStatusCode, message, data);
	}
	
	public Object fail(HttpStatusCodeEnum httpStatus, Object data, String message) {
		return ResponseHelper.getResponseJson(httpStatus.getCode(), message, data);
	}
	/**
	 * 获取当前登录用户
	 * @Title 	getCurrentUser   
	 * @Description TODO(这里用一句话描述这个方法的作用)   
	 * @author 李锋镝
	 * @date   2018年2月15日 下午1:48:30 
	 * @return
	 */
	public User getCurrentUser() {
		User user = (User)session.getAttribute(SESSION_ADMIN_USER_INFO);
		if (user != null) {
			return user;
		}
		return null;
	}
}

