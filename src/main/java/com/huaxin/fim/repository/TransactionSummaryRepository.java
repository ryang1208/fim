package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.TransactionSummary;
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
@Repository(value = "transactionSummaryRepository")
@EntityClass(entityClass = TransactionSummary.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface TransactionSummaryRepository extends CrudRepository<TransactionSummary, Long> {

	//多条件查询根据基金名称，开始日期，结束日期
	@Query("select t from TransactionSummary t,ProductInvesterRelationship r,iWinProduct p where "
			+ "t.investerID = r.investerID AND p.id = r.productID"
			+ " AND t.brokerID = r.brokerID  "
			+ "AND (p.productName =:contact or :contact is null) "
			+ "AND (t.date <= :endDate or :endDate is null) "
			+ "AND (t.date >= :beginDate or :beginDate is null) order by t.date desc,t.contact asc")
	public List<TransactionSummary> findByCondition(@Param("contact") String contact, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	public List<TransactionSummary> findAll();
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from TransactionSummary t "
			+ "where t.date=:date and (t.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Query(value = "SELECT MIN(DATE) FROM t_transaction_summary t "
			+ "LEFT JOIN t_product_invester_relationship tp ON tp.invester_id = t.invester_id "
			+ "WHERE tp.product_id=:productId OR :productId IS NULL", nativeQuery = true)
	public String getMinDate(@Param("productId") String productId);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_transaction_summary "
			+ "WHERE date between :startDate and :endDate and data_source =:dataSource ", nativeQuery = true)
	public void delByDate(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("dataSource") Integer dataSource);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_transaction_summary "
			+ "WHERE date =:date and data_source =:dataSource and invester_id =:investerID ", nativeQuery = true)
	public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource, @Param("investerID") String investerID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_transaction_summary "
			+ "WHERE date =:date  and invester_id =:investerID ", nativeQuery = true)
	public void delByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

	/**
	 * 获取行业品种
	 */
	@Query(value = "SELECT  tc.industry,tc.variety_id FROM  t_contract tc LEFT JOIN t_transaction_summary ts ON ts.contact=tc.contract AND ts.date = tc.date "
			+ "where tc.date=:date and (tc.contract=:contact)",nativeQuery = true)
	public List<Object[]> findndustryByContract(@Param("date") String date,
                                                @Param("contact") String contact);

	public List<TransactionSummary> findByDateAndInvesterIDAndBrokerID(String date, String investerId, int brokerId);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "insert into t_transaction_summary(sh,oc,invester_id,broker_id,date,update_date,contact,market_type," +
			"total_expense,bs,close_profit,commission,data_source,variety_id,industry,lots,price,turnover,close_profit_hedge) values(" +
			":sh,:oc,:investerId,:brokerId,:date,:updateDate,:contact,:marketType,:totalExpense,:bs,:closeProfit," +
			":commission,:datasource,:varietyId,:industry,:lots,:price,:turnover,:closeProfitHedge)",nativeQuery = true)
	public void insert(@Param("sh") int sh, @Param("oc") int oc, @Param("investerId") String investerId, @Param("brokerId") int brokerId,
                       @Param("date") String date, @Param("updateDate") String updateDate, @Param("contact") String contact,
                       @Param("marketType") String marketType, @Param("totalExpense") String totalExpense, @Param("bs") int bs,
                       @Param("closeProfit") BigDecimal closeProfit, @Param("commission") BigDecimal commission, @Param("datainterface") int datasource,
                       @Param("varietyId") String varietyId, @Param("industry") String industry, @Param("lots") int lots, @Param("price") BigDecimal price,
                       @Param("turnover") BigDecimal turnover, @Param("closeProfitHedge") BigDecimal closeProfitHedge);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "update t_transaction_summary set sh=:sh,oc=:oc,update_date = :updateDate,market_type = :marketType,total_expense=:totalExpense," +
			"bs=:bs,close_profit=:closeProfit,commission=:commission,data_source=:datasource,variety_id=:varietyId,industry=:industry," +
			"lots=:lots,price=:price,turnover=:turnover,closeProfitHedge=:closeProfitHedge " +
			" where date =:date and invester_id=:investerId and broker_id = :brokerId and contact =:contact and price=:price",nativeQuery = true)
	public void update(@Param("sh") int sh, @Param("oc") int oc, @Param("investerId") String investerId, @Param("brokerId") int brokerId,
                       @Param("date") String date, @Param("updateDate") String updateDate, @Param("contact") String contact,
                       @Param("marketType") String marketType, @Param("totalExpense") String totalExpense, @Param("bs") int bs,
                       @Param("closeProfit") BigDecimal closeProfit, @Param("commission") BigDecimal commission, @Param("datainterface") int datasource,
                       @Param("varietyId") String varietyId, @Param("industry") String industry, @Param("lots") int lots, @Param("price") BigDecimal price,
                       @Param("turnover") BigDecimal turnover, @Param("closeProfitHedge") BigDecimal closeProfitHedge);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_transaction_summary where date = :date and invester_id = :investerId and broker_id = :brokerId",nativeQuery = true)
	public void delByDateInvesterIdBrokerId(@Param("date") String date, @Param("investerId") String investerId, @Param("brokerId") int brokerId);

	/**
	 * 金仕达补充成交汇总中平仓明细
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value ="UPDATE                                      "
				+"  t_transaction_summary ts                   "
				+" SET                                         "
				+"  ts.close_profit = (SELECT                  "
				+"    SUM(td.close_profit)           		   "
				+"  FROM                                       "
				+"    t_position_close_details td              "
				+"      WHERE  td.invester_id = ts.invester_id "
				+"      AND td.date = ts.date                  "
				+"      AND td.broker_id = ts.broker_id        "
				+"      AND td.contact = ts.contact            "
				+"      AND td.price = ts.price 			   "
				+"		AND td.bs = ts.bs),              	   "
				+"  ts.close_profit_hedge = (SELECT            "
				+"    SUM(td.close_profit_hedge)               "
				+"  FROM                                       "
				+"    t_position_close_details td              "
				+"      WHERE  td.invester_id = ts.invester_id "
				+"      AND td.date = ts.date                  "
				+"      AND td.broker_id = ts.broker_id        "
				+"      AND td.contact = ts.contact            "
				+"      AND td.price = ts.price 			   "
				+"		AND td.bs = ts.bs)              	   "
				+"  WHERE ts.DATE = :date                      "
                +"  AND ts.invester_id = :investerID AND ts.oc=1    ", nativeQuery = true)
	public void updateByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);
	
}
