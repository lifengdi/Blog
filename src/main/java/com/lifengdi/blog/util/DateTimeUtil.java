package com.lifengdi.blog.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期工具类
 * @author 李锋镝
 * @date 2017年1月18日 下午4:58:33
 * @version 1.0.0
 */
public class DateTimeUtil {
	/** 
	 * 缺省的日期显示格式： yyyy-MM-dd 
	 */  
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";  

	/** 
	 * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm:ss 
	 */  
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  

	/**
	 * 缺省的日期时间显示格式：yyyy-MM-dd HH:mm
	 */ 
	public static final String DEFAULT_DATE_TIME_HHmm_FORMAT = "yyyy-MM-dd HH:mm"; 

	/**
	 * 缺省的日期时间显示格式：yyyy-MM-dd HH
	 */ 
	public static final String DEFAULT_DATE_TIME_HH_FORMAT = "yyyy-MM-dd HH"; 

	/**
	 * 缺省的时间显示格式：HH:mm:ss
	 */ 
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	/**
	 * 缺省的时间显示格式：HH:mm
	 */ 
	public static final String DEFAULT_TIME_HHmm_FORMAT = "HH:mm"; 

	/** 
	 * 1s中的毫秒数 
	 */  
	private static final int MILLIS = 1000;  

	/** 
	 * 一年当中的月份数 
	 */  
	private static final int MONTH_PER_YEAR = 12;  

	/** 
	 * 私有构造方法，禁止对该类进行实例化 
	 */  
	private DateTimeUtil() {  
	}  

	/** 
	 * 得到系统当前日期时间 
	 * @return 当前日期时间 
	 */  
	public static Date getNow() {  
		return Calendar.getInstance().getTime();  
	}  

	/** 
	 * 得到用缺省方式格式化的当前日期 
	 *  
	 * @return 当前日期 
	 */  
	public static String getDate() {  
		return getDateTime(DEFAULT_DATE_FORMAT);  
	}  

	/** 
	 * 得到用缺省方式格式化的当前日期及时间 
	 * @return 当前日期及时间 
	 */  
	public static String getDateTime() {  
		return getDateTime(DEFAULT_DATE_TIME_FORMAT);  
	}  

	/** 
	 * 得到系统当前日期及时间，并用指定的方式格式化 
	 * @param pattern 显示格式 
	 * @return 当前日期及时间 
	 */  
	public static String getDateTime(String pattern) {  
		Date datetime = Calendar.getInstance().getTime();  
		return getDateTime(datetime, pattern);  
	}  


	/** 
	 * 得到用指定方式格式化的日期 
	 * @param date 需要进行格式化的日期 
	 * @param pattern 显示格式 
	 * @return 日期时间字符串 
	 */  
	public static String getDateTime(Date date, String pattern) {  
		if (StringUtil.isBlank(pattern)) {  
			pattern = DEFAULT_DATE_TIME_FORMAT;  
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);  
		return dateFormat.format(date);  
	}  

	/** 
	 * 得到当前年份 
	 * @return 当前年份 
	 */  
	public static int getCurrentYear() {  
		return Calendar.getInstance().get(Calendar.YEAR);  

	}  

	/** 
	 * 得到当前月份 
	 * @return 当前月份 
	 */  
	public static int getCurrentMonth() {  
		//用get得到的月份数比实际的小1，需要加上  
		return Calendar.getInstance().get(Calendar.MONTH) + 1;  
	}  

	/** 
	 * 得到当前日 
	 * @return 当前日 
	 */  
	public static int getCurrentDay() {  
		return Calendar.getInstance().get(Calendar.DATE);  
	}

	/**
	 * 改变当前时间的秒数
	 * @param date 基准时间
	 * @param seconds 要增加或者减少的秒数（减少用负数表示）
	 * @param pattern 日期格式
	 * @return 改变后的时间
	 */
	public static String addSeconds(Date date, int seconds, String pattern){
		return getDateTime(addSeconds(date, seconds), pattern);
	}

	/**
	 * 改变当前时间的秒数
	 * @param date 基准时间
	 * @param seconds 要增加或者减少的秒数（减少用负数表示）
	 * @return 改变后的时间
	 */
	public static Date addSeconds(Date date, int seconds){
		return add(date, seconds, Calendar.SECOND);
	}

	/**
	 * 改变当前时间的分钟数
	 * @param date 基准时间
	 * @param minutes 要增加或者减少的分钟数（减少用负数表示）
	 * @param pattern 日期格式
	 * @return 改变后的时间
	 */
	public static String addMinutes(Date date, int minutes, String pattern){
		return getDateTime(addMinutes(date, minutes), pattern);
	}

	/**
	 * 改变当前时间的分钟数
	 * @param date 基准时间
	 * @param minutes 要增加或者减少的分钟数（减少用负数表示）
	 * @return 改变后的时间
	 */
	public static Date addMinutes(Date date, int minutes){
		return add(date, minutes, Calendar.MINUTE);
	}

