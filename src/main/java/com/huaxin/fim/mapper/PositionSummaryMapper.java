package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.PositionDetails;
import com.huaxin.fim.entity.entity.PositionSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

;

/**
 * 
 * 
 * @author wangdl
 *
 */
public interface PositionSummaryMapper {

	
	public List<PositionSummary> getPositionSummaryByPositionDetails(@Param("positionDetails") PositionDetails positionDetails);

	public List<PositionSummary> getPositionSummaryOfBuyOriMargin(@Param("productIdList") List<String> productIdList,
                                                                  @Param("updateDate") String updateDate);

	/**
	 * 根据产品ID及更新日期获取持仓汇总
	 * @param productIdList
	 * @param updateDate
	 * @return
	 */
	public List<PositionSummary> getPositionSummaryByProductIdAndUpdate(@Param("productIdList") List<String> productIdList,
                                                                        @Param("updateDate") String updateDate);

	public void deletePositionSummaryByProductIdAndUpdate(@Param("productIdList") List<String> productIdList,
                                                          @Param("updateDate") String updateDate);

	/**
	 * 更新持仓汇总的还原保证金
	 * @param productIdList
	 * @param updateDate
	 */
	public void updatePositionSummaryOriMargin(@Param("productIdList") List<String> productIdList,
                                               @Param("updateDate") String updateDate);

	/**
	 * 更新持仓汇总的持仓盈亏
	 * @param productIdList
	 * @param updateDate
	 */
	public void updatePositionProfitMarket(@Param("productIdList") List<String> productIdList,
                                           @Param("updateDate") String updateDate);

	/**
	 * 获取估值表中持仓汇总数据集
	 * @param investerId
	 * @param brokerId
	 * @param productId
	 * @param date
	 * @param marketType
	 * @param accountCodes
	 * @param trusteeId
	 * @return
	 */
	public List<PositionSummary> getPositionSummaryFromValuation(@Param("investerId") String investerId,
                                                                 @Param("brokerId") String brokerId, @Param("productId") String productId, @Param("date") String date,
                                                                 @Param("marketType") String marketType,
                                                                 @Param("accountCodes") List<String> accountCodes, @Param("trusteeId") String trusteeId);

	/**
	 * 计算股息率指标
	 * @param productId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<PositionSummary> calculateDividendRatio(@Param("productId") String productId, @Param("beginDate") String beginDate,
                                                        @Param("endDate") String endDate);

	/**
	 * 获取估值表中持仓汇总数据集(期货)
	 * @param investerId
	 * @param brokerId
	 * @param productId
	 * @param date
	 * @param marketType
	 * @param trusteeId
	 * @return
	 */
	public List<PositionSummary> getFuturePositionSummaryFromValuation(@Param("investerId") String investerId,
                                                                       @Param("brokerId") String brokerId, @Param("productId") String productId, @Param("date") String date,
                                                                       @Param("marketType") String marketType, @Param("trusteeId") String trusteeId);

	/**
	 * 获取估值表中持仓汇总数据集(证券)
	 * @param investerId
	 * @param brokerId
	 * @param productId
	 * @param date
	 * @param marketType
	 * @param trusteeId
	 * @return
	 */
	public List<PositionSummary> getSecurityPositionSummaryFromValuation(@Param("investerId") String investerId,
                                                                         @Param("brokerId") String brokerId, @Param("productId") String productId, @Param("date") String date,
                                                                         @Param("marketType") String marketType, @Param("trusteeId") String trusteeId);

	/**
	 * 获取估值表中持仓汇总数据集(债券)
	 * @param investerId
	 * @param brokerId
	 * @param productId
	 * @param date
	 * @param marketType
	 * @param trusteeId
	 * @return
	 */
	public List<PositionSummary> getBondPositionSummaryFromValuation(@Param("investerId") String investerId,
                                                                     @Param("brokerId") String brokerId, @Param("productId") String productId, @Param("date") String date,
                                                                     @Param("marketType") String marketType, @Param("trusteeId") String trusteeId);
	
}
