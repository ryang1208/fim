package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.CFMMCHoldData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 持仓导入
 * 
 * @author lihuijun
 *
 */

@Repository("cFMMCHoldDataRepository")
@EntityClass(entityClass = CFMMCHoldData.class)
public interface CFMMCHoldDataRepository extends CrudRepository<CFMMCHoldData, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CFMMCHoldData c where c.date=:date and(c.investerID=:investerID) ")
	public void delByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Query("select c from CFMMCHoldData c where c.date=:date ")
	public List<CFMMCHoldData> findByDate(@Param("date") String date);

	@Query("select c from CFMMCHoldData c where c.date=:date and (c.investerID=:investerID) and (c.contact=:contact) and (c.bs=:bs)")
	public CFMMCHoldData findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID,
                                                 @Param("contact") String contact, @Param("bs") String bs);

	@Query(value = "SELECT  tc.industry,tc.variety_id  FROM  t_contract tc LEFT JOIN  t_raw_cfmmc_holddata th ON th.contact = tc.contract AND th.date = tc.date  "
			+ "where th.date=:date and (th.contact=:contact)", nativeQuery = true)
	public List<Object[]> findndustryByContract(@Param("date") String date, @Param("contact") String contact);
	
	@Query(value = "SELECT  tc.asset_type  FROM  t_contract tc LEFT JOIN  t_raw_ctp_holddata th ON th.contact = tc.contract AND th.date = tc.date  "
			+ "where th.date=:date and (th.contact=:contact)", nativeQuery = true)
	public String findAssetTypeByContract(@Param("date") String date, @Param("contact") String contact);

}
