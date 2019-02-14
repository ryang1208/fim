package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductContactTradeDailyStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.request.AnalysisProductPeriod;
import com.huaxin.fim.entity.request.AnalysisSearchRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计算指标产品每日统计处理数据层接口
 * 
 * @author sust
 *
 */
public interface ProductContactTradeDailyStatisticsMapper {

	/**
	 * 计算日内交易平仓手数比/开仓成交额/平仓成交额/总成交额/当日净持仓（产品每日合约统计表）
	 * 
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<ProductContactTradeDailyStatistics> findProductContactCloseList(
            @Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 计算日内平仓成交额比例（产品每日合约统计表）
	 *
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<ProductContactTradeDailyStatistics> findProductContactLevel3List(
            @Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 计算当日持仓持续天数（产品每日合约统计表）
	 *
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<ProductContactTradeDailyStatistics> findPositionLastDaysList(
            @Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 计算买/卖持仓持续天数/手数（产品每日合约统计表）
	 *
	 * @param analysisProductPeriod
	 * @return
	 */
	public List<ProductContactTradeDailyStatistics> findProductContactLevel5List(
            @Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 删除历史记录（产品每日合约统计表）
	 *
	 * @param analysisProductPeriod
	 * @return
	 */
	public int deleteProductContactTradeDaily(
            @Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);
	
	/**
	 * 根据开始、结束日期来获取所有产品合约持仓信息
	 */
	public List<ProductContactTradeDailyStatistics> findInsPositionValue(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);

	/**
	 * 根据产品id号(null为全部)、开始、结束日期来获取产品总资产
	 */
	public List<ProductPeriodKPIStatistics> findProductAssetByDateAndProductID(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);
	
	/**
	 * 根据产品id号(null为全部)、开始、结束日期来获取产品持仓市值
	 */
	public List<ProductContactTradeDailyStatistics> findPositionValueByDateAndProductID(@Param("analysisProductPeriod") AnalysisProductPeriod analysisProductPeriod);
	
	/**
	 * 根据页面查询条件(产品id,指定日期)查询持仓占比
	 */
	public List<ProductContactTradeDailyStatistics> findFuturePositionRatioByCondition(@Param("request") AnalysisSearchRequest request);
	
	/**
	 * 根据页面产品id查询其最近的有持仓占比数据的日期 
	 */
	public String findNearestPositionRatioDay(@Param("request") AnalysisSearchRequest request);
}
