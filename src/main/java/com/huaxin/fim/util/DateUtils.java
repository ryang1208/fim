package com.huaxin.fim.util;


import com.huaxin.fim.entity.enums.PeriodTypeEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

	private static final String df = "yyyy-MM-dd";
	
	private static final String df2 = "yyyyMMdd";
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(df2);

	/**
	 * <pre>
	 *   返回该月可能的最大日期。
	 *   
	 *   &lt;strong&gt;程序范例：&lt;/strong&gt;
	 *   Date date = new Date();
	 *   Date new = DateUtils.actualMaximumDate(date);
	 *   
	 *   例如传入的日期为2008年4月1日，
	 *   则返回的日期是2008年4月30日。
	 * 
	 * </pre>
	 * 
	 * @param date
	 * @return
	 */
	public static Date actualMaximumDate(Date date) {
		Calendar calendar = calendar(date);
		int actualMaximumDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, actualMaximumDay);
		return calendar.getTime();
	}

	/**
	 * <pre>
	 *   返回该月可能的最小日期。
	 *   
	 *   &lt;strong&gt;程序范例：&lt;/strong&gt;
	 *   Date date = new Date();
	 *   Date new = DateUtils.actualMinimumDate(date);
	 *   
	 *   例如传入的日期为2008年4月20日，
	 *   则返回的日期是2008年4月1日。
	 * 
	 * </pre>
	 * 
	 * @param date
	 * @return
	 */
	public static Date actualMinimumDate(Date date) {
		Calendar calendar = calendar(date);
		int actualMininumDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, actualMininumDay);
		return calendar.getTime();
	}

	/**
	 * 获取制定日期的月数差
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int monthBetween(Date startDate, Date endDate) {
		int months = 0;
		Calendar startDay = calendar(startDate);
		Calendar endDay = calendar(endDate);

		int startYear = startDay.get(Calendar.YEAR);
		int startMonth = startDay.get(Calendar.MONTH);

		int endYear = endDay.get(Calendar.YEAR);
		int endMonth = endDay.get(Calendar.MONTH);

		months = (endYear - startYear) * 12 + (endMonth - startMonth);
		return months;
	}

	/**
	 * <pre>
	 *   将指定日期转换为相应的Calendar对象
	 *   
	 *   &lt;strong&gt;程序范例：&lt;/strong&gt;
	 *   Date date = new Date();
	 *   Calendar calendar = DateUtils.calendar(date);
	 * 
	 * </pre>
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar calendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 返回一个指定日期的Calendar实例
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 返回指定日期的默认格式字符串输出
	 * 
	 * @param date
	 *            指定日期
	 * @return
	 */
	public static String getTimeByCustomPattern(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 返回月
	 * 
	 * @return
	 */
	public static int getMonth(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回年
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar calendar = getCalendar(date);
		return calendar.get(Calendar.YEAR);
	}

	public static Date parse(String str, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(str);
		} catch (ParseException e) {
			throw new RuntimeException("日期格式转换错误", e);
		}
	}

	public static String formatDate(Date d) {
		return new SimpleDateFormat(df).format(d);
	}
	
	public static String dateFormat(Date d) {
		return new SimpleDateFormat(df2).format(d);
	}

	/**
	 * 获取指定日期的上一天 日期格式:yyyy-MM-dd 
	 * @throws
	 */
	public static String getBeforeDay(String str) {
		return getBeforeDays(str, 1);
	}

	/**
	 * 获取当前日期之前period的日期
	 * @Title: getBeforeDays    
	 * @throws
	 */
	public static String getBeforeDays(String str, int period) {
		Date date = parse(str, df);
		Calendar calendar = getCalendar(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - period);
		return formatDate(calendar.getTime());

	}

	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		if(smdate.indexOf("-") != -1){
			smdate = smdate.replace("-", "");
		}
		
		if(bdate.indexOf("-") != -1){
			bdate = bdate.replace("-", "");
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 获取日期差返回日期List ,包含开始日期,不包含结束日期
	 * 
	 * @author 2012-6-11
	 *            起始月
	 *            终止月
	 * @return
	 */
	public static List<Date> getBetweenDates(Date start, Date end) {
		List<Date> result = new ArrayList<Date>();
//		result.add(start);
		Calendar tempStart = Calendar.getInstance();
		tempStart.setTime(start);
		tempStart.add(Calendar.DAY_OF_YEAR, 1);

		Calendar tempEnd = Calendar.getInstance();
		tempEnd.setTime(end);
		while (tempStart.before(tempEnd)) {
			result.add(tempStart.getTime());
			tempStart.add(Calendar.DAY_OF_YEAR, 1);
		}
		// result.add(end);
		return result;
	}
	
	
	public static List<Date> getBetweenDates(String start, String end) {
		Date dStart = parse(start, df);
		Date dEnd = parse(end, df);
		return getBetweenDates(dStart, dEnd);
	}

	public static String getDateByDateAndLen(String dateFrom, int dateLength){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
		try {
			date = sdf.parse(dateFrom);
		} catch (Exception e) {
		}
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dateLength);
        Date date1 = calendar.getTime();
        String dateOut = sdf.format(date1);
        return dateOut;
	}
	
	/**
	 * 以某日获取提前N个月的日期
	 * @param currentDate	指定日期(yyyyMMdd)
	 * @param beforeType	指定往前类型
	 * @return	提前的日期(yyyyMMdd)
	 */
	public static String getDateBefore(String currentDate, int beforeType){
		
		if(beforeType == PeriodTypeEnum.UNTIL_NOW.getMonth() || beforeType == PeriodTypeEnum.ONE_DAY.getMonth()){
			return null;
		}
		
		LocalDate date = LocalDate.parse(currentDate, FORMATTER);
		
		if(beforeType == PeriodTypeEnum.THIS_YEAR.getMonth()){
			return currentDate.substring(0, 4) + "0101";
		}else{
			return date.minusMonths(beforeType).format(FORMATTER);
		}
		
	}
}