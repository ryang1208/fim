package com.huaxin.fim.api.datainterface;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.request.InvestmentManagerRegisterRequest;

import java.util.Map;

/**
 * 对外调用接口
 * 
 * @author sust
 *
 */

@Gateway
public interface DataInterfaceService {

	/**
	 * 投顾注册
	 */
	public Map<String,Object> investmentManagerRegister(InvestmentManagerRegisterRequest request);

//	/**
//	 * 产品注册 传入数据请用json格式
//	 * 
//	 
//	 * @return
//	 */
//	public Map<String,Object> productRegister(String systemId,String requestType,String productName,String productInvestmentManager,
//			String productType,String CalculateNetValue ,String productStatus,String ProductCode,String initialAsset, String strategy_list,
//			String investerIds, String childProductIds, String productManagerName, String major, String education,String school,
//			String hireDate, String position, String hasSecurityQualification, String curriculumVitae);

//	/**
//	 * 报告订阅
//	 * 
//	 * @param kpiCode
//	 * @param beginDate
//	 * @param endDate
//	 * @param productID
//	 * @return
//	 */
//	public Map<String,Object> calculateTotalProfitOffsetLots(String kpiCode,String beginDate, String endDate, String productId);
//
//	/**
//	 * 报告调用
//	 * 
//	 * @param kpiCode
//	 * @param type
//	 * @param beginDate
//	 * @param endDate
//	 * @param productId
//	 * @return
//	 */
//	public  Map<String,Object> calculateWinRatio(String kpiCode,String beginDate,String endDate, String productId);
	
}
