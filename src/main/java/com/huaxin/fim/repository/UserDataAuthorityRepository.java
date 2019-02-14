package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.UserDataAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = UserDataAuthority.class)
@Named("userDataAuthorityRepository")
public interface UserDataAuthorityRepository extends CrudRepository<UserDataAuthority, Long> {
	
	public UserDataAuthority findByLoginIDAndProductID(String loginID, int productID);
	
}
	