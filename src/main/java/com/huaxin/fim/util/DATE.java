package com.huaxin.fim.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * 日期公用方法
 * @author sst
 *
 */
public class DATE {
	
	private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(  
            "yyyyMMdd HH:mm:ss");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(  
            "yyyyMMdd"); 
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat(  
            "HH:mm:ss"); 
	private static final SimpleDateFormat dateFormat2 = new SimpleDateFormat(  
            "yyyy-MM-dd");
	
	/** 
     * 获得当前日期 
     * <p> 
     * 日期格式yyyy-MM-dd 
     *  
     * @return 
     */  
    public static String currentDateFormat() {  
        return dateFormat2.format(new Date());  
    }
    
    /** 
     * 获得当前日期 
     * <p> 
     * 日期格式yyyy-MM-dd 
     *  
     * @return 
     */  
    public static String currentDateFormat(Date date) {  
        return dateFormat2.format(date);  
    }
    
   
	
	/** 
     * 获得当前日期 
     * <p> 
     * 日期格式yyyyMMdd 
     *  
     * @return 
     */  
    public static String currentDate() {  
        return dateFormat.format(new Date());  
    }
    
    /** 
     * 获得当前时间 
     * <p> 
     * 时间格式HH:mm:ss 
     *  
     * @return 
     */  
    public static String currentTime() {  
        return timeFormat.format(new Date());  
    }  
	
	/** 
     * 获得当前日期时间 
     * <p> 
     * 日期时间格式yyyyMMdd HH:mm:ss 
     *  
     * @return 
     */  
    public static String currentDatetime() {  
        return datetimeFormat.format(new Date());  
    }  
  
    /** 
     * 格式化日期时间 
     * <p> 
     * 日期时间格式yyyyMMdd HH:mm:ss 
     *  
     * @return 
     */  
    public static String formatDatetime(Date date) {  
        return datetimeFormat.format(date);  
    }  
	
	
	/** 
     * 将字符串日期转换成java.util.Date类型 
     *<p> 
     * 日期时间格式yyyyMMdd 
     *  
     * @param date 
     * @return 
     * @throws ParseException 
     */  
    public static Date parseDate(String date) throws ParseException {  
    	SimpleDateFormat df = new SimpleDateFormat( "yyyyMMdd"); 
        return df.parse(date);  
    } 
    
    
    /** 
     * 将java.util.Date转换成类型 字符串日期
     *<p> 
     * 日期时间格式yyyyMMdd 
     *  
     * @param date 
     * @return 
     * @throws ParseException 
     */  
    public static String formatDate(Date date) throws ParseException {  
        return dateFormat.format(date);  
    }  
    
    /** 
     *判断原日期是否在目标日期之前 
     *  
     * @param src 
     * @param dst 
     * @return 
     */  
    public static boolean isBefore(Date src, Date dst) {  
        return src.before(dst);  
    } 
    
    /** 
     *判断原日期是否在目标日期之后 
     *  
     * @param src 
     * @param dst 
     * @return 
     */  
    public static boolean isAfter(Date src, Date dst) {  
        return src.after(dst);  
    } 
    
    /** 
     *判断两日期是否相同 
     *  
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static boolean isEqual(Date date1, Date date2) {  
        return date1.compareTo(date2) == 0;  
    }
    
    /** 
     * 判断某个日期是否在某个日期范围 
     *  
     * @param beginDate 
     *            日期范围开始 
     * @param endDate 
     *            日期范围结束 
     * @param src 
     *            需要判断的日期 
     * @return 
     */  
    public static boolean between(Date beginDate, Date endDate, Date src) {  
        return beginDate.before(src) && endDate.after(src);  
    }  
  
    public static Calendar calendar() {  
        Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        return cal;  
    } 
    
