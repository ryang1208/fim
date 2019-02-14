package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.PositionSummary;
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
 * @version 1.0
 * @since 1.0
 */
@Repository(value = "positionSummaryRepository")
@EntityClass(entityClass = PositionSummary.class)
@Forbid(forbiddenMethods = {"deleteAll"})
public interface PositionSummaryRepository extends CrudRepository<PositionSummary, Long> {

    @Query("select d from PositionSummary d,ProductInvesterRelationship r,iWinProduct p where "
            + "d.investerID = r.investerID AND p.id = r.productID "
            + " AND d.brokerID = r.brokerID "
            + "AND (p.productName =:productName or :productName is null) "
            + "AND (d.date <=:endDate or :endDate is null) "
            + "AND (d.date >=:beginDate or :beginDate is null) order by d.date desc,d.contact asc")
    public List<PositionSummary> findByCondition(@Param("productName") String productName,
                                                 @Param("beginDate") String beginDate, @Param("endDate") String endDate);

    public List<PositionSummary> findByDateAndInvesterIDAndBrokerID(String date, String investerId, int brokerId);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from t_position_summary where date = :date and invester_id = :investerId and broker_id = :brokerId", nativeQuery = true)
    public void delByDateInvesterIdBrokerId(@Param("date") String date, @Param("investerId") String investerId, @Param("brokerId") int brokerId);

