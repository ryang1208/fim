package com.huaxin.fim.util;

import com.dev.framework.core.exception.ServiceException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lihj on 2017/2/23.
 */

public class DataFormatUtil {

	/**
	 * 字符串MD5编码
	 * 
	 * @param str
	 * @return
	 * @throws ServiceException
	 */
	public static String enCodeByMd5(String str) throws ServiceException {
		if (StringUtils.isBlank(str)) {
			throw new ServiceException(1, "编码参数不能为空");
		}
		return DigestUtils.md5Hex(str).toUpperCase();
	}

	/**
	 * 描述信息： 按照字典升序排列
	 *
	 * @param
	 * @return Map<String,String>
	 * @author lihuijun
	 */
	public static Map<String, String> sortHashMap(Map<String, String> map) {
		Set<String> set = map.keySet();
		Object[] arr = set.toArray();
		Arrays.sort(arr);
		Map<String, String> result = new LinkedHashMap<>();
		for (Object key : arr) {
			String str = Objects.toString(key);
			result.put(str, (String) map.get(key));
		}
		return result;
	}

	public static String getRequestStr(Map<String, String> param) {
		String str = "";
		for (Iterator<Entry<String, String>> iter = param.entrySet().iterator(); iter.hasNext();) {
			Entry<String, String> element = (Entry<String, String>) iter.next();
			Object key = element.getKey();
			Object value = element.getValue();
			str += key + "=" + value + "&";
		}
		str = str.substring(0, str.length() - 1);
		return str;
	}

	/**
	 * 提取字符串中字符
	 * 
	 * @Description:
	 * @param source
	 * @return
	 * @Author:lihuijun
	 * @Date: 2017年3月9日 上午11:22:36
	 */
	public static String regExStr(String source) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) {
				sb.append(c);
			}
		}
		return Objects.toString(sb);
	}
}
