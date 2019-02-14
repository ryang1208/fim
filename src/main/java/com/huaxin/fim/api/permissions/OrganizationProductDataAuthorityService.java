package com.huaxin.fim.api.permissions;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.OrganizationProductDataAuthority;

@Gateway
public interface OrganizationProductDataAuthorityService {
		
	public Map<String, Object> getCheckedAndNotCheckedProductList(String productIds);
	
	public List<OrganizationProductDataAuthority> findOrganizationProductDataAuthority(OrganizationProductDataAuthority organizationProductDataAuthority);
	
	public int saveOrganizationProductDataAuthority(String organizationId, String productId);

	public boolean deleteOrganizationProductDataAuthority(String organizationId, String productId);
}
