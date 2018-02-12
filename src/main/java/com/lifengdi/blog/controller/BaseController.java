package com.lifengdi.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
	
	@Autowired
	public HttpSession session;
	
	public static final String SESSION_ADMIN_USER_INFO = "adminUserInfo";
	public static final String SESSION_ADMIN_USER_MENU = "adminUserMenu";

	Object success() {
		
		return null;
	}
}

