package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.ParentAnalysisRequest;
import com.huaxin.fim.entity.response.ParentAnalysisResponse;
import com.huaxin.fim.entity.response.ParentRiskAnalysisResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 母基金业绩分析数据处理接口
 * 
 * @author liumd
 *
 */
public interface ParentRiskMapper {

	/**
	 * 母子基金累计净值时序图
	 * 
	 * @return
	 */
	public List<ParentAnalysisResponse> getDrawDownList(@Param("request") ParentAnalysisRequest request);

	/**
	 * 获取产品净值日期区间
	 * 
	 * @return
	 */
	public List<String> getDateList(@Param("request") ParentAnalysisRequest request);

	/**
	 * 获取图表数据集（sharp，sortino，calmar）
	 * 
	 * @param request
	 * @return
	 */
	public List<ParentRiskAnalysisResponse> getDataList(@Param("request") ParentAnalysisRequest request);
	
	/**
	 * 风险价值图表数据集
	 * @param request
	 * @return
	 */
	public List<ParentRiskAnalysisResponse> getRiskValueList(@Param("request") ParentAnalysisRequest request);
	
	/**
	 * 获取索提诺及卡玛图表数据
	 * @param request
	 * @return
	 */
	public List<ParentRiskAnalysisResponse> getDataListForSortinoAndCalmar(@Param("request") ParentAnalysisRequest request);

}
