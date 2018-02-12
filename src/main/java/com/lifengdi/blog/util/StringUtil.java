package com.lifengdi.blog.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用字符串工具类
 * @author 李锋镝
 * @date 2017年1月18日 下午10:19:37
 * @version 1.0.0
 */
public class StringUtil {

	private StringUtil() {
	}

	/**
	 * 判断字符为空或空串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || (str.length() == 0);
	}

	/**
	 * 判断字符为空或空串或内容为空格
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return (str == null) || (str.length() == 0) || ("".equals(str.replaceAll(" ", ""))) || ("null".equals(str));
	}
	
	/**
	 * 判断字符串不为空
	 * @author LiFengdi
	 * @date 2018年2月12日 下午3:55:06
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	/**
	 * 优化替换空白字符算法
	 * @param str
	 * @return
	 */
	public static String replaceAllBlankSpace(String str) {
		if (str != null) {
            int length = str.length();
            if (length > 0) {
                final char[] src = str.toCharArray();
                final char[] dest = new char[length];
                int pos = 0;
                char c = 0;
                for (int i=0; i<length; i++) {
                    c = src[i];
                    if (!Character.isWhitespace(c)) {
                        dest[pos++] = c;
                    }
                }
                str = new String(dest, 0, pos);
            }
        }
        return str;
	}

	/**
	 * 除字符串中的回车\r、换行符\n、制表符\t 因标签中带有样式属性，故不能去除空格\s*
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\t|\r|\n");
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}

	/**
	 * 判断字符串是否有效
	 * @param str
	 * @return
	 */
	public static boolean isValid(String str) {
		return !isEmpty(str);
	}

	/**
	 * 判断数字类型算法
	 * @param str
	 * @return
	 */
	
