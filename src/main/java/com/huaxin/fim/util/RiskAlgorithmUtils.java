package com.huaxin.fim.util;


import com.huaxin.fim.entity.entity.Index;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.enums.PeriodTypeEnum;
import com.huaxin.fim.entity.enums.dictionary.BSEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 风险指标算法
 */
public class RiskAlgorithmUtils {
	
	/**
	 * 计算偏度
	 */
	public static final int CAL_SKEW = 3;
	/**
	 * 计算峰度
	 */
	public static final int CAL_KURTOSIS = 4;
	
	public static final long RISK_RETURN_RATIO_INFINITY = 99999999L;

	/**
	 * 计算贝塔值</br>
	 * beta = (T * sum[(ri - rf) * (rm - rf)] - sum(ri - rf) * sum(rm -rf)) / (T * sum[(rm - rf) ^ 2] - sum(rm -rf) ^ 2)
	 * @param productProfits	全部基金日收益序列
	 * @param indexProfits		全部基准日收益序列
	 * @param stdMode			样本类型 全样/抽样
	 * @param beforeType		提前N个月(DateUtils静态参数),-1表示不过滤计算直到统计日
	 * @param statDate			统计日
	 * @param Rf				无风险利率
	 * @return	贝塔结果
	 */
	@SuppressWarnings("unchecked")
	public static BigDecimal calBeta(List<ProductPeriodKPIStatistics> productProfits, List<Index> indexProfits,
									 int stdMode, int beforeType, String statDate, BigDecimal Rf) {
		
		List<BigDecimal> products = new ArrayList<>();
		List<BigDecimal> indexs = new ArrayList<>();
		
		// 过滤数据集
		List<ProductPeriodKPIStatistics> calProducts = (List<ProductPeriodKPIStatistics>) filterDatas(productProfits, beforeType, statDate);
		List<Index> calIndexs = (List<Index>) filterDatas(indexProfits, beforeType, statDate);
		
		
		// 基金和指数数据日期对齐
		for(ProductPeriodKPIStatistics p : calProducts){
			Index idx = calIndexs.stream().filter(i -> i.getDate().equals(p.getDate())).findFirst().orElse(null);
			if(idx != null){
				products.add(p.getToday());
				indexs.add(idx.getDailyYieldRate());
			}
		}
		
		try {
			
			if(products.size() > 0){
				
				double t = products.size();
				double rf = Rf.doubleValue();
				Double beta = null;
				double tmp1 = 0D;	// sum[(ri - rf) * (rm - rf)]
				double tmp2 = 0D;	// sum(ri - rf)
				double tmp3 = 0D;	// sum(rm -rf)
				double tmp4 = 0D;	// sum[(rm - rf) ^ 2]
				
				for(int i = 0;i < products.size();i++){
					double ri = products.get(i).doubleValue();
					double rm = indexs.get(i).doubleValue();
					tmp1 += (ri - rf) * (rm - rf);
					tmp2 += (ri - rf);
					tmp3 += (rm - rf);
					tmp4 += ((rm - rf) * (rm - rf));
				}
				
				beta = (t * tmp1 - tmp2 * tmp3) / (t * tmp4 - tmp3 * tmp3);
				
				if(beta != null && !beta.isInfinite() && !beta.isNaN()){
					return new BigDecimal(beta).setScale(8, BigDecimal.ROUND_HALF_UP);
				}
				
			}
			
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 计算年化特雷诺比率</br>
	 * TRi = (Ri - Rf) / BETAi
	 * @param ri	基金产品统计区间年化收益率
	 * @param rf	基金一年期无风险利率
	 * @param beta	基金产品统计区间beta值
	 * @return		年化特雷诺比率结果
	 */
	public static BigDecimal calTreynor(BigDecimal ri, BigDecimal rf, BigDecimal beta){
		
		if(ri != null && rf != null && beta != null && beta.doubleValue() != 0D){
			return ri.subtract(rf).divide(beta, 8, BigDecimal.ROUND_HALF_UP);
		}
		
		return null;
	}
	
	/**
	 * 计算年化跟踪误差</br>
	 * TEi = N^0.5 * STD(基金日收益 - 基准日收益)
	 * @param productProfits	全部基金日收益序列
	 * @param indexProfits		全部基准日收益序列
	 * @param stdMode			样本类型 全样/抽样
	 * @param beforeType		提前N个月(DateUtils静态参数),-1表示不过滤计算直到统计日
	 * @param statDate			统计日
	 * @param tradeDates		统计日当年交易日数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static BigDecimal calTrackingError(List<ProductPeriodKPIStatistics> productProfits, List<Index> indexProfits, 
			int stdMode, int beforeType, String statDate, BigDecimal tradeDates) {
		
		// 过滤数据集
		List<ProductPeriodKPIStatistics> calProducts = (List<ProductPeriodKPIStatistics>) filterDatas(productProfits, beforeType, statDate);
		List<Index> calIndexs = (List<Index>) filterDatas(indexProfits, beforeType, statDate);
		
		// 对应日日收益率相减
		if(calProducts != null && calProducts.size() > 0 && calIndexs != null && calIndexs.size() > 0){
			
			// （基金日收益率 - 基准日收益率）序列
			List<BigDecimal> calList = new ArrayList<>();
			
			calProducts.stream().forEach(p -> {
				Index idx = calIndexs.stream().filter(i -> i.getDate().equals(p.getDate())).findFirst().orElse(null);
				if(idx != null){
					if(p.getToday() != null && idx.getDailyYieldRate() != null){
						BigDecimal cal = p.getToday().subtract(idx.getDailyYieldRate());
						calList.add(cal);
					}
				}
			});
			
			try {
				if(calList != null &&calList.size()>0){
                    Double std = AlgorithmUtils.getStandardDevition(calList, stdMode);
                    Double result = Math.sqrt(tradeDates.doubleValue()) * std;
                    return new BigDecimal(result).setScale(8, BigDecimal.ROUND_HALF_UP);
                }else{
                    return null;
                }
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}
		
		return null;
	}
	
	/**
	 * 计算峰度、偏度</br>
	 * 峰度 = sum[基金收益率 - avg(基金收益率序列)] ^ 4 / [(基金收益率序列数量 - 1) * STD(基金收益率序列) ^ 4]</br>
	 * 偏度 = sum[基金收益率 - avg(基金收益率序列)] ^ 3 / [(基金收益率序列数量 - 1) * STD(基金收益率序列) ^ 3]
	 * @param productProfits	全部基金日收益序列
	 * @param stdMode			样本类型 全样/抽样
	 * @param beforeType		提前N个月(DateUtils静态参数),-1表示不过滤计算直到统计日
	 * @param statDate			统计日
	 * @param calType			计算类型(偏度/峰度)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static BigDecimal calKurtosisOrSkew(List<ProductPeriodKPIStatistics> productProfits, int stdMode, 
			int beforeType, String statDate, int calType) {
		
		// 过滤数据集
		List<ProductPeriodKPIStatistics> calProducts = (List<ProductPeriodKPIStatistics>) filterDatas(productProfits, beforeType, statDate);
		
		// 对应日日收益率相减
		if(calProducts != null && calProducts.size() > 0){
			
			List<Double> calList = calProducts.stream().map(c -> c.getToday().doubleValue()).collect(Collectors.toList());
			
			try {
				Double avg = AlgorithmUtils.avg(calList);
				Double std = AlgorithmUtils.getStandardDevition(calList, stdMode);
				
				if(std.doubleValue() != 0 && calProducts.size() > 1){	// 分母不为0
					
					// 计算分子
					double numerator = 0D;
					for(Double c : calList){
						numerator += Math.pow((c.doubleValue() - avg) , calType);
					}
					
					// 计算分母
					double denominator = 0D;
					denominator = (calList.size() - 1) * Math.pow(std, calType);
					
					return new BigDecimal(numerator / denominator).setScale(8, BigDecimal.ROUND_HALF_UP);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return null;
	}
	
	/**
	 * 计算指数年化收益率</br>
	 * 年化收益率 = [1 + avg(日收益率)] ^ 一年交易日数 - 1
	 * @param indexList		全部指数数据
	 * @param beforeType	提前N个月(DateUtils静态参数),-1表示不过滤计算直到统计日
	 * @param statDate		统计日
	 * @param tradeDates	统计日当年交易日数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static BigDecimal calIndexYearYieldRatio(List<Index> indexList, int beforeType, String statDate, BigDecimal tradeDates) {
		
		// 过滤数据集
		List<Index> calIndexs = (List<Index>) filterDatas(indexList, beforeType, statDate);
		
		if(calIndexs != null && calIndexs.size() > 0){
			try{
				List<Double> calList = calIndexs.stream().map(c -> c.getDailyYieldRate().doubleValue()).collect(Collectors.toList());
				Double avgLn = AlgorithmUtils.avg(calList);
				if(tradeDates != null){
					Double result = Math.pow(1 + avgLn, tradeDates.doubleValue()) - 1;
					return new BigDecimal(result).setScale(8, BigDecimal.ROUND_HALF_UP);
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		return null;
	}
	
	/**
	 * 计算年化信息比率
	 * IRi = (Ri - Rm) / TEi
	 * @param ri	统计区间基金年化收益率
	 * @param rm	统计区间指数年化收益率
	 * @param tei	年化跟踪误差
	 * @return
	 */
	public static BigDecimal calInfoRatio(BigDecimal ri, BigDecimal rm, BigDecimal tei){
		
		if(ri != null && rm != null && tei != null && tei.doubleValue() != 0){
			return ri.subtract(rm).divide(tei, 8, BigDecimal.ROUND_HALF_UP);
		}
		return null;
	}
	
	/**
	 * 计算年化索提诺比率
	 * sortinoRi = (Ri - Rf) / DDi
	 * @param ri	统计区间基金年化收益率
	 * @param rf	无风险利率
	 * @param dd	下行波动率
	 * @return
	 */
	public static BigDecimal calSortino(BigDecimal ri, BigDecimal rf, BigDecimal dd){
		
		if(ri != null && rf != null && dd != null && dd.doubleValue() != 0D){
			return ri.subtract(rf).divide(dd, 8, BigDecimal.ROUND_HALF_UP);
		}
		return null;
	}
	
	/**
	 * 计算风报比(收益回撤比)</br>
	 * 风报比 = 累计收益率 / 最大回撤
	 * @param yieldRatio	累计收益率
	 * @param maxDrawDown	最大回撤
	 * @return
	 */
	public static BigDecimal calRiskReturnRatio(BigDecimal yieldRatio, BigDecimal maxDrawDown){
		
		if(yieldRatio != null && maxDrawDown != null){
			if(maxDrawDown.doubleValue() != 0){
				return yieldRatio.divide(maxDrawDown, 8, BigDecimal.ROUND_HALF_UP);
			}else{
				return new BigDecimal(RISK_RETURN_RATIO_INFINITY);
			}
		}
		return null;
	}
	
	/**
	 * 计算日内,隔夜买/卖同品种套利保证金
	 * 
	 * @param ri 隔夜多单交易保证金	(日内多单开仓成交额)
	 * @param rf 隔夜空单交易保证金	(日内空单开仓成交额)
	 * @param di 持仓买向手数		(日内平仓买向手数)
	 * @param df 持仓卖向手数		(日内平仓卖向手数)
	 * @return
	 */
	public static BigDecimal calOverNightArbitrageMargin(BigDecimal ri, BigDecimal rf, BigDecimal di,BigDecimal df,String type){
		
		if (type.equals(String.valueOf(BSEnum.Buy.getIntValue()))) {
			if (ri !=null && rf != null) {
				// 买向手数小于卖向手数
				if (di.compareTo(df) == -1) {
				   return ri;
				}else{
				   return ri.divide(di, 8, BigDecimal.ROUND_HALF_UP).multiply(df).setScale(8, BigDecimal.ROUND_HALF_UP);
				}
			}else {
				return BigDecimal.ZERO;
			}
		}else{
			if (ri !=null && rf != null) {
				// 买向手数小于卖向手数
				if (di.compareTo(df) == -1) {
					return rf.divide(df, 8, BigDecimal.ROUND_HALF_UP).multiply(di).setScale(8, BigDecimal.ROUND_HALF_UP);
				}else {
					return rf;
				}
			}else {
				return BigDecimal.ZERO;
			}
		}
	}
	
	/**
	 * 计算跨品系(日内，隔夜)
	 * 
	 * @param ri 隔夜多单交易保证金			(日内多单开仓成交额)
	 * @param rf 隔夜空单交易保证金			(日内空单开仓成交额)
	 * @param di 隔夜买向同品种套利保证金		(日内买向同品种)
	 * @param df 隔夜卖向同品种套利保证金		(日内卖向同品种)
	 * @return
	 */
	public static BigDecimal calDaysClassifyArbitrageTurnOverByPeriod(BigDecimal ri, BigDecimal rf, BigDecimal di,BigDecimal df){
		// ri-di > rf-df
		if (ri.subtract(di).compareTo((rf.subtract(df))) == 1) {			
		    return rf.subtract(df);
		}else {
			return ri.subtract(di);
		}
	}
	
	/**
	 * 计算同品系(日内，隔夜)
	 * 
	 * @param ri 隔夜多单交易保证金			(日内多单开仓成交额)
	 * @param rf 隔夜空单交易保证金			(日内空单开仓成交额)
	 * @param di 隔夜买向同品种套利保证金		(日内买向同品种)
	 * @param df 隔夜卖向同品种套利保证金		(日内卖向同品种)
	 * @param rd 隔夜同品系套利保证金		(日内同品系套利成交额)
	 * @return
	 */
	public static BigDecimal calDaysHedgingTurnOverByPeriod(BigDecimal ri, BigDecimal rf, BigDecimal di,BigDecimal df,BigDecimal rd){
		// ri-(di+rd) > rf-(df+rd)
		if (ri.subtract((di.add(rd))).compareTo((rf.subtract((df.add(rd))))) == 1) {			
		    return rf.subtract((df.add(rd)));
		}else {
			return ri.subtract((di.add(rd)));
		}
	}
	
	/**
	 * 计算隔夜净持仓
	 * 
	 * @param ri 隔夜多单交易保证金	(日内多单开仓成交额)
	 * @param rf 隔夜空单交易保证金	(日内空单开仓成交额)
	 * @param di 持仓买向手数		(日内平仓买向手数)
	 * @param df 持仓卖向手数		(日内平仓卖向手数)
	 * @return
	 */
	public static BigDecimal calOverNightNetPositionByPeriod(BigDecimal ri, BigDecimal rf, BigDecimal di,BigDecimal df){
		
		if (ri !=null) {			
		    return ri.subtract((rf.add(di.multiply(new BigDecimal(2))).
		    		add(df.multiply(new BigDecimal(2)))));
		}else {
			return BigDecimal.ZERO;
		}
	}
	
	// ------------------------------ 通用方法 ------------------------------------
	
	/**
	 * 按beforeType切割数据</br>
	 * 支持ProductPeriodKPIStatistics、Index对象的list
	 * @param datas			源数据
	 * @param beforeType	提前N个月(PeriodTypeEnum.month),-1表示不过滤计算直到统计日
	 * @param statDate		统计日
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<?> filterDatas(List<?> datas, int beforeType, String statDate){
		
		if(datas == null || datas.size() == 0)
			return datas;
		
		if(beforeType == PeriodTypeEnum.UNTIL_NOW.getMonth()){		// untilNow
			List<?> seperateDatas = null;
			
			if(datas.get(0) instanceof ProductPeriodKPIStatistics){
				
				List<ProductPeriodKPIStatistics> productPeriodList = (List<ProductPeriodKPIStatistics>) datas;
				
				seperateDatas = productPeriodList.stream()
						.filter(p -> p.getDate().compareTo(statDate) <= 0)
						.collect(Collectors.toList());
			}else if(datas.get(0) instanceof Index){
				
				List<Index> indexs = (List<Index>) datas;
				
				seperateDatas = indexs.stream()
						.filter(p -> p.getDate().compareTo(statDate) <= 0)
						.collect(Collectors.toList());
			}
			
			return seperateDatas;
		}else{
			List<?> seperateDatas = null;
			String startDate = DateUtils.getDateBefore(DATE.addDate(statDate, 0, 0, 1), beforeType);
			
			if(datas.get(0) instanceof ProductPeriodKPIStatistics){
				
				List<ProductPeriodKPIStatistics> productPeriodList = (List<ProductPeriodKPIStatistics>) datas;
				
				seperateDatas = productPeriodList.stream()
						.filter(p -> p.getDate().compareTo(startDate) >= 0 && p.getDate().compareTo(statDate) <= 0)
						.collect(Collectors.toList());
			}else if(datas.get(0) instanceof Index){
				
				List<Index> indexs = (List<Index>) datas;
				
				seperateDatas = indexs.stream()
						.filter(p -> p.getDate().compareTo(startDate) >= 0 && p.getDate().compareTo(statDate) <= 0)
						.collect(Collectors.toList());
			}
			
			return seperateDatas;
		}
		
	}
	
}
