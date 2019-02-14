package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.StyleAnalysisRequest;
import com.huaxin.fim.entity.response.CategoryResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 债券风格分析图表查询
 * @author sust
 *
 */
public interface BondStyleAnalysisStatisticsMapper {

	/**
	 * 久期变化类型图
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<CategoryResponse> getBondDurationList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);

	/**
	 * 凸性变化类型图
	 * @param styleAnalysisRequest
	 * @return
	 */
	public List<CategoryResponse> getBondConvexityList(
            @Param("styleAnalysisRequest") StyleAnalysisRequest styleAnalysisRequest);
}
