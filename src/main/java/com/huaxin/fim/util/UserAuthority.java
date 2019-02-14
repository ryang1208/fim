package com.huaxin.fim.util;

import com.dev.framework.core.session.CurrentSessionStoreFactory;
import com.dev.framework.core.session.FrameworkSession;
import com.dev.framework.sso.entity.Role;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huaxin.fim.api.fundscreening.UserAuthorityService;
import com.huaxin.fim.repository.UserDataAuthorityRepository;

import javax.inject.Named;
import java.util.List;


/**
 * 用户共用方法
 * @author sst
 *
 */

@Named("userAuthorityService")
public class UserAuthority implements UserAuthorityService {
	
	
//	@Inject
//	Gson gson;
	
	/** 
     * 该用户是否有该产品数据权限
     *  
     * @return boolean
     */ 
    @SuppressWarnings("unused")
	@Override
	public boolean isAuthority(String login_id,String product_id)  { 
    	FrameworkSession session = CurrentSessionStoreFactory.getCurrentSessionStore().getCurrentSession();
    	UserDataAuthorityRepository userDataAuthorityRepository = (UserDataAuthorityRepository) SpringUtils.getBean("userDataAuthorityRepository");
    	Gson gson = new Gson();
    	List<Role> roleList = gson.fromJson(session.getAttribute("ROLES").toString(), new TypeToken<List<Role>>(){}.getType());
    	if(null == roleList || roleList.size()<=0){
    		return false;
    	}
    	String roleIdStr = "";
    	for(Role r:roleList){
    		String roleId = r.getId().toString();
    		roleIdStr = roleIdStr+"/"+roleId;
    	}
    	if(session==null){	//系统处理
    		return true;
    	}
    	else if(roleIdStr.contains("3")){	//该用户为管理员角色
    		return true;
    	}else {	//一般用户
    		if(userDataAuthorityRepository.findByLoginIDAndProductID(login_id, Integer.parseInt(product_id))==null){
				return false;
			}else{
				return true;
			}
    	}
    }  
    
    

}
