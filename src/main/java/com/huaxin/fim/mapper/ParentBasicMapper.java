package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductIndexPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.ProductNetValue;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.response.ParentBasicInfoResponse;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 母基金业绩分析数据处理接口
 * @author liumd
 *
 */
public interface ParentBasicMapper {

	/**
	 * 母子基金累计净值时序图
	 * @param productIds
	 * @return
	 */
	public List<ProductNetValue> getNetAccumulativeValue(@Param("productIds") String[] productIds, @Param("beginDate") String beginDate,
														 @Param("endDate") String endDate);

	/**
	 * 获取产品净值日期区间
	 * @param productIds
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<String> getDateList(@Param("productIds") String[] productIds, @Param("beginDate") String beginDate,
                                    @Param("endDate") String endDate);

	public List<iWinProduct> getProductList(@Param("parentProductId") String parentProductId);

	/**
	 * 获取指定基金信息
	 * @param productIds
	 * @return
	 */
	public List<iWinProduct> getProductListByIds(@Param("productIds") List<String> productIds);

	/**
	 * 母子基金基本信息
	 * @param productIds
	 * @param parentInitialAsset
	 * @return
	 */
	public List<ParentBasicInfoResponse> getBasicInfo(@Param("productIds") String[] productIds, @Param("parentInitialAsset") BigDecimal parentInitialAsset);

	/**
	 * 获取日期区间
	 * @param productIds
	 * @param beginDate
	 * @param endDate
	 * @param indexID
	 * @return
	 */
	public List<String> getAlphaBetaDateList(@Param("productIds") String[] productIds, @Param("beginDate") String beginDate,
                                             @Param("endDate") String endDate, @Param("kpiCode") String kpiCode, @Param("indexID") String indexID, @Param("periodType") String periodType);

	/**
	 * 母子基金alphaBeta值
	 * @param productIds
	 * @return
	 */
	public List<ProductIndexPeriodKPIStatistics> getAlphaBetaValue(@Param("productIds") String[] productIds, @Param("beginDate") String beginDate,
																   @Param("endDate") String endDate, @Param("kpiCode") String kpiCode, @Param("indexID") String indexID, @Param("periodType") String periodType);
}
