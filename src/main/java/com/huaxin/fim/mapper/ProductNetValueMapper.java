package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.InvesterFund;
import com.huaxin.fim.entity.entity.ProductNetValue;
import com.huaxin.fim.entity.request.KPICalculationRequest;
import com.huaxin.fim.entity.response.ProductsNetValueResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 计算产品净值数据数据层处理接口
 * 
 * @author liumd
 *
 */
public interface ProductNetValueMapper {

	/**
	 * 计算产品单位净值（大赛算法）
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductNetValue> calculateProductNetValueForCompetition(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);
	
	/**
	 * 获取需要更新单位净值的产品列表
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductNetValue> getProductList(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 获取产品最新条的累计净值
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public ProductNetValue getLastNetAccumuValue(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 获取需要更新累计净值的数据列表
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public List<ProductNetValue> getCalculateNetAccumuValueList(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 删除历史记录
	 * 
	 * @param profitAndLossCalculationRequest
	 * @return
	 */
	public int deleteProductNetValue(@Param("kpiCalculationRequest") KPICalculationRequest profitAndLossCalculationRequest);

	/**
	 * 
	 * 描述: 查询基金产品历史净值
	 *
	 * 创建时间 2017年4月13日 下午1:23:59
	 */
	public List<ProductNetValue> getProductNetValueByProductId(@Param("productId") Long productId, @Param("pageSize") Integer pageSize);
	
	/**
	 * 获取非计算净值的最小日期
	 * @return
	 */
	public String getNetValueMinDate();
	
	/**
	 * 获取资金表最小日期
	 * @return
	 */
	public String getInvesterFundMinDate();
	
	/**
	 * 获取产品的最大净值日期
	 * @return
	 */
	public String getNetValueMaxDateByProductId(@Param("productId") String productId);
	
	/**
	 * 获取产品结算单的最小日期
	 * @return
	 */
	public String getInvesterFundMinDateByProductId(@Param("productId") String productId);

	/**
	 * 获取产品结算单的最小日期
	 * @return
	 */
	public String getInvesterFundMaxDateByProductId(@Param("productId") String productId, @Param("date") String date);

	/**
	 * 获取产品净值的最大日期
	 */
	public String getMaxDateFromNetValue(@Param("productId") String productId);

	/**
	 * 获取产品结算单最大日期
	 * @param productId
	 * @return
	 */
	public String getMaxDateFromFundInvester(@Param("productId") String productId);

	/**
	 * 获取产品资金数据集（计算净值使用）
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<InvesterFund> getInvesterFundListForNetValue(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 获取产品出入金数据集（计算净值使用）
	 * @param kpiCalculationRequest
	 * @return
	 */
	public List<InvesterDepositWithdrawal> getInOutMoneyListForNetValue(@Param("kpiCalculationRequest") KPICalculationRequest kpiCalculationRequest);

	/**
	 * 获取净值表里的最小日期
	 * @return
	 */
	public String getNetValueMinDateByProductId(@Param("productId") String productId);

	/**
	 * 获取母基金下子基金净值列表
	 * @return
	 */
	public List<ProductsNetValueResponse> getProductsNetValueList(@Param("productId") String productId, @Param("date") String date);

	/**
	 * 获取母基金下子基金净值列表
	 * @return
	 */
	public List<ProductsNetValueResponse> getProductsNetValueListByDate(@Param("productId") String productId, @Param("date") String date);

}
