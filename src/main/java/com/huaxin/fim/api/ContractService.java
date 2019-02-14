package com.huaxin.fim.api;

import com.dev.framework.core.annotation.Gateway;

import java.util.Map;

/**
 * 合约行情业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface ContractService {
	
	/**
	 *  定时对接合约行情数据后调用，更新合约行情盘行等内容
	 * @param date
	 * @return(errorCode 位0：成功)
	 */
	public Map<String,Object> updateContractInfo(String date);
	
	/**
	 * 验证当日对接wind数据是否成功
	 * @param date
	 * @return
	 */
	public Map<String,Object> validImportData(String date);

}