	public static boolean isNumber(String str) {
		if (isBlank(str)) {
			return false;
		}
		
		int sz = str.length();
		// 记录'.'的个数
		int count = 0;
		for (int i = 0; i < sz; i++) {
			char c = str.charAt(i);
			// 可能为负数，continue
			if (i == 0 && c == '-') {
				continue;
			}
			//如果当前字符非数字，并且还是非空白字符
			if ((!Character.isDigit(c)) && (!Character.isWhitespace(c)) && (c != '.')) {
				return false;
			}
			// Double类型包含'.'，但是只能有一个
			if (c == '.') {
				count++;
				continue;
			}
			// '.'的个数不能超过1
			if (count > 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 将字符串转换成double数值 提供转换服务
	 * @param str 要转换成double数值的字符串
	 * @param defaultNumber 如果转换失败的默认值
	 * @return
	 */
	private static Double value(String str, Number defaultNumber) {
		double d = defaultNumber.doubleValue();

		if (isNumber(str)) {
			String reStr = replaceAllBlankSpace(str);
			try {
				d = Double.parseDouble(reStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return d;
	}

	/**
	 * 将字符串转换成double数值
	 * @param str 要转换成double数值的字符串
	 * @param defaultDoubleValue 如果转换失败的默认值
	 * @return
	 */
	public static double doubleValue(String str, double defaultDoubleValue) {
		return value(str, defaultDoubleValue);
	}

	/**
	 * 将字符串转换成int数值
	 * @param str 要转换成int数值的字符串
	 * @param defaultIntValue 如果转换失败的默认值
	 * @return
	 */
	public static int intValue(String str, int defaultIntValue) {
		if (str!= null) {
			int length = str.length();
			try {
				if (length <= 11) {
					return Integer.parseInt(str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Double d = value(str, defaultIntValue);

			if (d != null && d.intValue() <= Integer.MAX_VALUE) {
				return d.intValue();
			}
		}
		return defaultIntValue;
	}

	/**
	 * 将字符串转换成long数值
	 * @param str 要转换成long数值的字符串
	 * @param defaultLongValue 如果转换失败的默认值
	 * @return
	 */
	public static long longValue(String str, long defaultLongValue) {
		Double d = null;
		d = value(str, defaultLongValue);
		if (d != null && d <= Long.MAX_VALUE) {
			return d.longValue();
		}
		return defaultLongValue;
	}

	/**
	 * 替换字符串中含有XSS的字符
	 * @param str
	 * @return
	 */
	public static String replaceXssCharacter(String str) {
		if (str == null) {
			return str;
		}
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot");
		str = str.replaceAll("'", "‘");
		return str;
	}
	
	/**
	 * 防止SQL注入
	 * @param str
	 * @return
	 */
	public static String escapeSql(String str) {
		if (str == null) {
			return str;
		}
		return replace(str, "'", "''");
	}
	
	/**
	 * 替换字符串
	 * @param text 需要进行替换字符的字符串
	 * @param repl 替换的字符
	 * @param with 用来替换的字符
	 * @return
	 */
	public static String replace(String text, String repl, String with) {
		return replace(text, repl, with, -1);
	}
	
	/**
	 * 替换字符串
	 * @param text 需要进行替换字符的字符串
	 * @param repl 替换的字符
	 * @param with 用来替换的字符
	 * @param max 最多替换次数
	 * @return
	 */
	public static String replace(String text, String repl, String with, int max) {
		if (isEmpty(text) || isEmpty(repl) || with == null || max == 0)
			return text;
		int start = 0;
		int end = text.indexOf(repl, start);
		if (end == -1)
			return text;
		int replLength = repl.length();
		int increase = with.length() - replLength;
		increase = increase >= 0 ? increase : 0;
		increase *= max >= 0 ? max <= 64 ? max : 64 : 16;
		StringBuffer buf = new StringBuffer(text.length() + increase);
		for (; end != -1; end = text.indexOf(repl, start)) {
			buf.append(text.substring(start, end)).append(with);
			start = end + replLength;
			if (--max == 0)
				break;
		}
		buf.append(text.substring(start));
		return buf.toString();
	}

	/**
	 * 判断字符串能否转换成日期格式
	 * @param str 要转化日期格式的字符串
	 * @return
	 */
	public static boolean isValidDate(String str) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		fmt.setLenient(false);
		try {
			fmt.parse(str);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	/**
	 * 判断字符串中是否含有 *.* 或 ￥的价格标识
	 * @param str 要判断的字符串
	 * @return   
	 */
	public static boolean isHavePriceTag(String str) {
		String reg = "\\d";
		boolean isHavePriceTag = false;
		if (str.contains(".")) {
			String[] contents = str.trim().split("");
			for (int i = 0; i < contents.length; i++) {
				if (".".equals(contents[i])) {
					if (i > 0 && i < contents.length - 1) {
						int index = i;
						int leftindex = index - 1 - 1;
						int rightIndex = index + 1;
						String left = str.substring(leftindex, index - 1);
						String right = str.substring(index, rightIndex);
						isHavePriceTag = Pattern.matches(reg, left);
						isHavePriceTag = Pattern.matches(reg, right);
					}
				} else {
					continue;
				}
				if (isHavePriceTag) {
					break;
				}
			}
		}
		if (str.contains("￥")) {
			isHavePriceTag = true;
		}
		return isHavePriceTag;
	}
	
	/**
	 * 去除字符串中的空格符\s、换行符\n和开头与结尾的逗号
	 * @param str
	 * @return
	 */
	public static String stringFilter(String str){
		if(isEmpty(str)){
			return str;
		}
		Pattern p = Pattern.compile("\\s|\n");// 过滤掉字符串中的空格符\s、换行符\n
		Matcher m = p.matcher(str);
		String after = m.replaceAll("");
		if(after.startsWith(",")){// 过滤掉字符串开头的逗号
			after = after.substring(1);
		}
		if(after.endsWith(",")){// 过滤掉字符串结尾的逗号
			after = after.substring(0,after.length() - 1);
		}
		return after;
	}
	
	/**
	 * 手机号码中间四位替换成*号
	 * @param mobile
	 * @return
	 */
	public static String stringHidMobile(String mobile){
		if(isEmpty(mobile)){
			return mobile;
		}
		//先用正则匹配是否是手机号码
		String reg = "1(3|4|5|7|8|9)\\d{9}";
		boolean b= Pattern.matches(reg,mobile);
		//是手机号码的话再进行替换，否则直接返回
		if(b){
			return mobile.substring(0,3)+"****"+mobile.substring(7);
		}
		return mobile;
	}

}

