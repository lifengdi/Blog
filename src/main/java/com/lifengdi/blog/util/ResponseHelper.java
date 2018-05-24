package com.lifengdi.blog.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 请求响应基础结构类，所有移动API请求响应的JSON都需要遵循该结构
 * 
 * @author 李锋镝 2016-5-26 下午4:17:34
 */
public class ResponseHelper {

	public static final String DATETIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 请求响应的参数的封装方法 2016-5-26 下午4:22:10 李锋镝
	 * 
	 * @param stateCode
	 *            响应状态码
	 * @param message
	 *            响应信息，一般为错误信息，成功可留空
	 * @param data
	 *            响应的实际数据JSON对象
	 * @return 封装好的JSON字符串
	 */
	public static String getResponseJson(Integer stateCode, String message, JSONObject result) {
		JSONObject json = new JSONObject();
		try {
			json.put("stateCode", stateCode);
			if (!StringUtil.isEmpty(message)) {
				json.put("message", message);
			}
			if (!result.isEmpty()) {
				json.put("result", result);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	/**
	 * 请求响应的参数的封装方法 2016-5-26 下午4:22:10 李锋镝
	 * 
	 * @param stateCode
	 *            响应状态码
	 * @param message
	 *            响应信息，一般为错误信息，成功可留空
	 * @param data
	 *            响应的实际数据JSON字符串对象
	 * @return 封装好的JSON字符串
	 */
	public static String getResponseJson(Integer stateCode, String message, Object result) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		try {
			jsonMap.put("stateCode", stateCode);
			if (!StringUtil.isEmpty(message)) {
				jsonMap.put("message", message);
			}
			if (result != null) {
				jsonMap.put("result", result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(jsonMap);
	}

	/**
	 * 
	 * 2016-5-26 下午5:44:03 李锋镝
	 * 
	 * @param stateCode
	 *            响应状态码
	 * @param message
	 *            响应信息，一般为错误信息，成功可留空
	 * @return 封装好的JSON字符串
	 */
	public static String getResponseJson(Integer stateCode, String message) {
		JSONObject json = new JSONObject();
		try {
			json.put("stateCode", stateCode);
			if (!StringUtil.isEmpty(message)) {
				json.put("message", message);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return json.toString();
	}

}
