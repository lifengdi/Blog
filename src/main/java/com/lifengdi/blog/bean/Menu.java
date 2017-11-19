package com.lifengdi.blog.bean;

import java.io.Serializable;

/**
 * 
 * All rights Reserved, Designed By www.lifengdi.com
 * 
 * @ClassName Menu
 * @Description 菜单
 * @author 李锋镝
 * @date 2017年11月18日 下午11:28:22
 * @version v1.0.0
 * @Copyright 2017 www.lifengdi.com All rights reserved.
 */
public class Menu extends BaseBean implements Serializable {

	private static final long serialVersionUID = -5149182909763831330L;

	private String name;
	private String url;
	private int sort;
	private int level;
	private int parentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
