package com.huaxin.fim.api.fundscreening;

import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.request.FundSearchRequest;
import com.huaxin.fim.entity.response.FundSearchResponse;

/**
 * 基金信息查询处理接口
 * 
 * @author liumd
 *
 */
@Gateway
public interface FundSearchService {

	/**
	 * 获取查询条件的数据字典
	 * 
	 * @param types
	 * @return
	 */
	public Map<String, Object> getParamMap(String[] types);

	/**
	 * 基金信息后台分页查询
	 * 
	 * @param fundRequest
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public FrameworkPage<FundSearchResponse> getFundList(FundSearchRequest fundRequest,
														 FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);


	public void add(String productID);


	public void deleteAttentedProduct(String productID);

	/**
	 * 获取产品最新指标数据
	 * @param productId
	 * @return
	 */
	public Map<String,Object> getProductLastKpiInfo(String productId);

	/**
	 * 保存选中的产品（对比及模拟构建使用）
	 * @param productId
	 * @return
	 */
	public Map<String,Object> saveSelectedProduct(String productId);

	/**
	 * 获取当前登录用户选中产品列表
	 * @return
	 */
	public Map<String,Object> getSelectedProductList();


	/**
	 * 删除选中的产品（对比及模拟构建使用）
	 * @param id
	 * @param productId
	 * @return
	 */
	public Map<String,Object> delSelectedProduct(String id, String productId);
	
	/**
	 * 取得产品当前状态(是否正在计算净值)
	 * @param productId
	 * @return
	 */
	public Map<String,Object> getProductInfo(String productId);
}