	/**
	 * 改变当前时间的小时
	 * @param date 基准时间
	 * @param hours 要增加或者减少的小时（减少用负数表示）
	 * @param pattern 日期格式
	 * @return 改变后的时间
	 */
	public static String addHours(Date date, int hours, String pattern){
		return getDateTime(addHours(date, hours), pattern);
	}

	/**
	 * 改变当前时间的小时
	 * @param date 基准时间
	 * @param hours 要增加或者减少的小时（减少用负数表示）
	 * @return 改变后的时间
	 */
	public static Date addHours(Date date, int hours){
		return add(date, hours, Calendar.HOUR);
	}

	/** 
	 * 取得当前日期以后若干天的日期。如果要得到以前的日期，参数用负数。 例如要得到上星期同一天的日期，参数则为-7 
	 * @param date 基准时间
	 * @param days 增加的日期数 
	 * @param pattern 日期格式
	 * @return 改变以后的日期 
	 */  
	public static String addDays(Date date, int days, String pattern) {  
		return getDateTime(addDays(date, days), pattern);  
	}  

	/** 
	 * 取得指定日期以后若干天的日期。如果要得到以前的日期，参数用负数。 
	 * @param date 基准时间
	 * @param days 增加的日期数 
	 * @return 改变以后的日期 
	 */  
	public static Date addDays(Date date, int days) {  
		return add(date, days, Calendar.DATE);  
	}  

	/** 
	 * 取得当前日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 
	 * @param date 基准时间
	 * @param months 增加的月份数 
	 * @param pattern 日期格式
	 * @return 改变以后的日期 
	 */  
	public static String addMonths(Date date, int months, String pattern) {  
		return getDateTime(addMonths(date, months), pattern);  
	}  

	/** 
	 * 取得指定日期以后某月的日期。如果要得到以前月份的日期，参数用负数。 
	 * 注意，可能不是同一日子，例如2003-1-31加上一个月是2003-2-28 
	 * @param date 基准时间
	 * @param months 增加的月份数 
	 * @return 改变以后的日期 
	 */  
	public static Date addMonths(Date date, int months) {  
		return add(date, months, Calendar.MONTH);  
	}

	/** 
	 * 取得当前日期以后某年的日期
	 * @param date 基准时间
	 * @param years 增加的年份数 
	 * @param pattern 日期格式
	 * @return 改变以后的日期 
	 */  
	public static String addYears(Date date, int years, String pattern) {  
		return getDateTime(addYears(date, years), pattern);  
	}  

	/** 
	 * 取得当前日期以后某年的日期
	 * @param date 基准时间
	 * @param years 增加的年份数 
	 * @return 改变以后的日期 
	 */  
	public static Date addYears(Date date, int years) {  
		return add(date, years, Calendar.YEAR);  
	} 

