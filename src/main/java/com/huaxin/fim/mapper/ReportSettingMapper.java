package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.FundEvaluationReportParameter;
import com.huaxin.fim.entity.request.ReportSettingRequest;
import com.huaxin.fim.entity.response.ReportSettingResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 基金评价配置数据库交互业务处理接口
 * @author liumd
 *
 */
public interface ReportSettingMapper {

	/**
	 * 获取基金评价配置查询结果列表
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public List<ReportSettingResponse> getReportSettingList(@Param("request") ReportSettingRequest request, FrameworkPageable frameworkPageable,
															@Param("orderType") Integer orderType,
															@Param("orderWay") Integer orderWay, @Param("idList") List<String> idList);
	
	/**
	 * 获取指定reportId指标配置信息列表
	 * @return
	 */
	public List<FundEvaluationReportParameter> getKpiListByReportId(@Param("reportId") String reportId);
}
