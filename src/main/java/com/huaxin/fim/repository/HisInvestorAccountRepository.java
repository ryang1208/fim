package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.qdam.IWinHisInvestorAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * qdam资金数据来源
 * @author xieky
 *
 */
@Repository
@EntityClass(entityClass = IWinHisInvestorAccount.class)
public interface HisInvestorAccountRepository extends CrudRepository<IWinHisInvestorAccount, Long> {

	@Query(value="select MAX(settleDate) as maxDate from HisInvestorAccount ")
	public String maxSettleDate();
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from HisInvestorAccount i "
			+ "where i.settleDate>=:startDate and i.settleDate<=:endDate")
	public void delBySettleDate(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
}