	/** 
	 * 内部方法。为指定日期增加相应的天数或月数 
	 * @param date 基准时间
	 * @param amount 改变的数量 
	 * @param field 改变的时间的单位，年、月、日、时、分、秒等 
	 * @return 改变以后的日期 
	 */  
	private static Date add(Date date, int amount, int field) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  
		calendar.add(field, amount);  
		return calendar.getTime();  
	}  
	/** 
	 * 通过date对象取得格式为小时:分钟的字符串 
	 * @return 
	 */  
	public static String getHourMin(Date date){  
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer sf = new StringBuffer();          
		sf.append(calendar.get(Calendar.HOUR_OF_DAY));  
		sf.append(":");
		sf.append(calendar.get(Calendar.MINUTE));  
		return sf.toString();  
	}  

	/** 
	 * 计算两个日期相差天数。 用第一个日期减去第二个。如果前一个日期小于后一个日期，则返回负数 
	 * @param one 第一个日期数，作为基准 
	 * @param two 第二个日期数，作为比较 
	 * @return 两个日期相差天数 
	 */  
	public static long diffDays(Date one, Date two) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.clear();  
		calendar.setTime(one);  
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
		Date d1 = calendar.getTime();  
		calendar.clear();  
		calendar.setTime(two);  
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
		Date d2 = calendar.getTime();  
		final int MILISECONDS = 24 * 60 * 60 * 1000;  
		BigDecimal r = BigDecimal.valueOf(Double.valueOf((d1.getTime() - d2.getTime())) / MILISECONDS);          
		return Math.round(r.doubleValue());  
	}  

	/** 
	 * 计算两个日期相差月份数 如果前一个日期小于后一个日期，则返回负数 
	 * @param one 第一个日期数，作为基准 
	 * @param two 第二个日期数，作为比较 
	 * @return 两个日期相差月份数 
	 */  
	public static int diffMonths(Date one, Date two) {  

		Calendar calendar = Calendar.getInstance();  

		//得到第一个日期的年分和月份数  
		calendar.setTime(one);  
		int yearOne = calendar.get(Calendar.YEAR);  
		int monthOne = calendar.get(Calendar.MONDAY);  
		//得到第二个日期的年份和月份  
		calendar.setTime(two);  
		int yearTwo = calendar.get(Calendar.YEAR);  
		int monthTwo = calendar.get(Calendar.MONDAY);  

		return (yearOne - yearTwo) * MONTH_PER_YEAR + (monthOne - monthTwo);  
	}

	/** 
	 * 计算两个日期相差年份数 如果前一个日期小于后一个日期，则返回负数 
	 * @param one 第一个日期数，作为基准 
	 * @param two 第二个日期数，作为比较 
	 * @return 两个日期相差月份数 
	 */  
	public static int diffYears(Date one, Date two) {  

		Calendar calendar = Calendar.getInstance();  

		//得到第一个日期的年分 
		calendar.setTime(one);  
		int yearOne = calendar.get(Calendar.YEAR);  
		//得到第二个日期的年份
		calendar.setTime(two);  
		int yearTwo = calendar.get(Calendar.YEAR);  

		return yearOne - yearTwo;  
	}

	/** 
	 * 获取某一个日期的年份 
	 * @param date 
	 * @return 
	 */  
	public static int getYear(Date date) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  
		return calendar.get(Calendar.YEAR);  
	}  

	/** 
	 * 将一个字符串用给定的格式转换为日期类型。
	 * 注意：如果返回null，则表示解析失败 
	 * @param datestr 需要解析的日期字符串 
	 * @param pattern 日期字符串的格式，默认为"yyyy-MM-dd"的形式 
	 * @return 解析后的日期 
	 */  
	public static Date parse(String dateStr, String pattern) {  
		Date date = null;  
		if (StringUtil.isBlank(pattern)) {  
			pattern = DEFAULT_DATE_FORMAT;  
		}  
		try {  
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);  
			date = dateFormat.parse(dateStr);  
		} catch (ParseException e) {  
			e.printStackTrace();  
		}  
		return date;  
	}  

	/** 
	 * 返回本月的最后一天 
	 * @return 本月最后一天的日期 
	 */  
	public static Date getMonthLastDay() {  
		return getMonthLastDay(getNow());  
	}  

	/** 
	 * 返回给定日期中的月份中的最后一天 
	 *  
	 * @param date 基准日期 
	 * @return 该月最后一天的日期 
	 */  
	public static Date getMonthLastDay(Date date) {  

		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date);  

		//将日期设置为下一月第一天  
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1);  

		//减去1天，得到的即本月的最后一天  
		calendar.add(Calendar.DATE, -1);  

		return calendar.getTime();  
	}  

	/** 
	 * 计算两个具体日期之间的秒差，第一个日期-第二个日期 
	 * @param date1  
	 * @param date2 
	 * @param onlyTime 是否只计算2个日期的时间差异，忽略日期，true代表只计算时间差 
	 * @return 
	 */  
	public static long diffSeconds(Date date1, Date date2, boolean onlyTime) {  
		if (onlyTime) {  
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(date1);  
			//calendar.set(1984, 5, 24);  
			long t1 = calendar.getTimeInMillis();  
			calendar.setTime(date2);  
			//calendar.set(1984, 5, 24);  
			long t2 = calendar.getTimeInMillis();  
			return (t1-t2)/MILLIS;  
		} else {  
			return (date1.getTime()-date2.getTime())/MILLIS;  
		}  
	}  

	/**
	 * 计算两个具体日期之间的秒差，第一个日期-第二个日期 
	 * @param date1 
	 * @param date2 
	 * @return 
	 */  
	public static long diffSeconds(Date date1, Date date2) {  
		return diffSeconds(date1, date2, false);  
	}  

	/** 
	 * 根据日期确定星期几:1-星期日，2-星期一.....
	 * @param date 
	 * @return 
	 */  
	public static int getDayOfWeek(Date date){  
		Calendar cd = Calendar.getInstance();     
		cd.setTime(date);     
		int mydate = cd.get(Calendar.DAY_OF_WEEK);   
		return mydate;  
	}  

	/** 
	 * 验证是否在有效期内(跟当前日期比较) 
	 * @param validDate 要比较的时间
	 * @param format 日期字符串的格式 
	 * @return 
	 */  
	public static boolean isValidDate(String validDate, String format) {  
		return isValidDate(validDate, getDateTime(), format);  
	}

	/** 
	 * 验证是否在有效期内(跟当前日期比较) 
	 * @param validDate 要比较的时间
	 * @param date 基准时间
	 * @param format 日期字符串的格式 
	 * @return 
	 */ 
	public static boolean isValidDate(String validDate, String date, String format) {
		if(validDate==null||validDate.equals("")){
			return false;
		}
		Date valid=null;
		Date now = new Date();
		valid = parse(validDate, format);  
		now = parse(date, format);
		return valid.after(now);  
	}
}
