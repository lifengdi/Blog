package com.lifengdi.blog.common;

/**
 * 状态枚举类
 * @author LiFengdi
 * @date 2018年3月2日 下午5:38:41
 */
public enum StatueEnum {
	
	VALID(0, "有效")
	, INVALID(1, "无效");
	
	private StatueEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}
	/**
	 * 值
	 */
	private int value;
	/**
	 * 描述
	 */
	private String desc;
	
	public int getValue() {
		return value;
	}
	
	public String getDesc() {
		return desc;
	}
	
}

