package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.UserInvestmentDataAuthority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInvestmentDataAuthorityMapper {

	
	/**
	 * 获取用户投顾查询结果列表（类别为机构）
	 * @param request
	 * @return
	 */
	public List<UserInvestmentDataAuthority> getUserInvestmentByConditionForOrganization(@Param("request") UserInvestmentDataAuthority request);
	/**
	 * 获取用户投顾查询结果列表（类别为机构）
	 * @param request
	 * @return
	 */
	public List<UserInvestmentDataAuthority> getUserInvestmentByConditionForInvestment(@Param("request") UserInvestmentDataAuthority request);
	/**
	 * 获取用户投顾查询结果列表（类别为用户）
	 * @param request
	 * @return
	 */
	public List<UserInvestmentDataAuthority> getUserInvestmentByConditionForUser(@Param("request") UserInvestmentDataAuthority request);
}
