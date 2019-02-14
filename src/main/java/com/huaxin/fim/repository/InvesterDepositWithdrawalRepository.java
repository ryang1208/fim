package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
@Repository(value = "investerDepositWithdrawalRepository")
@EntityClass(entityClass = InvesterDepositWithdrawal.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface InvesterDepositWithdrawalRepository extends CrudRepository<InvesterDepositWithdrawal, Long> {

	@Query("select pc from InvesterDepositWithdrawal pc,ProductInvesterRelationship pr,iWinProduct p where "
			+ "pc.investerID = pr.investerID AND pr.productID = p.id "
			+ " AND pc.brokerID = pr.brokerID "
			+ "AND (p.productName =:productName or :productName is null) "
			+ "AND (pc.date <=:endDate or :endDate is null) "
			+ "AND (pc.date >=:beginDate or :beginDate is null) order by pc.date desc")
	public List<InvesterDepositWithdrawal> findByCondition(@Param("productName") String productName, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	public List<InvesterDepositWithdrawal> findAll();

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from InvesterDepositWithdrawal p "
			+ "where p.date=:date and (p.dataSource=:dataSource) and (p.investerID=:investerID) ")
	public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource, @Param("investerID") String investerID);


	/**
	 *  按日期查询交易资金帐号出入金合计（当日存取合计）
	 * @param date
	 * @return
	 */
	@Query(value="SELECT SUM(deposit) - SUM(withdrawal)  FROM InvesterDepositWithdrawal WHERE investerID = :investerID AND brokerID = :brokerID AND date = :date")
	public BigDecimal getInvesterDepositWithdrawalOfInvestor(@Param("investerID") String investerID, @Param("brokerID") int brokerID, @Param("date") String date);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from InvesterDepositWithdrawal p "
			+ "where p.date=:date  and (p.investerID=:investerID) ")
	public void delByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_invester_deposit_withdrawal where concat(date,'#',broker_id,'#',invester_id) in "
			+ "(select concat(rf.date,'#',rf.broker_id,'#',rf.invester_id) "
			+ "from t_raw_qdiam_invester_deposit_withdrawal rf where rf.date = :date)",nativeQuery = true)
	public void delQDIAMByDate(@Param("date") String date);



	@Query(value="SELECT                                        "
			+"   t.invester_id invester_id,                     "
			+"   t.date DATE,                                   "
			+"   SUM(t.in_and_out_amount) deposit,              "
			+"   t.remark note,                                 "
			+"   1 type_deposit_withdrawal,                     "
			+"   0 withdrawal,                                  "
			+"(select case when r.broker_id is null then 285 	"
			+"		else r.broker_id end as broker_id		    "
			+"		from t_product_invester_relationship r		"
			+"		where r.invester_id = t.invester_id)        "
			+" FROM                                             "
			+"   t_raw_cfmmc_fundchg t                          "
			+" WHERE t.in_and_out_amount >= 0   and t.date=:date and t.invester_id =:investerID                "
			+" GROUP BY t.invester_id                           "
			+" UNION                                            "
			+" ALL                                              "
			+" SELECT                                           "
			+"   a.invester_id invester_id,                     "
			+"   a.date DATE,                                   "
			+"   0 deposit,                                     "
			+"   a.remark note,                                 "
			+"   2 type_deposit_withdrawal,                     "
			+"   ABS(SUM(a.in_and_out_amount)) withdrawal,      "
			+"  (select case when r.broker_id is null then 285 	"
			+"		else r.broker_id end as broker_id		    "
			+"		from t_product_invester_relationship r		"
			+"		where r.invester_id = a.invester_id)        "
			+" FROM                                             "
			+"   t_raw_cfmmc_fundchg a                          "
			+" WHERE a.in_and_out_amount < 0 and a.date=:date    and a.invester_id =:investerID             "
			+" GROUP BY a.invester_id                                      ",nativeQuery=true)
	public List<Object[]> findInOutMoney(@Param("date") String date, @Param("investerID") String investerID);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from InvesterDepositWithdrawal p "
			+ "where p.investerID=:investerID and (p.date >=:date) and (p.date <=:endDate)")
	public void delByDateAndInvesterIDDate(@Param("date") String date, @Param("investerID") String investerID, @Param("endDate") String endDate);


	@Query(value = "select * from t_invester_deposit_withdrawal where invester_id = :investerId and broker_id = :brokerId and date = :date",nativeQuery = true)
	public List<InvesterDepositWithdrawal> queryOriginWithdrawals(@Param("investerId") String investerId, @Param("brokerId") int brokerId, @Param("date") String date);

	@Modifying
	@Transactional
	@Query(value = "insert into t_invester_deposit_withdrawal(invester_id,broker_id,date,update_date,data_source,deposit,note,type_deposit_withdrawal,withdrawal) values(:investerId,:brokerId,:date,:updateDate," +
			":datasource,:deposit,:note,:typeDepositWithdrawal,:withdrawal)",nativeQuery = true)
	public void insert(@Param("investerId") String investerId, @Param("brokerId") int brokerId, @Param("date") String date, @Param("updateDate") String updateDate, @Param("datainterface") int datasource,
                       @Param("deposit") BigDecimal deposit, @Param("note") String note, @Param("typeDepositWithdrawal") int typeDepositWithdrawal, @Param("withdrawal") BigDecimal withdrawal);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_invester_deposit_withdrawal where id = :id",nativeQuery = true)
	public void deleteById(@Param("id") long id);

}