    /** 
     * 获得当前月的最后一天 
     * <p> 
     * HH:mm:ss为0，毫秒为999 
     *  
     * @return 
     */  
    public static Date lastDayOfMonth() {  
        Calendar cal = calendar();  
        cal.set(Calendar.DAY_OF_MONTH, 0); // M月置零  
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零  
        cal.set(Calendar.MINUTE, 0);// m置零  
        cal.set(Calendar.SECOND, 0);// s置零  
        cal.set(Calendar.MILLISECOND, 0);// S置零  
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);// 月份+1  
        cal.set(Calendar.MILLISECOND, -1);// 毫秒-1  
        return cal.getTime();  
    }  
  
    /** 
     * 获得当前月的第一天 
     * <p> 
     * HH:mm:ss SS为零 
     *  
     * @return 
     */  
    public static Date firstDayOfMonth() {  
        Calendar cal = calendar();  
        cal.set(Calendar.DAY_OF_MONTH, 1); // M月置1  
        cal.set(Calendar.HOUR_OF_DAY, 0);// H置零  
        cal.set(Calendar.MINUTE, 0);// m置零  
        cal.set(Calendar.SECOND, 0);// s置零  
        cal.set(Calendar.MILLISECOND, 0);// S置零  
        return cal.getTime();  
    }  
    
    private static Date weekDay(int week) {  
        Calendar cal = calendar();  
        cal.set(Calendar.DAY_OF_WEEK, week);  
        return cal.getTime();  
    }  
  
    /** 
     * 获得周五日期 
     * <p> 
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday 
     *  
     * @return 
     */  
    public static Date friday() {  
        return weekDay(Calendar.FRIDAY);  
    }  
  
    /** 
     * 获得周六日期 
     * <p> 
     * 注：日历工厂方法{@link #calendar()}设置类每个星期的第一天为Monday，US等每星期第一天为sunday 
     *  
     * @return 
     */  
    public static Date saturday() {  
        return weekDay(Calendar.SATURDAY);  
    } 
    
    /** 
	  * 获取两个日期之间相差天数
	  *<p> 
	  *  
	  * @param time 
	  * Return 
	  * @throws ParseException 
	  */  
	public static int  getDasyBetween(String date1, String date2) throws ParseException{
	    if(date1 == null || date1.equals("") || date2 == null || date2.equals("")){
		return -10000;
	    }
	    long mill_start = parseDate(date1).getTime();
	    long mill_end = parseDate(date2).getTime();
	    long days_between = (mill_end - mill_start)/(1000*60*60*24);
	    return Integer.parseInt(String.valueOf(days_between)); 
	}
	
	public static final String DATE_PATTERN = "yyyyMMdd";
	
	public static Date parseDate(String dateValue, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateValue);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String format(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	/**
	 * 取得指定日期當周第一天
	 * @param date
	 * @return
	 */
	public static Date getFristDayOfWeek(Date date){		 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, 1);		
		return cal.getTime();
	}
	/**
	 * 取得指定日期當周最後一天
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, 7);		
		return cal.getTime();
	}
	
	/**
	 * 取得指定日期當月第一天
	 * @param date
	 * @return
	 */
	public static Date getFristDayOfMonth(Date date){		 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);		
		return cal.getTime();
	}
	/**
	 * 取得指定日期當月最後一天
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, max);		
		return cal.getTime();
	}	
	/**
	 * 是否為周末(周六、周日皆认定为周末)
	 * @param date
	 * @return
	 */
	public static boolean isWeekEnd(String tradingDay){
		boolean flag = false;
		Date tradingDayDate = parseDate(tradingDay,DATE_PATTERN);		
		Date date = getLastDayOfWeek(tradingDayDate);	
		Date staurday = getFristDayOfWeek(tradingDayDate);	
		if(tradingDay.equals(format(date,DATE_PATTERN))||tradingDay.equals(format(staurday,DATE_PATTERN))){
			flag = true;
		}
		return flag;
	}
	/**
	 * 是否為月末
	 * @param date
	 * @return
	 */
	public static boolean isMonthEnd(String tradingDay){
		boolean flag = false;
		Date tradingDayDate = parseDate(tradingDay,DATE_PATTERN);		
		Date date = getLastDayOfMonth(tradingDayDate);			
		if(tradingDay.equals(format(date,DATE_PATTERN))){
			flag = true;
		}
		return flag;
	}
	
	/** 锁对象 */
    private static final Object lockObj = new Object();
	
	/** 存放不同的日期模板格式的sdf的Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
	
    /**
     * 是用ThreadLocal<SimpleDateFormat>来获取SimpleDateFormat,这样每个线程只会有一个SimpleDateFormat
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String threadFormat(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date threadParse(String dateStr, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }
    
    
	/**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     * 
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
                    System.out.println("put new sdf of pattern " + pattern + " to map");

                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {

                        @Override
                        protected SimpleDateFormat initialValue() {
                            System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

	/**
	 * 日期计算
	 * @param date 日期
	 * @param year 年加减数
	 * @param month 月加减数
	 * @param day 日加减数
	 */
	public static String addDate(String date,int year,int month, int day){
		String resultDate = date;
		try {
			Date sdfdate = parseDate(date);
			Calendar calendar = Calendar.getInstance();//日历对象
			calendar.setTime(sdfdate);//设置当前日期
			if(year!=0){
				calendar.add(Calendar.YEAR, year);//年
			}
			if(month!=0){
				calendar.add(Calendar.MONTH, month);//月份
			}
			if(day!=0){
				calendar.add(Calendar.DATE, day);//月份
			}
			resultDate = formatDate(calendar.getTime());
		} catch (ParseException e) {
			System.out.println("date==============="+date);
			e.printStackTrace();
		}
		return resultDate;
	}
	
	/**
	 * 日期计算(多线程)
	 * @param date 日期
	 * @param year 年加减数
	 * @param month 月加减数
	 * @param day 日加减数
	 */
	public static String addThreadDate(String date,int year,int month, int day){
		String resultDate = date;
		try {
			Date sdfdate = threadParse(date,"yyyyMMdd");
			Calendar calendar = Calendar.getInstance();//日历对象
			calendar.setTime(sdfdate);//设置当前日期
			if(year!=0){
				calendar.add(Calendar.YEAR, year);//年
			}
			if(month!=0){
				calendar.add(Calendar.MONTH, month);//月份
			}
			if(day!=0){
				calendar.add(Calendar.DATE, day);//月份
			}
			resultDate = threadFormat(calendar.getTime(),"yyyyMMdd");
		} catch (ParseException e) {
			System.out.println("date==============="+date);
			e.printStackTrace();
		}
		return resultDate;
	}

}
