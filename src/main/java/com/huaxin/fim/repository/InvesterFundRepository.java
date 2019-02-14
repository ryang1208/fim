package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.InvesterFund;
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
 * <br>
 * 创建日期：2015年7月21日 下午7:14:10 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "investerFundRepository")
@EntityClass(entityClass = InvesterFund.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface InvesterFundRepository extends CrudRepository<InvesterFund, Long> {

	@Query("select pc from InvesterFund pc,ProductInvesterRelationship pr,iWinProduct p where "
			+ "pc.investerID = pr.investerID AND pr.productID = p.id "
			+ " AND pc.brokerID = pr.brokerID "
			+ "AND (p.productName =:productName or :productName is null) "
			+ "AND (pc.date <=:endDate or :endDate is null) "
			+ "AND (pc.date >=:beginDate or :beginDate is null) order by pc.date desc")
	public List<InvesterFund> findByCondition(@Param("productName") String productName,
                                              @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	public List<InvesterFund> findAll();

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from InvesterFund i " + "where i.date=:date and (i.investerID=:investerID)")
	public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

	@Query(value = "SELECT MIN(DATE) FROM t_invester_fund t " + "LEFT JOIN t_product_invester_relationship t1 "
			+ "ON t1.invester_id = t.invester_id "
			+ "WHERE t1.product_id=:productId OR :productId IS NULL", nativeQuery = true)
	public String getMinDate(@Param("productId") String productId);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from InvesterFund p "
			+ "where p.date=:date and (p.dataSource=:dataSource) and (p.investerID=:investerID) ")
	public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource,
                                                    @Param("investerID") String investerID);

	@Query(value = "SELECT MAX(DATE) FROM t_invester_fund t  WHERE t.`data_source` = 8", nativeQuery = true)
	public String getMaxDate();

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_invester_fund where concat(date,'#',broker_id,'#',invester_id) in "
			+ "(select concat(rf.date,'#',rf.broker_id,'#',rf.invester_id) "
			+ "from t_raw_qdiam_invester_fund rf where rf.date = :date)",nativeQuery = true)
	public void delQDIAMByDate(@Param("date") String date);

	/**
	 * 根据资金账户和交易日期获取资金信息
	 * @param investerId
	 * @param date
	 * @return
	 */
	@Query(value = "SELECT t FROM InvesterFund t  WHERE t.dataSource = 8 and t.investerID= :investerId and t.date = :date")
	public InvesterFund getInvesterInfoByIdAndDate(@Param("investerId") String investerId, @Param("date") String date);

	/**
	 * 根据资金账户和交易日期获取资金信息
	 * @param investerId
	 * @param date
	 * @param brokerId
	 * @return
	 */
	@Query(value = "SELECT t FROM InvesterFund t  WHERE t.dataSource <>9 and t.investerID= :investerId and t.date = :date and t.brokerID = :brokerId")
	public List<InvesterFund> queryByInvesterIdAndDate(@Param("investerId") String investerId, @Param("date") String date, @Param("brokerId") int brokerId);


	public InvesterFund findByInvesterIDAndBrokerIDAndDate(String investerId, int brokerId, String date);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "insert into t_invester_fund(invester_id,broker_id,date,update_date,accumulated_profit," +
			"available,balance_today,balance_yesterday,cash_frozen,close_profit," +
			"commission_toady,currency,data_source,deposit_withdraw_today,future_margin," +
			"option_margin,invester_equity,margin_call,margin_occupied,premium_today," +
			"risk_degree,monetary_offsetting_amount,non_monetary_offsetting_amount,tot_profit,basic_margin," +
			"quality_deposit,option_profit_loss,currency_pledge_deposit_occupancy,exercise_fee,delivery_margin," +
			"delivery_commission,long_option_market_value,short_option_market_value,market_equity,pedge_change_amount," +
			"premium_income,premium_payment,close_profit_market,position_profit_market) values(:investerId,:brokerId,:date,:updateDate,:accumulatedProfit," +
			":available,:balanceToday,:balanceYesterday,:cashFrozen,:closeProfit," +
			":commissionToady,:currency,:datasource,:depositWithDrawToday,:futureMargin," +
			":optionMargin,:investerEquity,:marginCall,:marginOccupied,:premiumToday," +
			":riskDegree,:monetaryOffsettingAmount,:nonMonetaryOffsettingAmount,:totProfit,:basicMargin," +
			":qualityDeposit,:optionProfitLoss,:currencyPledgeDepositOccupancy,:exerciseFee,:deliveryMargin," +
			":deliveryCommission,:longOptionMarketValue,:shortOptionMarketValue,:marketEquity,:pedgeChangeAmount," +
			":premiumIncome,:premiumPayment,:closeProfitMarket,:positionProfitMarket)",nativeQuery = true)
	public void insert(@Param("investerId") String investerId, @Param("brokerId") int brokerId, @Param("date") String date, @Param("updateDate") String updateDate, @Param("accumulatedProfit") BigDecimal accumulatedProfit,
                       @Param("available") BigDecimal available, @Param("balanceToday") BigDecimal balanceToday, @Param("balanceYesterday") BigDecimal balanceYesterday, @Param("cashFrozen") BigDecimal cashFrozen, @Param("closeProfit") BigDecimal closeProfit,
                       @Param("commissionToady") BigDecimal commissionToady, @Param("currency") BigDecimal currency, @Param("datasource") int datasource, @Param("depositWithDrawToday") BigDecimal depositWithDrawToday, @Param("futureMargin") BigDecimal futureMargin,
                       @Param("optionMargin") BigDecimal optionMargin, @Param("investerEquity") BigDecimal investerEquity, @Param("marginCall") BigDecimal marginCall, @Param("marginOccupied") BigDecimal marginOccupied, @Param("premiumToday") BigDecimal premiumToday,
                       @Param("riskDegree") BigDecimal riskDegree, @Param("monetaryOffsettingAmount") BigDecimal monetaryOffsettingAmount, @Param("nonMonetaryOffsettingAmount") BigDecimal nonMonetaryOffsettingAmount, @Param("totProfit") BigDecimal totProfit, @Param("basicMargin") BigDecimal basicMargin,
                       @Param("qualityDeposit") BigDecimal qualityDeposit, @Param("optionProfitLoss") BigDecimal optionProfitLoss, @Param("currencyPledgeDepositOccupancy") BigDecimal currencyPledgeDepositOccupancy, @Param("exerciseFee") BigDecimal exerciseFee, @Param("deliveryMargin") BigDecimal deliveryMargin,
                       @Param("deliveryCommission") BigDecimal deliveryCommission, @Param("longOptionMarketValue") BigDecimal longOptionMarketValue, @Param("shortOptionMarketValue") BigDecimal shortOptionMarketValue, @Param("marketEquity") BigDecimal marketEquity,
                       @Param("pedgeChangeAmount") BigDecimal pedgeChangeAmount, @Param("premiumIncome") BigDecimal premiumIncome, @Param("premiumPayment") BigDecimal premiumPayment, @Param("closeProfitMarket") BigDecimal closeProfitMarket, @Param("positionProfitMarket") BigDecimal positionProfitMarket);

	@Modifying
	@Transactional
	@Query(value = "update t_invester_fund set update_date = :updateDate,accumulated_profit=:accumulatedProfit,available=:available," +
			" balance_today=:balanceToday,balance_yesterday = :balanceYesterday,cash_frozen=:cashFrozen,close_profit=:closeProfit," +
			"commission_toady=:commissionToady,currency=:currency,data_source=:datasource,deposit_withdraw_today=:depositWithDrawToday," +
			"future_margin=:futureMargin,option_margin=:optionMargin,invester_equity=:investerEquity,margin_call=:marginCall," +
			"margin_occupied=:marginOccupied,premium_today=:premiumToday,risk_degree=:riskDegree,monetary_offsetting_amount=:monetaryOffsettingAmount," +
			"non_monetary_offsetting_amount=:nonMonetaryOffsettingAmount,tot_profit=:totProfit,basic_margin=:basicMargin," +
			"quality_deposit=:qualityDeposit,option_profit_loss=:optionProfitLoss,currency_pledge_deposit_occupancy=:currencyPledgeDepositOccupancy," +
			"exercise_fee=:exerciseFee,delivery_margin=:deliveryMargin,delivery_commission=:deliveryCommission,long_option_market_value=:longOptionMarketValue," +
			"short_option_market_value=:shortOptionMarketValue,market_equity=:marketEquity,pedge_change_amount=:pedgeChangeAmount," +
			"premium_income=:premiumIncome,premium_payment=:premiumPayment,close_profit_market=:closeProfitMarket,position_profit_market=:positionProfitMarket " +
			" where invester_id = :investerId and broker_id = :brokerId and date =:date",nativeQuery = true)
	public void update(@Param("investerId") String investerId, @Param("brokerId") int brokerId, @Param("date") String date, @Param("updateDate") String updateDate, @Param("accumulatedProfit") BigDecimal accumulatedProfit,
                       @Param("available") BigDecimal available, @Param("balanceToday") BigDecimal balanceToday, @Param("balanceYesterday") BigDecimal balanceYesterday, @Param("cashFrozen") BigDecimal cashFrozen, @Param("closeProfit") BigDecimal closeProfit,
                       @Param("commissionToady") BigDecimal commissionToady, @Param("currency") BigDecimal currency, @Param("datasource") int datasource, @Param("depositWithDrawToday") BigDecimal depositWithDrawToday, @Param("futureMargin") BigDecimal futureMargin,
                       @Param("optionMargin") BigDecimal optionMargin, @Param("investerEquity") BigDecimal investerEquity, @Param("marginCall") BigDecimal marginCall, @Param("marginOccupied") BigDecimal marginOccupied, @Param("premiumToday") BigDecimal premiumToday,
                       @Param("riskDegree") BigDecimal riskDegree, @Param("monetaryOffsettingAmount") BigDecimal monetaryOffsettingAmount, @Param("nonMonetaryOffsettingAmount") BigDecimal nonMonetaryOffsettingAmount, @Param("totProfit") BigDecimal totProfit, @Param("basicMargin") BigDecimal basicMargin,
                       @Param("qualityDeposit") BigDecimal qualityDeposit, @Param("optionProfitLoss") BigDecimal optionProfitLoss, @Param("currencyPledgeDepositOccupancy") BigDecimal currencyPledgeDepositOccupancy, @Param("exerciseFee") BigDecimal exerciseFee, @Param("deliveryMargin") BigDecimal deliveryMargin,
                       @Param("deliveryCommission") BigDecimal deliveryCommission, @Param("longOptionMarketValue") BigDecimal longOptionMarketValue, @Param("shortOptionMarketValue") BigDecimal shortOptionMarketValue, @Param("marketEquity") BigDecimal marketEquity,
                       @Param("pedgeChangeAmount") BigDecimal pedgeChangeAmount, @Param("premiumIncome") BigDecimal premiumIncome, @Param("premiumPayment") BigDecimal premiumPayment, @Param("closeProfitMarket") BigDecimal closeProfitMarket, @Param("positionProfitMarket") BigDecimal positionProfitMarket);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "update InvesterFund set investerID = :investerID ,brokerID = :brokerId  "
			+ "where investerID = :qTIDInvesterID AND date = :date")
	public void updateQTIDDatas(@Param("investerID") String investerID, @Param("brokerId") int brokerId,
                                @Param("qTIDInvesterID") String qTIDInvesterID, @Param("date") String date);

	/**
	 * 获取最新一天需要计算成交额的产品代码列表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT                                 "
				+"    CONCAT(product_id,'')                           "
				+" FROM                                   "
				+"   t_product_invester_relationship      "
				+" WHERE invester_id IN                   "
				+"   (SELECT                              "
				+"     t.invester_id                      "
				+"   FROM                                 "
				+"     t_invester_fund t            "
				+"   WHERE t.date = :date              "
				+"   GROUP BY t.invester_id)              "
				+" GROUP BY product_id   ",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);

	/**
	 * 根据资金账户和交易日期获取资金信息
	 * @param investerId
	 * @param date
	 * @return
	 */
	@Query(value = "SELECT t FROM InvesterFund t  WHERE  t.investerID= :investerId and t.date = :date and t.brokerID = :brokerID")
	public InvesterFund getInvesterFundByInvesterIdAndDate(@Param("investerId") String investerId, @Param("date") String date, @Param("brokerID") int brokerId);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from InvesterFund i " + "where i.date=:date and (i.investerID=:investerID) ")
	public void delInvesterFund(@Param("date") String date, @Param("investerID") String investerID);




	
	/**
	 * 根据产品ID和资金表类型获取资金信息
	 * @return
	 */	
	@Query(value=" SELECT										   "
                + " t.date date,                                   "
				+"  t.margin_occupied marginOccupied,              "
				+"  t.invester_equity investerEquity,              "
				+"  td.deposit depositWithdrawToday                "
				+" FROM                                            "
				+"  t_invester_fund t                              "
				+"  LEFT JOIN t_invester_deposit_withdrawal td     "
				+"    ON t.invester_id = td.invester_id            "
				+"    AND t.broker_id = td.broker_id               "
				+"    AND t.date = td.date                         "
				+"    AND td.type_deposit_withdrawal ='1'          "
				+"  LEFT JOIN t_product_invester_relationship tp   "
				+"    ON t.invester_id = tp.invester_id            "
				+"    AND tp.broker_id = t.broker_id               "
				+"    AND tp.invester_type = '1'                   "
				+"   WHERE tp.product_id = :productId              "
				+"   ORDER BY t.date  " ,nativeQuery=true)
	public List<Object[]> findFundByProductId(@Param("productId") Integer productId);
	
	/**
	 * 根据产品ID和资金表类型获取资金分险度
	 * @return
	 */	
	@Query("select pc from InvesterFund pc,ProductInvesterRelationship pr where "
			+ "pc.investerID = pr.investerID "
			+ "AND (pc.brokerID = pr.brokerID) "
			+ "AND (pr.productID =:productId or :productId is null) order by pc.date ")
	public List<InvesterFund> findFundRiskByProductId(@Param("productId") Integer productId);
	
	@Query(value="SELECT i.invester_equity "
			+ "FROM t_invester_fund i"
			+ " WHERE i.invester_id IN (SELECT invester_id FROM t_product_invester_relationship WHERE product_id=:productId) ORDER BY i.date ASC LIMIT 1",nativeQuery=true)
	public BigDecimal getInveserFundListByInvesterId(@Param("productId") String productId);
}
