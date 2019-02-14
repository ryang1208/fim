package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.response.DurationResponse;
import org.apache.ibatis.annotations.Param;

import javax.inject.Named;
import java.util.List;

/**
 * MVO模型计算数据库交互接口
 * @author liumd
 *
 */
@Named(value="mvoAlgorithmMapper")
public interface MVOAlgorithmMapper {
	
	/**
	 * 获取产品共有日期(共有)
	 * @param productIds
	 * @param minDate
	 * @param maxDate
	 * @param totalNum
	 * @return
	 */
	public List<DurationResponse> getYieldDateList(@Param("productIds") List<String> productIds, @Param("minDate") String minDate,
												   @Param("maxDate") String maxDate,
												   @Param("totalNum") int totalNum);

	/**
	 * 获取多产品收益率序列
	 * @param productIds
	 * @return
	 */
	List<ProductPeriodKPIStatistics> getYeildRateList(@Param("productIds") List<String> productIds, @Param("dates") List<DurationResponse> dates);
	
}
