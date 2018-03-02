package com.lifengdi.blog.common;

/**
 * HTTP状态码枚举类
 * @author LiFengdi
 * @date 2018年3月2日 下午5:56:10
 */
public enum HttpStatusCodeEnum {
	SUCCESS(0, "成功")
	, SERVER_EXCEPTION(100, "服务器异常")
	, PARAM_ERROR(200, "传入参数不正确（缺少参数，值的类型或格式错误等）")
	, USER_INFO_ERROR(300, "用户信息认证失败");
	
	private HttpStatusCodeEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private int code;
	private String desc;
	
	public int getCode() {
		return code;
	}
	
	public String getDesc() {
		return desc;
	}
	
	
	
}

