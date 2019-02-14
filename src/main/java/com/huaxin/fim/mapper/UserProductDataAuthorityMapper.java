package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.request.User2ProductRequest;
import com.huaxin.fim.entity.response.User2ProductResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 基金评价配置数据库交互业务处理接口
 * @author liumd
 *
 */
public interface UserProductDataAuthorityMapper {

	/**
	 * 获取基金评价配置查询结果列表（类别为产品
	 * @param request
	 * @return
	 */
	public List<User2ProductResponse> getUserProductByConditionForProduct(@Param("request") User2ProductRequest request);
	/**
	 * 获取基金评价配置查询结果列表（类别为机构）
	 * @param request
	 * @return
	 */
	public List<User2ProductResponse> getUserProductByConditionForOrganization(@Param("request") User2ProductRequest request);
	/**
	 * 获取基金评价配置查询结果列表（类别为机构）
	 * @param request
	 * @return
	 */
	public List<User2ProductResponse> getUserProductByConditionForInvestment(@Param("request") User2ProductRequest request);
	/**
	 * 获取基金评价配置查询结果列表（类别为用户）
	 * @param request
	 * @return
	 */
	public List<User2ProductResponse> getUserProductByConditionForUser(@Param("request") User2ProductRequest request);
}
