package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FactorCustomParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("factorCustomParameterRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = FactorCustomParameter.class)
public interface FactorCustomParameterRepository extends CrudRepository<FactorCustomParameter, Long> {
	
}
	