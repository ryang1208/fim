package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.ProductsRelationship;
import com.huaxin.fim.entity.entity.UserSelectedProduct;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.FundSearchRequest;
import com.huaxin.fim.entity.response.FundSearchResponse;
import com.huaxin.fim.entity.response.ProductMarketTypeResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundSearchMapper {

	public List<FundSearchResponse> getFundList(
            @Param("fundSearch") FundSearchRequest fundSearch,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay,
            @Param("productList") List<String> productList);


	/**
	 * 获取产品最新指标数据
	 * @return
	 */
	public FundSearchResponse getProductLastKpiInfo(@Param("fundSearch") FundSearchRequest fundSearch);

	/**
	 * 根据登录人代码获取当前登录用户选中的产品
	 * @param userId
	 * @return
	 */
	public List<UserSelectedProduct> getSelectedProductList(@Param("userId") String userId);

	/**
	 * 获取子产品列表
	 * @param parentProductId
	 * @return
	 */
	public List<ProductsRelationship> getChildProducts(@Param("parentProductId") String parentProductId);

	/**
	 * 获取产品市场类型列表
	 * @return
	 */
	public ProductMarketTypeResponse getProductMarketType(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);
	
}
