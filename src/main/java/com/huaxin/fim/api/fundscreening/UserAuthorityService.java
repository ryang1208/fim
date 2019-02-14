package com.huaxin.fim.api.fundscreening;

import com.dev.framework.core.annotation.Gateway;


/**
 * 用戶数据权限判断接口
 * 
 * @author sust
 *
 */
@Gateway
public interface UserAuthorityService {

	/**
	 * 取得用戶数据权限判断
	 * 
	 * @param loginID
	 * @param productID
	 * @return
	 */
	public boolean isAuthority(String loginID, String productID);

}
