package com.huaxin.fim.mapper;


import com.huaxin.fim.entity.entity.Index;
import com.huaxin.fim.entity.request.FundSearchRequest;
import com.huaxin.fim.entity.request.IndexParameterRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * brinson相关指标计算
 * 
 * @author liumd
 *
 */
public interface IndexMapper {


	/**
	 * 计算产品基准指数数据
	 */
	public List<Index> calculateFFIndex(@Param("indexParam") IndexParameterRequest indexParam);
	
	/**
	 * 计算产品策略基准指数数据
	 */
	public List<Index> calculateFFStrategyIndex(@Param("indexParam") IndexParameterRequest indexParam);
	
	/**
	 * 根据基准ID获取其最大日期
	 * @param indexId
	 * @return
	 */
	public String getMaxDateByIndexId(@Param("indexId") String indexId);
	/**
	 * 根据基准ID获取其最小日期
	 * @return
	 */
	public String getMinDateByIsParent(@Param("fundSearchRequest") FundSearchRequest fundSearchRequest);
	
	/**
	 * 删除指定区间的基准指数
	 * @param indexParam
	 */
	public void deleteIndexByPeriodAndIndexId(@Param("indexParam") IndexParameterRequest indexParam);

}

