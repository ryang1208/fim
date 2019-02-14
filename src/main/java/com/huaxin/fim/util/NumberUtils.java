package com.huaxin.fim.util;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class NumberUtils {

	/**
	 * 判断当前值是否为整数
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isInteger(Object value) {
		if (Objects.isNull(value)) {
			return false;
		}
		String mstr = value.toString();
		Pattern pattern = Pattern.compile("^-?\\d+{1}quot;");
		return pattern.matcher(mstr).matches();
	}

	/**
	 * 判断当前值是否为数字(包括小数)
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDigit(Object value) {
		if (Objects.isNull(value)) {
			return false;
		}
		String mstr = value.toString();
		Pattern pattern = Pattern.compile("^-?[0-9]*.?[0-9]*{1}quot;");
		return pattern.matcher(mstr).matches();
	}

	/**
	 * 将数字格式化输出
	 * 
	 * @param value
	 *            需要格式化的值
	 * @param precision
	 *            精度(小数点后的位数)
	 * @return
	 */
	public static String format(Object value, Integer precision) {
		Double number = 0.0;
		if (NumberUtils.isDigit(value)) {
			number = new Double(value.toString());
		}
		precision = (precision == null || precision < 0) ? 2 : precision;
		BigDecimal bigDecimal = new BigDecimal(number);
		return bigDecimal.setScale(precision, BigDecimal.ROUND_HALF_UP).toString();
	}

	/**
	 * 将数字格式化输出
	 * 
	 * @param value
	 * @return
	 */
	public static String format(Object value) {
		return NumberUtils.format(value, 2);
	}

	/**
	 * 将值转成Integer型，如果不是整数，则返回0
	 * 
	 * @param value
	 * @param replace
	 *            如果为0或者null，替换值
	 * @return
	 */
	public static Integer parseInteger(Object value, Integer replace) {
		if (!NumberUtils.isInteger(value)) {
			return replace;
		}
		return new Integer(value.toString());
	}

	/**
	 * 将值转成Integer型，如果不是整数，则返回0
	 * 
	 * @param value
	 * @return
	 */
	public static Integer parseInteger(Object value) {
		return NumberUtils.parseInteger(value, 0);
	}

	/**
	 * 将值转成Long型
	 * 
	 * @param value
	 * @param replace
	 *            如果为0或者null，替换值
	 * @return
	 */
	public static Long parseLong(Object value, Long replace) {
		if (!NumberUtils.isInteger(value)) {
			return replace;
		}
		return new Long(value.toString());
	}

	/**
	 * 将值转成Long型，如果不是整数，则返回0
	 * 
	 * @param value
	 * @return
	 */
	public static Long parseLong(Object value) {
		return NumberUtils.parseLong(value, 0L);
	}

	/**
	 * 将值转成Double型
	 * 
	 * @param value
	 * @param replace
	 *            replace 如果为0或者null，替换值
	 * @return
	 */
	public static Double parseDouble(Object value, Double replace) {
		if (!NumberUtils.isDigit(value)) {
			return replace;
		}
		return new Double(value.toString());
	}

	/**
	 * 将值转成Double型，如果不是整数，则返回0
	 * 
	 * @param value
	 * @return
	 */
	public static Double parseDouble(Object value) {
		return NumberUtils.parseDouble(value, 0.0);
	}

	/**
	 * 将char型数据转成字节数组
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(char value) {
		byte[] bt = new byte[2];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将short型数据转成字节数组
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(short value) {
		byte[] bt = new byte[2];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将int型数据转成字节数组
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(int value) {
		byte[] bt = new byte[4];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将long型数据转成字节数组
	 * 
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(long value) {
		byte[] bt = new byte[8];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将short型数据插入到指定索引的字节数组中
	 * 
	 * @param index
	 *            索引
	 * @param values
	 *            字节数组
	 * @param value
	 *            需要插入的值
	 */
	public static void insert(int index, byte[] values, short value) {
		byte[] bt = NumberUtils.toBytes(value);
		System.arraycopy(bt, 0, values, index, 2);
	}

	/**
	 * 将int型数据插入到指定索引的字节数组中
	 * 
	 * @param index
	 *            索引
	 * @param values
	 *            字节数组
	 * @param value
	 *            需要插入的值
	 */
	public static void insert(int index, byte[] values, int value) {
		byte[] bt = NumberUtils.toBytes(value);
		System.arraycopy(bt, 0, values, index, 4);
	}

	/**
	 * 将long型数据插入到指定索引的字节数组中
	 * 
	 * @param index
	 *            索引
	 * @param values
	 *            字节数组
	 * @param value
	 *            需要插入的值
	 */
	public static void insert(int index, byte[] values, long value) {
		byte[] bt = NumberUtils.toBytes(value);
		System.arraycopy(bt, 0, values, index, 8);
	}

	/**
	 * 将字节转换成整型
	 * 
	 * @param value
	 *            字节类型值
	 * @return
	 */
	public static int byteToInt(byte value) {
		if (value < 0) {
			return value + 256;
		}
		return value;
	}

	/**
	 * 将对象转换为Bigdecimal
	 * 
	 * @Date: 2017年3月8日 下午2:22:51
	 */
	public static BigDecimal toBigDecimal(Object value, BigDecimal replace) {
		if (Objects.isNull(value)) {
			return replace;
		}
		return new BigDecimal(Objects.toString(value));
	}

	/**
	 * 
	 * @Author:lihuijun
	 * @Date: 2017年3月8日 下午3:30:20
	 */
	public static BigDecimal multiply(Object value1, Object value2) {
		BigDecimal b1 = toBigDecimal(value1, BigDecimal.ZERO);
		BigDecimal b2 = toBigDecimal(value2, BigDecimal.ZERO);
		return b1.multiply(b2);
	}
	
	public static BigDecimal formatBigDecimalScale(BigDecimal value, int scale){
		if(value == null){
			return null;
		}else{
			return value.setScale(scale, BigDecimal.ROUND_HALF_UP);
		}
	}
	
	/**
	 * 按乘数相乘后并按指定位数获取最后结果
	 * @param data		原数据
	 * @param multiNum	乘数(放大倍数)
	 * @param scale		截取结果位数
	 * @return
	 */
	public static BigDecimal formatBigDecimalByMultiNumAndScale(BigDecimal data, int multiNum, int scale){
		if(data == null)
			return null;
		BigDecimal tmp = data.multiply(new BigDecimal(multiNum));
		return tmp.setScale(scale, BigDecimal.ROUND_HALF_UP);
	}

}
