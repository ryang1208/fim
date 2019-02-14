package com.huaxin.fim.api.permissions;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;

/**
 * 数据权限业务处理接口
 * @author liumd
 *
 */
@Gateway
public interface UserDataAuthorityService {

	/**
	 * 根据登录用户获取用户有查询权限的所有产品
	 * @param userId
	 * @return
	 */
	public List<String> getUser2ProductSelectAuthorityData();
	
	/**
	 * 获取登录用户有查询权限的所有投顾
	 * @param userId
	 * @return
	 */
	public List<String> getUser2InvestmentSelectAuthorityData();
	
	
	/**
	 * 获取登录用户所能查看的机构
	 * @param userId
	 * @return
	 */
	public List<String> getOrganizatinIdList();
	
	/**
	 * 获取登录用户所能查看的用户
	 * @param userId
	 * @return
	 */
	public List<String> getUserIdList();
	
	
}
