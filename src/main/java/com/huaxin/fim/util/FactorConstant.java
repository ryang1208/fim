package com.huaxin.fim.util;

/**
 * 因子指标定义
 * @author shenwei
 *
 */
public class FactorConstant {
	
	/**
	 * 一级指标
	 */
	public static final String SIZE = "010000";				// 市值
	public static final String RESIDUAL_VOLATILITY_HS300 = "010001";	// 波动率-沪深300
	public static final String GROWTH = "010002";			// 成长性
	public static final String NONLINEARSIZE = "010003"; 	// 非线性市值
	public static final String BOOKTOPRICE = "010004";		// 价值
	public static final String LIQUIDITY = "010005";		// 流动性
	public static final String LEVERAGE = "010006";			// 杠杆率
	public static final String INDUSTRY = "010007";			// 行业因子
	public static final String BETA_HS300 = "010008";		// 大盘-沪深300
	public static final String MOMENTUM_HS300 = "010009";	// 动量-沪深300
	public static final String EARNINGS_YIELD = "010010";	// 盈利能力
	
	/**
	 * 二级指标
	 */
	public static final String EXCESS_YIELD_RATIO_HS300 = "020000";			// 超额收益率-沪深300
	public static final String YIELD_RATIO_STANDARD_DEVIATION = "020001";	// 收益率标准差
	
	
	/**
	 * 计算类型
	 */
	public static final String DIRECT_CAL = "1";			// 直接计算
	public static final String SEPERATE_CAL = "2";			// 拆分计算
	
	/**
	 * 排序类型
	 */
	public static final String OTHER = "0";			// 不排序
	public static final String ASC = "1";			// 从小到大
	public static final String DESC = "2";			// 从大到小
	
}
