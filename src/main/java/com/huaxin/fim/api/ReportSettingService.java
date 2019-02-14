package com.huaxin.fim.api;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.FileGateway;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.FundEvaluationReportParameter;
import com.huaxin.fim.entity.entity.Organization;
import com.huaxin.fim.entity.entity.ReportKPIGrade;
import com.huaxin.fim.entity.request.ReportSettingRequest;
import com.huaxin.fim.entity.response.ReportSettingResponse;

/**
 * 基金评价配置业务处理接口
 * @author liumd
 *
 */
@FileGateway
public interface ReportSettingService {
	
	/**
	 * 获取基金基金配置查询数据列表
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public FrameworkPage<ReportSettingResponse> getReportSettingList(ReportSettingRequest request, FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);

	/**
	 * 获取指定reportId下所有指标列表
	 * @param reportId
	 * @return
	 */
	public Map<String,Object> getKpiListByReportId(String reportId);

	/**
	 * 更新或保存报表指标配置信息
	 * @param reportParam
	 * @param saveOrUpdate
	 * @return
	 */
	public Map<String,Object> saveOrUpdateKpi(FundEvaluationReportParameter reportParam, String saveOrUpdate);

	/**
	 * 删除指标配置信息
	 * @param reportParam
	 * @return
	 */
	public Map<String,Object> delKpi(FundEvaluationReportParameter reportParam);

	/**
	 * 根据条件获取指定报表指标的分数配置
	 * @param request
	 * @return
	 */
	public Map<String,Object> getScoreList(ReportSettingRequest request);

	/**
	 * 保存指标分数配置信息
	 * @return
	 */
	public Map<String,Object> saveOrUpdateGrade(ReportKPIGrade gradeParam);

	/**
	 * 删除指标分数配置
	 * @param gradeParam
	 * @return
	 */
	public Map<String,Object> delScore(ReportKPIGrade gradeParam);

	/**
	 * 获取报表名称下拉列表数据
	 * @return
	 */
	public List<ReportSettingResponse> getReportList();

	/**
	 * 根据报表ID删除报表
	 * @param reportId
	 * @param step(1：查询页面删除，2：指标配置最后一条数据处理)
	 * @return
	 */
	public Map<String,Object> delReport(String reportId, String step);

	/**
	 * 保存指标配置集合
	 * @param parameters
	 * @return
	 */
	public Map<String,Object> saveKpiList(List<FundEvaluationReportParameter> parameters);

	/**
	 * 获取用户机构
	 * @return
	 */
	public List<Organization> getAllOrganization();

	/**
	 * 下载配置文件模板
	 * @return
	 */
	public File downLoadSettingModelFile();

	/**
	 * 上传配置文件
	 * @param reportId
	 * @return
	 */
	public Map<String,Object> uploadSettingFile(String reportId, String fileType, InputStream in);

}
