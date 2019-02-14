package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.TransactionDetails;
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
@Repository(value = "transactionDetailsRepository")
@EntityClass(entityClass = TransactionDetails.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface TransactionDetailsRepository extends CrudRepository<TransactionDetails, Long> {

	@Query("select d from TransactionDetails d,ProductInvesterRelationship r,iWinProduct p where "
			+ "d.investerID = r.investerID AND p.id = r.productID  AND d.brokerID = r.brokerID "
			+ "AND (p.productName =:productName or :productName is null) "
			+ "AND (d.date <=:endDate or :endDate is null) "
			+ "AND (d.date >=:beginDate or :beginDate is null) order by d.date asc,d.contact asc,d.transcationNO desc")
	public List<TransactionDetails> findByCondition(@Param("productName") String productName, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	public List<TransactionDetails> findAll();

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from TransactionDetails t "
			+ "where t.date=:date and (t.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from TransactionDetails t "
			+ "where t.investerID=:investerID and (t.date >=:date) and (t.date <=:endDate) ")
	public void delByPrimaryKeyDate(@Param("date") String date, @Param("investerID") String investerID, @Param("endDate") String endDate);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from TransactionDetails t "
			+ "where t.date=:date and (t.dataSource=:dataSource) and (t.investerID=:investerID) and (t.transcationNO=:transcationNO)")
	public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource, @Param("investerID") String investerID
            , @Param("transcationNO") String transcationNO);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_transaction_details where concat(date,'#',broker_id,'#',invester_id) in "
			+ "(select concat(rf.date,'#',rf.broker_id,'#',rf.invester_id) "
			+ "from t_raw_qdiam_transaction_details rf where rf.date = :date)",nativeQuery = true)
	public void delQDIAMByDate(@Param("date") String date);

	@Query(value = "select t from TransactionDetails t "
			+ "where t.date = :date and t.transcationNO = :transcationNO and t.oc <> 0 and t.investerID = :investerID")
	public TransactionDetails findByDateAndTranscationNO(@Param("date") String date,
                                                         @Param("transcationNO") String transcationNO, @Param("investerID") String investerID);

	/**
	 * 获取最新一天需要计算成交额的产品代码列表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT                                 "
				+"  CONCAT(product_id,'')                            "
				+" FROM                                   "
				+"   t_product_invester_relationship      "
				+" WHERE invester_id IN                   "
				+"   (SELECT                              "
				+"     t.invester_id                      "
				+"   FROM                                 "
				+"     t_transaction_details t            "
				+"   WHERE t.date = :date              "
				+"   GROUP BY t.invester_id)              "
				+" GROUP BY product_id   ",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);
}