package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.CFMMCFundchg;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 出入金导入
 * @author lihuijun
 *
 */

@Repository("cFMMCFundchgRepository")
@EntityClass(entityClass = CFMMCFundchg.class)
public interface CFMMCFundchgRepository extends CrudRepository<CFMMCFundchg, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from CFMMCFundchg c where c.date=:date and (c.investerID=:investerID)") 
	public void delByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Query(value=" select new com.quantdo.iwin.entity.CFMMCFundchg(t.date,"
			+ "t.investerID,sum(t.inAndOutAmount) AS inAndOutAmount,max(t.remark) AS remark, "
			+ "case when t.inAndOutAmount > 0 then '1' else '2' end as inAndOutType) "
			+ "from CFMMCFundchg t "
			+ "where t.date = :queryDate "
			+ "and t.investerID = :investerID  "
			+ "group by t.date,t.investerID,inAndOutType "
			+ "order by t.investerID")
	public CFMMCFundchg findByDateAndInvesterID(@Param("queryDate") String queryDate, @Param("investerID") String investerID);
	
}
