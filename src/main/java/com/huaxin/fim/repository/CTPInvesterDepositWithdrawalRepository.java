package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.CTPInvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
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
@Repository(value = "ctpInvesterDepositWithdrawalRepository")
@EntityClass(entityClass = CTPInvesterDepositWithdrawal.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface CTPInvesterDepositWithdrawalRepository extends CrudRepository<InvesterDepositWithdrawal, Long> {



	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from CTPInvesterDepositWithdrawal p "
			+ "where p.date=:date  and (p.investerID=:investerID) ")
	public void delByDateAndAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	//根据区间删除
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from CTPInvesterDepositWithdrawal p "
			+ "where p.investerID=:investerID and (p.date >=:date) and (p.date <=:endDate) ")
	public void delByDateAndAndInvesterIDDate(@Param("date") String date, @Param("investerID") String investerID,
                                              @Param("endDate") String endDate);



	@Query("select c from CTPInvesterDepositWithdrawal c where c.date=:date and(c.investerID=:investerID) ")
	public List<CTPInvesterDepositWithdrawal> findByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

}
