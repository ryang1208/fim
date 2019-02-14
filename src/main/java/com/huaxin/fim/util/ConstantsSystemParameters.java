
package com.huaxin.fim.util;
/**
 *  投赢汇IWIN系统系统参数名定义(与数据库一致)
 *  参见系统参数表  t_custom_parameter
 *  
 * @author Jiabing
 *
 */
public class ConstantsSystemParameters {

	/*  所有系统参数排列请按字母顺序排列整齐  */
	
	/**
	 * 从外部系统取数据向前回补数据的最大天数 DataFectchingBackwardMaxDays
	 */
	public static final String DATA_FECTCHING_BACKWARD_MAX_DAYS = "DataFectchingBackwardMaxDays";
	
	/*
	 * 查询获得调用Qdam获取ctp结算单的日期
	 */
	public static final String GET_QDAM_CTP_SETTLEMENT_DAY = "getQdamCtpSettlementDay";
	
	/**
	 * 是否启用KPI批处理计算 IWinKPICalculation
	 */
	public static final String IWIN_KPI_CALCULATION = "IWinKPICalculation";
	/**
	 * KPI批处理计算JOB运行时间配置参数 IWinKPICalculationSchedule
	 */
	public static final String IWIN_KPI_CALCULATION_SCHEDULE = "IWinKPICalculationSchedule";
	
	/**
	 * 是否启用从鑫管家托管系统导入数据 ImportJobFromXin
	 */
	public static final String IMPORT_JOB_FROM_XIN = "ImportJobFromXin";
	
	/**
	 * 鑫管家托管系统导入JOB运行时间配置参数 ImportJobFromXinSchedule
	 */
	public static final String IMPORT_JOB_FROM_XIN_SCHEDULE = "ImportJobFromXinSchedule";
	
	/**
	 * 是否启用从QDAM 通过JAVA API导入数据 ImportJobFromQDAMJavaApi
	 */
	public static final String IMPORT_JOB_FROM_QDAM_JAVA_API = "ImportJobFromQDAMJavaApi";
	
	/**
	 * QDAM 通过JAVA API导入数据运行时间配置参数 ImportJobFromQDAMJavaApiSchedule
	 */
	public static final String IMPORT_JOB_FROM_QDAM_JAVA_API_SCHEDULE = "ImportJobFromQDAMJavaApiSchedule";

	/**
	 * 取T+0 QDIAM 结算数据日期
	 */
	public static final String GET_QDIAM_SETTLEMENTDAY_T0 = "GetQDIAMSettlementDayT0";
}
