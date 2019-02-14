package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.Organization;
import com.huaxin.fim.entity.entity.UserOrganizationDataAuthority;
import com.huaxin.fim.entity.request.OrganizationRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrganizationMapper {
	
	/**
	 * 机构管理条件查询
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public List<Organization> getOrganizationListByCondition(
            @Param("request") OrganizationRequest request,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay);

	/**
	 * 获取用户未设定的机构数据集合
	 * @param userId
	 * @return
	 */
	public List<Organization> getUnSelectedOrganizationList(@Param("userId") String userId);

	public List<UserOrganizationDataAuthority> findByUserId(@Param("userId") String userId);
	
}
