package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = InvestmentManager.class)
public interface IwinInvestmentManagerRepository extends CrudRepository<InvestmentManager, Long> {
	
	public List<InvestmentManager> findByServiceManagerID(String serviceManagerID);
	
}
