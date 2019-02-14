package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.CTPTransactionDetails;
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
@Repository(value = "ctpTransactionDetailsRepository")
@EntityClass(entityClass = CTPTransactionDetails.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface CTPTransactionDetailsRepository extends CrudRepository<CTPTransactionDetails, Long> {

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CTPTransactionDetails t "
			+ "where t.date=:date and (t.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CTPTransactionDetails t "
			+ "where t.investerID=:investerID and (t.date >=:date) and (t.date <=:endDate)")
	public void delByPrimaryKeyDate(@Param("date") String date, @Param("investerID") String investerID,
                                    @Param("endDate") String endDate);

	@Query("select c from CTPTransactionDetails c where c.date=:date and(c.investerID=:investerID) ")
	public List<CTPTransactionDetails> findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);
	
	
	@Query(value = "SELECT DISTINCT contract.asset_type FROM t_raw_ctp_transaction_details th LEFT JOIN (SELECT DATE,contract,asset_type FROM t_contract WHERE DATE=:date) contract ON "
			+ "th.date=contract.date AND th.contact=contract.contract "
			+ "where th.date=:date and (th.contact=:contact)", nativeQuery = true)
	public String findAssetTypeByContract(@Param("date") String date, @Param("contact") String contact);
}