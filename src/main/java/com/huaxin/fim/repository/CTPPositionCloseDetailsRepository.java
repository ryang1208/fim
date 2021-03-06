package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.CTPPositionCloseDetails;
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
@Repository(value = "ctpPositionCloseDetailsRepository")
@EntityClass(entityClass = CTPPositionCloseDetails.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface CTPPositionCloseDetailsRepository extends CrudRepository<CTPPositionCloseDetails, Long> {
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from CTPPositionCloseDetails p "
			+ "where p.date=:date and (p.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	//根据区间删除
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CTPPositionCloseDetails p "
			+ "where p.investerID=:investerID and (p.date >=:date) and (p.date <=:endDate) ")
	public void delByPrimaryKeyDate(@Param("date") String date, @Param("investerID") String investerID,
                                    @Param("endDate") String endDate);

	@Query("select c from CTPPositionCloseDetails c where c.date=:date and(c.investerID=:investerID) ")
	public List<CTPPositionCloseDetails> findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);
	
	
	@Query(value = "SELECT DISTINCT contract.asset_type FROM t_raw_ctp_position_close_details th LEFT JOIN (SELECT DATE,contract,asset_type FROM t_contract WHERE DATE=:date) contract ON "
			+ "th.date=contract.date AND th.contact=contract.contract "
			+ "where th.date=:date and (th.contact=:contact)", nativeQuery = true)
	public String findAssetTypeByContract(@Param("date") String date, @Param("contact") String contact);
	
}