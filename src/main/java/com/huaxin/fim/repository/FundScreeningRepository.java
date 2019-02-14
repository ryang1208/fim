package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.TransactionSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = TransactionSummary.class)
public interface FundScreeningRepository extends CrudRepository<TransactionSummary, Long> {
	
	@Query(value = "SELECT MAX(DATE) FROM t_financial_date WHERE DATE<:date AND is_trading_day=1 AND is_calculate=1",nativeQuery=true)
	public String getLastTradingCalculateDate(@Param("date") String date);
	
}
	