package com.lifengdi.blog.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 
 * @author 李锋镝
 * 
 * 2016-4-11 下午5:37:45
 * 
 */
public class SubStringHtmlUtil {
	public static void main(String[] args) {
		System.out
				.println(subStringHTML(
						"<a>要配置几个项目就写几个Host标签。</a><img src='1231231.1231'>其中，defaultHost是输入服务器ip地址默认" +
						"访问的网站，如果为空则访问tomcat控制台；<p>name就是网站的域名；</p><p>appBase" +
						"是项目放置的根目录，这里我全部放置在tomcat默认的目录下，当然你也可以新建其他目录；</p>" +
						"<p>docBase是项目的根目录；</p>",
						30, ""));
	}

	/**
	 * 
	 * 按字节长度截取字符串(支持截取带HTML代码样式的字符串)
	 * 
	 * @param param
	 *            将要截取的字符串参数
	 * @param length
	 *            截取的字节长度
	 * @param end
	 *            字符串末尾补上的字符串
	 * @return 返回截取后的字符串
	 */
	public static String subStringHTML(String param, int length, String end) {
		StringBuffer result = new StringBuffer();
		int n = 0;
		char temp;
		boolean isCode = false; // 是不是HTML代码
		boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
		for (int i = 0; i < param.length(); i++) {
			temp = param.charAt(i);
			if (temp == '<') {
				isCode = true;
			} else if (temp == '&') {
				isHTML = true;
			} else if (temp == '>' && isCode) {
				n = n - 1;
				isCode = false;
			} else if (temp == ';' && isHTML) {
				isHTML = false;
			}

			if (!isCode && !isHTML) {
				n = n + 1;
				// UNICODE码字符占两个字节
				if ((temp + "").getBytes().length > 1) {
					n = n + 1;
				}
			}

			result.append(temp);
			if (n >= length) {
				break;
			}
		}
		result.append(end);
		// 取出截取字符串中的HTML标签
		String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)",
				"$1$2");
		// 去掉不需要闭合的HTML标签
		temp_result = temp_result
				.replaceAll(
						"</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG" +
						"|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area" +
						"|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex" +
						"|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>",
						"");
		// 去掉成对的HTML标签
		temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>",
				"$2");
		// 用正则表达式取出标签
		Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
		Matcher m = p.matcher(temp_result);

		List endHTML = new ArrayList();

		while (m.find()) {
			endHTML.add(m.group(1));
		}
		// 补全不成对的HTML标签
		for (int i = endHTML.size() - 1; i >= 0; i--) {
			result.append("</");
			result.append(endHTML.get(i));
			result.append(">");
		}

		return result.toString();
	}

}