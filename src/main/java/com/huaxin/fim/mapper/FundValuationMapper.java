package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.FundValuation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 估值表查询
 * 
 * @author liumd
 *
 */
public interface FundValuationMapper {

	/**
	 * 从原始估值表获取估值数据
	 * @param level
	 * @param accountCodelength
	 * @param productId
	 * @param dataSource
	 * @param date
	 * @return
	 */
	public List<FundValuation> getFundValuationList(@Param("accountCodeLevel") int level,
													@Param("accountCodelength") int accountCodelength,
													@Param("productId") String productId,
													@Param("dataSource") int dataSource,
													@Param("date") String date);

	/**
	 * 从源数据表获取估值数据（t_raw_fund_valuation）
	 * @param level
	 * @param accountCodelength
	 * @param productId
	 * @param dataSource
	 * @param date
	 * @return
	 */
	public List<FundValuation> getRawFundList(@Param("accountCodeLevel") int level,
                                              @Param("accountCodelength") int accountCodelength,
                                              @Param("productId") String productId,
                                              @Param("dataSource") int dataSource,
                                              @Param("date") String date);


}
