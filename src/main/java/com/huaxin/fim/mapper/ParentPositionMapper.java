package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.ParentAnalysisRequest;
import com.huaxin.fim.entity.response.ParentPositionAnalysisResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 母基金业绩分析数据处理接口
 * @author wucq
 *
 */
public interface ParentPositionMapper {

	/**
	 * 子基金总资产
	 * @return
	 */
	public List<ParentPositionAnalysisResponse> getTotalAssetValue(@Param("request") ParentAnalysisRequest request);
	
	/**
	 * 子基金资产分布指标
	 * @return
	 */
	public List<ProductPeriodKPIStatistics> getAssetMarketValue(@Param("request") ParentAnalysisRequest request);
	
}