    public List<PositionSummary> findAll();

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from PositionSummary p " + "where p.date=:date and (p.investerID=:investerID)")
    public void delByPrimaryKey(@Param("date") String date, @Param("investerID") String investerID);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from PositionSummary p "
            + "where p.investerID=:investerID and (p.date >=:date) and (p.date <=:endDate) ")
    public void delByPrimaryKeyDate(@Param("date") String date, @Param("investerID") String investerID,
                                    @Param("endDate") String endDate);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from PositionSummary p " + "where p.date=:date and (p.investerID=:investerID) ")
    public void delByDateAndInvesterID(@Param("date") String date, @Param("investerID") String investerID);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from PositionSummary p "
            + "where p.date=:date and (p.dataSource=:dataSource) and (p.investerID=:investerID) ")
    public void delByDateAndDataSourceAndInvesterID(@Param("date") String date, @Param("dataSource") Integer dataSource,
                                                    @Param("investerID") String investerID);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from PositionSummary p " + "where p.date=:date and (p.dataSource=:dataSource) "
            + "and (p.investerID=:investerID) and (p.contact=:contact) " + "and (p.bs=:bs) ")
    public void delByDateAndDataSourceAndInvesterIDAndContract(@Param("date") String date,
                                                               @Param("dataSource") int dataSource, @Param("investerID") String investerID,
                                                               @Param("contact") String contact, @Param("bs") int bs);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "DELETE FROM t_position_summary "
            + "WHERE date between :startDate and :endDate and data_source =:dataSource ", nativeQuery = true)
    public void delByDate(@Param("startDate") String startDate, @Param("endDate") String endDate,
                          @Param("dataSource") Integer dataSource);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from t_position_summary where concat(date,'#',broker_id,'#',invester_id) in "
            + "(select concat(rf.date,'#',rf.broker_id,'#',rf.invester_id) "
            + "from t_raw_qdiam_position_summary rf where rf.date = :date)", nativeQuery = true)
    public void delQDIAMByDate(@Param("date") String date);

    /**
     * 计算产品每日个股品种市值汇总
     */
    @Query(value = "SELECT r.product_id,s.date,s.contact,s.market_capitalization "
            + "FROM t_position_summary s INNER JOIN t_product_invester_relationship r "
            + "ON s.invester_id = r.invester_id AND s.broker_id = r.broker_id "
            + "WHERE s.market_capitalization IS NOT NULL "
            + "AND r.product_id IN (:productID) "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.market_type = '2' "
            + "ORDER BY s.date,s.contact", nativeQuery = true)
    public List<Object[]> findStockMarketValueByFundIDAndDatePeriod(@Param("productID") List<String> productID,
                                                                    @Param("startDate") String startDate, @Param("endDate") String endDate);


    /**
     * 计算产品每日持仓行业市值汇总
     */
    @Query(value = "SELECT r.product_id,s.date,s.industry,sum(s.market_capitalization) market_capitalization "
            + "FROM t_position_summary s INNER JOIN t_product_invester_relationship r "
            + "ON s.invester_id = r.invester_id AND s.broker_id = r.broker_id "
            + "WHERE s.market_capitalization IS NOT NULL "
            + "AND s.industry IS NOT NULL "
            + "AND r.product_id IN (:productID) "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.market_type = '2' "
            + "group BY s.date,r.product_id,s.industry "
            + "ORDER BY s.date,r.product_id,s.industry", nativeQuery = true)
    public List<Object[]> findIndustryMarketValueByFundIDAndDatePeriod(@Param("productID") List<String> productID,
                                                                       @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 计算产品每日股票总市值
     */
    @Query(value = "SELECT s.date,r.product_id,SUM(s.market_capitalization) "
            + "FROM t_position_summary s INNER JOIN t_product_invester_relationship r "
            + "ON s.invester_id = r.invester_id AND s.broker_id = r.broker_id "
            + "WHERE s.market_capitalization IS NOT NULL " + "AND s.industry IS NOT NULL "
            + "AND (r.product_id = :productID or :productID is null) "
            + "AND (s.date >= :startDate or :startDate is null) " + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.market_type = :marketType " + "GROUP BY s.date,r.product_id "
            + "ORDER BY s.date,r.product_id", nativeQuery = true)
    public List<Object[]> findProductStockMarketValueByFundIDAndDatePeriod(@Param("productID") Integer productID,
                                                                           @Param("startDate") String startDate, @Param("endDate") String endDate,
                                                                           @Param("marketType") String marketType);

    /**
     * 获取股票持仓汇总数据
     */
    @Query(value = "select new com.quantdo.iwin.entity.PositionSummary(p.date,p.contact,"
            + "p.marketType,p.marketCapitalization,p.industry,p.stockType,'t_position_summary',r.productID) "
            + "from PositionSummary p,ProductInvesterRelationship r "
            + "where p.marketType = '2' and p.industry is not null "
            + "and p.marketCapitalization is not null "
            + "and p.investerID = r.investerID and p.brokerID = r.brokerID "
            + "and (r.productID = :productID or :productID is null) "
            + "and (p.date >= :startDate or :startDate is null) "
            + "and (p.date <= :endDate or :endDate is null) "
            + "order by r.productID,p.date")
    public List<PositionSummary> findStockDatasByProductIDAndDate(@Param("productID") Integer productID,
                                                                  @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 获取行业品种
     */
    @Query(value = "SELECT  tc.industry,tc.variety_id FROM  t_contract tc LEFT JOIN t_position_summary ts ON ts.contact=tc.contract AND ts.date = tc.date "
            + "where tc.date=:date and (tc.contract=:contact)", nativeQuery = true)
    public List<Object[]> findndustryByContract(@Param("date") String date, @Param("contact") String contact);

    /**
     * 根据资金账户及日期获取持仓汇总信息
     *
     * @param investerId
     * @param date
     * @param brokerId
     * @return
     */
    @Query(value = "select p from PositionSummary p where p.dataSource<>9 and p.investerID = :investerId and p.date = :date and p.brokerID = :brokerId")
    public List<PositionSummary> queryByInvesterIdAndDateAndBrokerId(@Param("investerId") String investerId,
                                                                     @Param("date") String date, @Param("brokerId") int brokerId);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = " INSERT INTO t_position_summary (                        "
            + "   sh,                                                   "
            + "   bs,                                                   "
            + "   price_sell,                                           "
            + "   price_buy,                                            "
            + "   invester_id,                                          "
            + "   broker_id,                                            "
            + "   DATE,                                                 "
            + "   contact,                                              "
            + "   data_source,                                          "
            + "   floating_profit,                                      "
            + "   margin,                                               "
            + "   position_buy,                                         "
            + "   position_sell,                                        "
            + "   settlementPrice_today,                                "
            + "   settlementPrice_yesterday,                            "
            + "   ori_margin,                                           "
            + "   market_type,                                          "
            + "   position_cost,                                        "
            + "   total_profit,                                         "
            + "   market_capitalization,                                "
            + "   industry,                                             "
            + "   stock_type,                                           "
            + "   variety_id,										   "
            + "   update_date                                           "
            + " )                                                       "
            + " SELECT                                                  "
            + "   '2' sh,                                               "
            + "   CASE                                                  "
            + "     WHEN t.cost > 0                                     "
            + "     THEN '0'                                            "
            + "     ELSE '1'                                            "
            + "   END bs,                                               "
            + "   NULL price_sell,                                      "
            + "   NULL price_buy,                                       "
            + "   :investerId invester_id,                              "
            + "   :brokerId broker_id,                                  "
            + "   t.date DATE,                                          "
            + "   CASE                                                  "
            + "     WHEN LEFT(RIGHT(t.account_code, 6), 1) = '0'          "
            + "     THEN RIGHT(RIGHT(t.account_code, 6), 5)             "
            + "     ELSE RIGHT(t.account_code, 6)                       "
            + "   END contact,                                          "
            + "   '9' data_source,                                      "
            + "   SUM(IFNULL(t.appreciation_valuation,0)) floating_profit,            "
            + "   SUM(IFNULL(ABS(t.cost),0)) margin,                               "
            + "   SUM(CASE                "
            + "     WHEN t.cost > 0    "
            + "     THEN amount        "
            + "     ELSE 0             "
            + "   END )position_buy,   "
            + "   SUM(CASE             "
            + "     WHEN t.cost < 0    "
            + "     THEN amount        "
            + "     ELSE 0             "
            + "   END) position_sell,                                    "
            + "   t.market_value settlementPrice_today,                    "
            + "   NULL settlementPrice_yesterday,                       "
            + "   NULL ori_margin,                                      "
            + "   '1' market_type,                                      "
            + "   NULL position_cost,                                   "
            + "   NULL total_profit,                                    "
            + "   NULL market_capitalization,                           "
            + "   c.industry industry,                                  "
            + "   c.stock_type stock_type,                              "
            + "   c.variety_id variety_id,							   "
            + "   DATE_FORMAT(CURRENT_DATE(), '%Y%m%d')         "
            + " FROM                                                    "
            + "   t_fund_valuation_table t                              "
            + "   LEFT JOIN t_contract c                                "
            + "     ON c.contract =                                     "
            + "     CASE                                                "
            + "       WHEN LEFT(RIGHT(t.account_code, 6), 1) = '0'        "
            + "       THEN RIGHT(RIGHT(t.account_code, 6), 5)           "
            + "       ELSE RIGHT(t.account_code, 6)                     "
            + "     END                                                 "
            + "     AND c.date = t.date                                 "
            + " WHERE CHARACTER_LENGTH(t.account_code) > 8              "
            + "   AND (                                                 "
            + "     t.account_code LIKE '31020501%'                     "
            + "     OR t.account_code LIKE '31020601%'                  "
            + "     OR t.account_code LIKE '31020701%'                  "
            + "     OR t.account_code LIKE '31020801%'                  "
            + "     OR t.account_code LIKE '31023101%'                  "
            + "     OR t.account_code LIKE '31023201%'                  "
            + "   )                                                     "
            + "   AND t.product_id = :productId                         "
            + "   AND t.date = :date "
            + " group by  contact                               "
            + " UNION                                                   "
            + " ALL                                                     "
            + " SELECT                                                  "
            + "   '2' sh,                                               "
            + "   CASE                                                  "
            + "     WHEN t.cost > 0                                     "
            + "     THEN '0'                                            "
            + "     ELSE '1'                                            "
            + "   END bs,                                               "
            + "   NULL price_sell,                                      "
            + "   NULL price_buy,                                       "
            + "   :investerId invester_id,                              "
            + "   :brokerId broker_id,                                  "
            + "   t.date DATE,                                          "
            + "   RIGHT(t.account_code, 6) contact,                     "
            + "   '9' data_source,                                      "
            + "   SUM(IFNULL(t.appreciation_valuation,0)) floating_profit,            "
            + "   SUM(IFNULL(ABS(t.cost),0)) margin,                               "
            + "   SUM(CASE                "
            + "     WHEN t.cost > 0    "
            + "     THEN amount        "
            + "     ELSE 0             "
            + "   END )position_buy,   "
            + "   SUM(CASE             "
            + "     WHEN t.cost < 0    "
            + "     THEN amount        "
            + "     ELSE 0             "
            + "   END) position_sell,                                         "
            + "   t.market_value settlementPrice_today,                    "
            + "   NULL settlementPrice_yesterday,                       "
            + "   NULL ori_margin,                                      "
            + "   '2' market_type,                                      "
            + "   NULL position_cost,                                   "
            + "   NULL total_profit,                                    "
            + "   SUM(IFNULL(t.market_capitalization,0)) market_capitalization,       "
            + "   c.industry industry,                                  "
            + "   c.stock_type stock_type,                              "
            + "   c.variety_id variety_id,							   "
            + "   DATE_FORMAT(CURRENT_DATE(), '%Y%m%d')         "
            + " FROM                                                    "
            + "   t_fund_valuation_table t                              "
            + "   LEFT JOIN t_contract c                                "
            + "     ON c.contract = RIGHT(t.account_code, 6)            "
            + "     AND c.date = t.date                                 "
            + " WHERE CHARACTER_LENGTH(t.account_code) > 8              "
            + "   AND (t.account_code LIKE '1102%')                     "
            + "   AND t.product_id = :productId                         "
            + "   AND t.date = :date   "
            + "group by  contact         ", nativeQuery = true)
    public void savePositionSummaryFromValuation(@Param("investerId") String investerId,
                                                 @Param("brokerId") String brokerId, @Param("productId") String productId, @Param("date") String date);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "update PositionSummary set investerID = :investerID ,brokerID = :brokerId  where investerID = :qTIDInvesterID and date = :date and  marketType =:marketType")
    public void updateQTIDDatas(@Param("investerID") String investerID, @Param("brokerId") int brokerId,
                                @Param("qTIDInvesterID") String qTIDInvesterID, @Param("date") String date, @Param("marketType") String marketType);

    /**
     * 计算产品每日品种持仓盈亏
     */
    @Query(value = "SELECT s.date,r.product_id,s.contact,SUM(s.position_profit_market) "
            + "FROM t_position_summary s INNER JOIN t_product_invester_relationship r "
            + "ON s.invester_id = r.invester_id AND s.broker_id = r.broker_id "
            + "WHERE s.position_profit_market IS NOT NULL AND s.industry IS NOT NULL "
            + "AND (r.product_id = :productID or :productID is null) "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.market_type = '2' "
            + "GROUP BY s.date,r.product_id,s.contact "
            + "ORDER BY s.date,r.product_id,s.contact", nativeQuery = true)
    public List<Object[]> findStockFloatingProfitByFundIDAndDatePeriod(@Param("productID") Integer productID,
                                                                       @Param("startDate") String startDate, @Param("endDate") String endDate);

    /**
     * 计算产品每日持仓行业盈亏
     */
    @Query(value = "SELECT s.date,r.product_id,s.industry,SUM(s.position_profit_market) "
            + "FROM t_position_summary s INNER JOIN t_product_invester_relationship r "
            + "ON s.invester_id = r.invester_id AND s.broker_id = r.broker_id "
            + "WHERE s.position_profit_market IS NOT NULL "
            + "AND s.industry IS NOT NULL "
            + "AND (r.product_id = :productID or :productID is null) "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.market_type = '2' "
            + "GROUP BY s.date,r.product_id,s.industry "
            + "ORDER BY s.date,r.product_id,s.industry", nativeQuery = true)
    public List<Object[]> findIndustryFloatingProfitByFundIDAndDatePeriod(@Param("productID") Integer productID,
                                                                          @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = " SELECT DISTINCT                                    "
            + "   p.date                                           "
            + " FROM                                               "
            + "   t_position_summary p                             "
            + "   LEFT JOIN t_product_invester_relationship tp     "
            + "     ON p.invester_id = tp.invester_id              "
            + "     AND tp.broker_id = p.broker_id                 "
            + " WHERE tp.product_id = :productId                            "
            + "   AND (p.date >= :beginDate or :beginDate is null)                          "
            + "   AND (p.date <= :endDate or :endDate is null)", nativeQuery = true)
    public List<String> getPositionSummaryDates(@Param("productId") String productId,
                                                @Param("beginDate") String beginDate, @Param("endDate") String endDate);


    /**
     * 获取最新一天需要计算成交额的产品代码列表
     *
     * @param date
     * @return
     */
    @Query(value = "SELECT                                 "
            + " DISTINCT   CONCAT(product_id,'')                   "
            + " FROM                                   "
            + "   t_product_invester_relationship      "
            + " WHERE invester_id IN                   "
            + "   (SELECT                              "
            + "     t.invester_id                      "
            + "   FROM                                 "
            + "     t_position_summary t            "
            + "   WHERE t.date = :date              "
            + "   GROUP BY t.invester_id)              "
            + " GROUP BY product_id   ", nativeQuery = true)
    public List<String> getProductIdList(@Param("date") String date);


    /**
     * 根据资金账户及日期获取持仓汇总信息
     *
     * @param investerId
     * @param date
     * @param brokerId
     * @return
     */
    @Query(value = "select p from PositionSummary p where p.investerID = :investerId and p.date = :date and p.brokerID = :brokerId"
            + " and p.marketType =:marketType")
    public List<PositionSummary> findPositionSummaryByInvesterIdAndDateAndBrokerId(@Param("investerId") String investerId,
                                                                                   @Param("date") String date, @Param("brokerId") int brokerId, @Param("marketType") String marketType);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from PositionSummary i " + "where i.date=:date and (i.investerID=:investerID) and i.marketType =:marketType")
    public void delPositionSummary(@Param("date") String date, @Param("investerID") String investerID, @Param("marketType") String marketType);


    @Query(value = "SELECT pro.id productID,pos.date date,pos.industry industry "
            + "FROM ("
            + "SELECT p.id,r.invester_id,r.broker_id "
            + "FROM t_product p INNER JOIN t_product_invester_relationship r "
            + "ON p.id = r.product_id "
            + "AND p.id = :productID "
            + ") pro "
            + "INNER JOIN "
            + "(SELECT s.invester_id,s.broker_id,s.date,s.industry "
            + "FROM t_position_summary s "
            + "WHERE s.market_type = '2' AND s.industry IS NOT NULL "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null)"
            + "GROUP BY s.invester_id,s.broker_id,s.industry "
            + ") pos "
            + "ON pro.invester_id = pos.invester_id "
            + "AND pro.broker_id = pos.broker_id "
            + "order by pos.industry", nativeQuery = true)
    public List<Object[]> findIndustryByProAndDate(@Param("productID") String productID,
                                                   @Param("startDate") String startDate, @Param("endDate") String endDate);

    // <---------	计算组合收益率 ----------------->

    /**
     * 获取floatingProfit根据行业分类
     *
     * @return
     */
    @Query(value = "SELECT 														"
            + "  p.date DATE,                                                "
            + "  p.industry industry,                                        "
            + "  ROUND(SUM(IFNULL(p.position_profit_market, 0)),8) floatingProfit   "
            + "FROM                                                          "
            + "  t_position_summary p                                        "
            + "  LEFT JOIN t_product_invester_relationship tp                "
            + "    ON tp.invester_id = p.invester_id                         "
            + "    AND tp.broker_id = p.broker_id                            "
            + "WHERE                                                         "
            + "  p.industry IS NOT NULL                                      "
            + "  AND p.market_type = '2'                                     "
            + "  AND tp.product_id = :productId                              "
            + " GROUP BY p.date,p.industry   ", nativeQuery = true)
    public List<Object[]> findFloatingProfitByProductID(@Param("productId") String productId);

    /**
     * 获取总floatingProfit
     *
     * @return
     */
    @Query(value = "SELECT 														"
            + "  p.date DATE,                                                "
            + "  ROUND(SUM(IFNULL(p.position_profit_market, 0)),8) floatingProfit   "
            + "FROM                                                          "
            + "  t_position_summary p                                        "
            + "  LEFT JOIN t_product_invester_relationship tp                "
            + "    ON tp.invester_id = p.invester_id                         "
            + "    AND tp.broker_id = p.broker_id                            "
            + "WHERE                                                         "
            + "  p.industry IS NOT NULL                                      "
            + "  AND p.market_type = '2'                                     "
            + "  AND tp.product_id = :productId                              "
            + " GROUP BY p.date   ", nativeQuery = true)
    public List<Object[]> findTotalFloatingProfitByProductID(@Param("productId") String productId);

    // <---------	计算组合收益率END ----------------->

    // <---------	计算组合权重----------------->

    /**
     * 获取market_capitalization根据行业分类
     *
     * @return
     */
    @Query(value = "SELECT 														"
            + "  p.date DATE,                                                "
            + "  p.industry industry,                                        "
            + "  ROUND(SUM(IFNULL(p.market_capitalization, 0)),8) floatingProfit   "
            + "FROM                                                          "
            + "  t_position_summary p                                        "
            + "  LEFT JOIN t_product_invester_relationship tp                "
            + "    ON tp.invester_id = p.invester_id                         "
            + "    AND tp.broker_id = p.broker_id                            "
            + "WHERE                                                         "
            + "  p.industry IS NOT NULL                                      "
            + "  AND p.market_type = '2'                                     "
            + "  AND tp.product_id = :productId                              "
            + " GROUP BY p.date,p.industry   ", nativeQuery = true)
    public List<Object[]> findMarketCapitalizationByProductID(@Param("productId") String productId);

    /**
     * 获取总market_capitalization
     *
     * @return
     */
    @Query(value = "SELECT 														"
            + "  p.date DATE,                                                "
            + "  ROUND(SUM(IFNULL(p.market_capitalization, 0)),8) floatingProfit   "
            + "FROM                                                          "
            + "  t_position_summary p                                        "
            + "  LEFT JOIN t_product_invester_relationship tp                "
            + "    ON tp.invester_id = p.invester_id                         "
            + "    AND tp.broker_id = p.broker_id                            "
            + "WHERE                                                         "
            + "  p.industry IS NOT NULL                                      "
            + "  AND p.market_type = '2'                                     "
            + "  AND tp.product_id = :productId                              "
            + " GROUP BY p.date   ", nativeQuery = true)
    public List<Object[]> findTotalMarketCapitalizationByProductID(@Param("productId") String productId);

    // <---------	计算组合权重END ----------------->

    // <---------	计算盘型价值----------------->
    @Query(value = "SELECT 										"
            + "  p.date date,                                "
            + "  COUNT(p.contact) countValue                 "
            + "FROM                                          "
            + " t_position_summary p                         "
            + " LEFT JOIN t_product_invester_relationship tp "
            + "    ON p.invester_id = tp.invester_id         "
            + "    AND p.broker_id = tp.broker_id            "
            + "  LEFT JOIN t_contract c                      "
            + "    ON p.date = c.date                        "
            + "    AND c.contract = p.contact                "
            + "WHERE p.market_type = '2'                     "
            + "  AND p.industry IS NOT NULL                  "
            + "  AND tp.product_id = :productId              "
            + "  AND c.stock_type = :stockType               "
            + "  AND c.stock_growth_value = :growthValueType "
            + "GROUP BY p.date; ", nativeQuery = true)
    public List<Object[]> findValueGrowthByProductId(@Param("productId") String productId, @Param("stockType") String stockType,
                                                     @Param("growthValueType") String growthValueType);
    // <---------	计算盘型价值END----------------->

    /**
     * 计算产品每日债券市值
     */
    @Query(value = "SELECT p.date,p.contact,SUM(p.market_capitalization) market_capitalization,b.value_date,b.due_date,b.interest_rate_type,b.bond_type "
            + "FROM t_position_summary p "
            + "LEFT JOIN t_bond b ON p.contact = b.bond_id "
            + "LEFT JOIN t_product_invester_relationship r ON p.invester_id = r.invester_id AND p.broker_id = r.broker_id "
            + "WHERE p.market_type = :marketType AND b.bond_id IS NOT NULL "
            + "AND (r.product_id = :productID OR :productID IS NULL) "
            + "AND (p.date >= :startDate OR :startDate IS NULL)  AND (p.date <= :endDate OR :endDate IS NULL) "
            + "GROUP BY p.date,p.contact "
            + "ORDER BY p.date,p.contact", nativeQuery = true)
    public List<Object[]> findProductBondMarketValueByIDAndDatePeriod(@Param("productID") Integer productID,
                                                                      @Param("startDate") String startDate, @Param("endDate") String endDate,
                                                                      @Param("marketType") String marketType);

    /**
     * 取得产品每日债券市值
     */
    @Query(value = "SELECT p.date,p.contact,SUM(p.market_capitalization) market_capitalization "
            + "FROM t_position_summary p "
            + "LEFT JOIN t_product_invester_relationship r ON p.invester_id = r.invester_id AND p.broker_id = r.broker_id "
            + "WHERE p.market_type = :marketType "
            + "AND (r.product_id = :productID OR :productID IS NULL) "
            + "AND (p.date >= :startDate OR :startDate IS NULL)  AND (p.date <= :endDate OR :endDate IS NULL) "
            + "GROUP BY p.date,p.contact "
            + "ORDER BY p.date,p.contact", nativeQuery = true)
    public List<Object[]> findProductBondMarketValueByIDAndDate(@Param("productID") Integer productID,
                                                                @Param("startDate") String startDate, @Param("endDate") String endDate,
                                                                @Param("marketType") String marketType);

    /**
     * 计算产品每日债券市值
     */
    @Query(value = "SELECT p.date,p.contact,SUM(p.market_capitalization) market_capitalization,p.price_buy,b.value_date,b.due_date,b.coupon_rate,b.pay_interest_frequency "
            + "FROM t_position_summary p "
            + "LEFT JOIN t_bond b ON p.contact = b.bond_id "
            + "LEFT JOIN t_product_invester_relationship r ON p.invester_id = r.invester_id AND p.broker_id = r.broker_id "
            + "WHERE p.market_type = :marketType AND b.bond_id IS NOT NULL "
            + "AND (r.product_id = :productID OR :productID IS NULL) "
            + "AND (p.date >= :startDate OR :startDate IS NULL)  AND (p.date <= :endDate OR :endDate IS NULL) "
            + "GROUP BY p.contact,p.date "
            + "ORDER BY p.contact,p.date", nativeQuery = true)
    public List<Object[]> findProductBondByIDAndDateOrderByContact(@Param("productID") Integer productID,
                                                                   @Param("startDate") String startDate, @Param("endDate") String endDate,
                                                                   @Param("marketType") String marketType);


    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_position_summary(sh,bs,price_sell,price_buy,invester_id," +
            "broker_id,date,update_date,contact,data_source,floating_profit,margin," +
            "position_buy,position_sell,settlementPrice_today,settlementPrice_yesterday," +
            "ori_margin,market_type,position_cost,total_profit,market_capitalization," +
            "industry,stock_type,variety_id,position_profit_market,long_option_market_value," +
            "short_option_market_value,total_expense) values(:sh,:bs,:priceSell,:priceBuy,:investerId," +
            ":brokerId,:date,:updateDate,:contact,:datasource,:floatingProfit," +
            ":margin,:positionBuy,:positionSell,:settlementPriceToday,:settlementPriceYesterday," +
            ":oriMargin,:marketType,:positionCost,:totalProfit,:marketCapitalization," +
            ":industry,:stockType,:varietyId,:positionProfitMarket,:longOptionMarketValue," +
            ":shortOptionMarketValue,:totalExpense)", nativeQuery = true)
    public void insert(@Param("sh") int sh, @Param("bs") int bs, @Param("priceSell") BigDecimal priceSell, @Param("priceBuy") BigDecimal priceBuy,
                       @Param("investerId") String investerId, @Param("brokerId") int brokerId, @Param("date") String date, @Param("updateDate") String updateDate,
                       @Param("contact") String contact, @Param("datainterface") int datasource, @Param("floatingProfit") BigDecimal floatingProfit,
                       @Param("margin") BigDecimal margin, @Param("positionBuy") int positionBuy, @Param("positionSell") int positionSell,
                       @Param("settlementPriceToday") BigDecimal settlementPriceToday, @Param("settlementPriceYesterday") BigDecimal settlementPriceYesterday,
                       @Param("oriMargin") BigDecimal oriMargin, @Param("marketType") String marketType, @Param("positionCost") BigDecimal positionCost,
                       @Param("totalProfit") BigDecimal totalProfit, @Param("marketCapitalization") BigDecimal marketCapitalization,
                       @Param("industry") String industry, @Param("stockType") String stockType, @Param("varietyId") String varietyId,
                       @Param("positionProfitMarket") BigDecimal positionProfitMarket, @Param("longOptionMarketValue") BigDecimal longOptionMarketValue,
                       @Param("shortOptionMarketValue") BigDecimal shortOptionMarketValue, @Param("totalExpense") String totalExpense);
}
