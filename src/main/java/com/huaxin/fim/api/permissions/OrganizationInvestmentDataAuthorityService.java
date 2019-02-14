package com.huaxin.fim.api.permissions;

/**
 * 机构投顾权限
 * 
 * @author wucq
 */
import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.Organization;
import com.huaxin.fim.entity.entity.OrganizationInvestmentDataAuthority;

@Gateway
public interface OrganizationInvestmentDataAuthorityService {

	public List<Organization> getAllOrganization();
	
	public Map<String, Object> getCheckedAndNotCheckedInvestmentList(String investmentIds);
	
	public List<OrganizationInvestmentDataAuthority> findAllOrganizationInvestment(OrganizationInvestmentDataAuthority rganizationInvestmentDataAuthority);
	
	public int saveOrganizationInvestment(String investmentId, String organizationId);

	public boolean deleteOrganizationInvestmentByInvestmentId(String investmentId, String organizationId);
	
}
