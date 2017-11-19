package com.lifengdi.blog.bean;

import java.io.Serializable;

/**
 * 
 * All rights Reserved, Designed By www.lifengdi.com
 * 
 * @ClassName Article
 * @Description 文章表
 * @author 李锋镝
 * @date 2017年11月18日 下午11:18:24
 * @version v1.0.0
 * @Copyright 2017 www.lifengdi.com All rights reserved.
 */
public class Article extends BaseBean implements Serializable {

	private static final long serialVersionUID = 2082967397876835108L;
	
	private String title;
	private String intro;
	private String content;
	private String keyword;
	private int type;
	private int viewCount;
	private int tagIds;
	private String shortUrl;
	private int ownerId;
	private int sort;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getTagIds() {
		return tagIds;
	}

	public void setTagIds(int tagIds) {
		this.tagIds = tagIds;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
