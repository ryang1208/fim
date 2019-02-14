package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.request.FundSearchSimulationRequest;
import com.huaxin.fim.entity.response.FundSearchSimulationResponse;
import com.huaxin.fim.entity.response.SimulationProductResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundSearchSimulationMapper {

	/**
	 * 模拟组合产品条件查询
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @param productList
	 * @return
	 */
	public List<FundSearchSimulationResponse> getFundSimulationList(
            @Param("request") FundSearchSimulationRequest request,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay,
            @Param("productList") Long[] productList);

	/**
	 * 获取指定指标最新值
	 * @param productId
	 * @return
	 */
	public List<SimulationProductResponse> getLastKpiInfo(@Param("productId") String productId);

	/**
	 * 获取收益率图表数据
	 * @param productId
	 * @return
	 */
	public List<SimulationProductResponse> getYieldList(@Param("productId") String productId, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	/**
	 * 获取收益率图表数据
	 * @param productId
	 * @return
	 */
	public List<SimulationProductResponse> getNetValueList(@Param("productId") String productId, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	/**
	 * 获取回撤图表数据
	 * @param productId
	 * @return
	 */
	public List<SimulationProductResponse> getDrawndownList(@Param("productId") String productId, @Param("beginDate") String beginDate, @Param("endDate") String endDate);
}
