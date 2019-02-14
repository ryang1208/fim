package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductNetValue;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.response.DurationResponse;
import com.huaxin.fim.entity.response.ParentBasicInfoResponse;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 母基金业绩分析数据处理接口
 * @author liumd
 *
 */
public interface SimulationCombinationMapper {

	/**
	 * 母子基金累计净值时序图
	 * @return
	 */
	public List<ParentBasicInfoResponse> getSelectedProductList(@Param("userId") String userId);

	/**
	 * 获取模拟组合产品存续期(最长)
	 * @param productIds
	 * @param beginDate
	 * @return
	 */
	public DurationResponse getMaxDurationList(@Param("productIds") List<String> productIds, @Param("beginDate") String beginDate);

	/**
	 * 获取模拟组合产品存续期(共有)
	 * @param productIds
	 * @param minDate
	 * @param maxDate
	 * @param totalNum
	 * @return
	 */
	public List<DurationResponse> getCommonDurationList(@Param("productIds") List<String> productIds, @Param("minDate") String minDate,
                                                        @Param("maxDate") String maxDate,
                                                        @Param("totalNum") int totalNum);

	/**
	 * 获取交易日总数
	 * @param productIds
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public String getTradeDays(@Param("productIds") List<String> productIds, @Param("minDate") String minDate,
                               @Param("maxDate") String maxDate);

	/**
	 * 获取组合构建产品存续期区间净值数据
	 * @param productIds
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<ProductNetValue> getMemberFundNetValue(@Param("productIds") List<String> productIds, @Param("beginDate") String beginDate,
													   @Param("endDate") String endDate);

	/**
	 * 获取产品公共存续期的净值数据
	 * @param productId
	 * @return
	 */
	public List<Double> getCommonProductValueList(@Param("productId") String productId, @Param("durationResponseList") List<DurationResponse> durationResponseList);

	/**
	 * 获取产品标准差
	 * @param productId
	 * @return
	 */
	public BigDecimal getDratioStandardDeviatio(@Param("productId") String productId);

	/**
	 * 删除当前登录用户选中的产品
	 * @param userId
	 */
	public void delSelectedProductByUser(@Param("userId") String userId);

	/**
	 * 获取产品列表
	 * @return
	 */
	public List<iWinProduct> getProductNameListForBL(@Param("userId") String userId);
	
}
