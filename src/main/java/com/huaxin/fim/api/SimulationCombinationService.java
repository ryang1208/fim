package com.huaxin.fim.api;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.SimulationProduct;
import com.huaxin.fim.entity.entity.SimulationProductRelationship;
import com.huaxin.fim.entity.entity.TmpSimulationProduct;
import com.huaxin.fim.entity.request.BLOpinionRequest;

/**
 * 模拟组合构建业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface SimulationCombinationService {

	/**
	 * 获取选择成分基金明细
	 * @return
	 */
	public Map<String,Object> getSelectedProductList();
	
	/**
	 * 获取模拟组合产品存续期
	 * @param productIdList
	 * @param beginDate
	 * @return
	 */
	 public Map<String,Object> getDurationList(List<String> productIdList, String beginDate);

	 /**
	  * 获取产品存续期时间区间的交易天数
	  * @param productIdList
	  * @param minDate
	  * @param maxDate
	  * @return
	  */
	 public Map<String,Object> getTradeDays(List<String> productIdList, String minDate, String maxDate);

	 /**
	  * 获取组合产品组合业绩
	  * @param sp
	  * @param sprList
	  * @param productIds
	  * @return
	  */
	 public Map<String,Object> getProductPerformance(TmpSimulationProduct sp, List<SimulationProductRelationship> sprList, List<String> productIds);

	 /**
	  * 获取产品的协方差
	  * @param productIds
	  * @param beginDate
	  * @param endDate
	  * @return
	  */
	 public Map<String,Object> getCovariance(List<String> productIds, String beginDate, String endDate);

	 /**
	  * 保存组合构建产品
	  * @param sp
	  * @param sprList
	  * @return
	  */
	 public Map<String,Object> saveSimulation(SimulationProduct sp, List<SimulationProductRelationship> sprList);

	 /**
	  * 根据组合产品名称查询组合产品是否存在
	  * @param name
	  * @return
	  */
	 public Map<String,Object> getSimulationByName(String name);

	 /**
	  * 获取MVO模型前沿曲线
	  * @param productIds
	  * @param beginDate
	  * @param endDate
	  * @return
	  */
	 public Map<String,Object> getMVO(List<String> productIds, String beginDate, String endDate);


	 /**
	  * 获取产品列表
	  * @return
	  */
	 public Map<String,Object> getProductNameListForBL();

	 /**
	  * 获取BL模型权重比例
	  * @param productIds
	  * @param beginDate
	  * @param endDate
	  * @param opinionList
	  * @return
	  */
	 public Map<String,Object> getBLModel(List<String> productIds, String beginDate, String endDate, List<BLOpinionRequest> opinionList);

}
