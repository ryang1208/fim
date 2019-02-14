package com.huaxin.fim.api;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.request.BLOpinionRequest;

/**
 * 
 * 资产配置B-L算法业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface BLAlgorithmService {
	
	/**
	 * BL模型
	 * @param productIs
	 * @param beginDate
	 * @param endDate
	 * @param opinionList 投资者观点
	 * @return 
	 */
	public Map<String,Object> getBLModel(List<String> productIs, String beginDate, String endDate, List<BLOpinionRequest> opinionList);

}
