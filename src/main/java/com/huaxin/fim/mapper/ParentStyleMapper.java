package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.ParentAnalysisRequest;
import com.huaxin.fim.entity.response.ParentStyleAnalysisResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 母基金风格分析数据处理接口
 * @author wucq
 *
 */
public interface ParentStyleMapper {

	
	/**
	 * 子基金胜率
	 * @return
	 */
	public ParentStyleAnalysisResponse getWinRatioValue(@Param("productId") String productId, @Param("periodType") String periodType);
	/**
	 * 子基金日平均收益率
	 * @return
	 */
	public List<ParentStyleAnalysisResponse> getAvergeYield(@Param("request") ParentAnalysisRequest request);
	
	/**
	 * 子基金T-M 模型值
	 * @return
	 */
	public List<ParentStyleAnalysisResponse> getTMModelValue(@Param("request") ParentAnalysisRequest request);
	
}
