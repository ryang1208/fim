package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.CTPHolddata;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  <br>
 * 创建日期：2015年7月21日 下午7:14:10 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author 
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "ctpPositionSummaryRepository")
@EntityClass(entityClass = CTPHolddata.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface CTPPositionSummaryRepository extends CrudRepository<CTPHolddata, Long> {

	public List<CTPHolddata> findAll();

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from CTPHolddata p "
			+ "where p.date=:date and (p.investerID=:investerID)")
	public void delByDataAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	//根据区间删除
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CTPHolddata p "
			+ "where p.investerID=:investerID and (p.date >=:date) and (p.date <=:endDate) ")
	public void delByPrimaryKeyDate(@Param("date") String date, @Param("investerID") String investerID,
                                    @Param("endDate") String endDate);

	@Query("select c from CTPHolddata c where c.date=:date and(c.investerID=:investerID) ")
	public List<CTPHolddata> findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);
	
	@Query(value = "SELECT  tc.industry,tc.variety_id  FROM  t_contract tc LEFT JOIN  t_raw_ctp_holddata th ON th.contact = tc.contract AND th.date = tc.date  "
			+ "where th.date=:date and (th.contact=:contact)", nativeQuery = true)
	public List<Object[]> findndustryByContract(@Param("date") String date, @Param("contact") String contact);
	
	
	@Query(value = "SELECT DISTINCT contract.industry,contract.variety_id,contract.asset_type FROM t_raw_ctp_holddata th LEFT JOIN (SELECT DATE,contract,industry,variety_id,asset_type FROM t_contract WHERE DATE=:date) contract ON "
			+ "th.date=contract.date AND th.contact=contract.contract "
			+ "where th.date=:date and (th.contact=:contact)", nativeQuery = true)
	public List<Object[]> findIndustryAssetTypeByContract(@Param("date") String date, @Param("contact") String contact);
	
}
