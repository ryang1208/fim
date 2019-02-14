package com.huaxin.fim.api.common;

import javax.validation.constraints.NotNull;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.CustomParameter;

@Gateway
public interface CustomParameterService {

	/**
	 * 修改系统参数 
	 * @return: CustomParameter 
	 * @throws
	 */
	public CustomParameter update(@NotNull(message = "1|待修改的参数对象不能为空") CustomParameter customParameter);

	/**
	 * 根据参数代码查询系统参数 
	 * @return: CustomParameter 
	 * @throws
	 */
	public CustomParameter queryByParameterCode(@NotNull(message = "1|参数代码不能为空") String parameterCode) ;
		 

}
