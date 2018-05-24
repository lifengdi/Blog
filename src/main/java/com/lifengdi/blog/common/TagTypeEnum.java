package com.lifengdi.blog.common;

/**
 * 标签类型
 * 0-文章标签，1-技术类网站链接，2-其他类网站
 * @author LiFengdi
 * @date 2018年5月24日 下午4:43:39
 */
public enum TagTypeEnum {

	article(0, "文章"),
	tech_web(1, "技术类网站"),
	other(2, "其他类网站");
	
	private int type;
	private String name;
	
	private TagTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	
	
}

