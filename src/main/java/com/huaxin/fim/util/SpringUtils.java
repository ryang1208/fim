package com.huaxin.fim.util;

import com.dev.framework.core.util.ApplicationUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * 根据SpringID获取实体对象bean
 * 
 * @author lihj
 *
 */
public final class SpringUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) ApplicationUtils.getContext().getBean(name);
	}

	public static <T> T getBean(Class<T> clz) throws BeansException {
		T result = (T) ApplicationUtils.getContext().getBean(clz);
		return result;
	}

	public static boolean containsBean(String name) {
		return ApplicationUtils.getContext().containsBean(name);
	}

	public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		return ApplicationUtils.getContext().isSingleton(name);
	}

	public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
		return ApplicationUtils.getContext().getType(name);
	}

	public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
		return ApplicationUtils.getContext().getAliases(name);
	}

}
