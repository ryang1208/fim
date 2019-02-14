package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FundValuation;
import com.huaxin.fim.entity.entity.PositionSummary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 基金产品估值表
 *
 * @author liumd
 */
@Repository(value = "fundValuationTableRepository")
@EntityClass(entityClass = FundValuation.class)
@Forbid(forbiddenMethods = {"deleteAll"})
public interface FundValuationTableRepository extends CrudRepository<FundValuation, Long> {

    /**
     * 删除产品估值表（业务）
     *
     * @param date
     * @param productId
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from FundValuation p "
            + "where p.date=:date and p.productId=:productId")
    public void delByDateAndProductId(@Param("date") String date, @Param("productId") String productId);


    /**
     * 插入产品估值表（业务）
     *
     * @param level(科目级别)
     * @param accountCodelength（科目代码长度）
     * @param productId
     * @param dataSource
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_fund_valuation_table (        "
            + "   date,                                        "
            + "   product_id,                                  "
            + "   data_source,                                 "
            + "   account_code,                                "
            + "   account_name,                                "
            + "   amount,                                      "
            + "   unit_cost,                                   "
            + "   cost,                                        "
            + "   net_value_cost_ratio,                        "
            + "   market_value,                                "
            + "   market_capitalization,                       "
            + "   net_value_market_capitalization_value,       "
            + "   appreciation_valuation,                      "
            + "   stock_suspension_message,                    "
            + "   first_class_account_code,                   "
            + "   first_class_account_name,                    "
            + "   second_class_account_code,                   "
            + "   second_class_account_name,                   "
            + "   third_class_account_code,                    "
            + "   third_class_account_name,					  "
            + "   update_date,								  "
            + "   trustee_id								  "
            + " )                                              "
            + "select 															"
            + "  DATE_FORMAT(t.ywrq, '%Y%m%d') date,                            "
            + "  :productId productId,                                          "
            + "  :dataSource dataSource,                                        "
            + "  t.kmdm kmdm,                                                      "
            + "  t.kmmc kmmc,                                                      "
            + "  t.sl,                                                          "
            + "  t.dwcb,                                                        "
            + "  t.cb,                                                          "
            + "  t.cbzjz,                                                       "
            + "  t.hqjz,                                                        "
            + "  t.sz,                                                          "
            + "  t.szzjz,                                                       "
            + "  t.gzzz,                                                        "
            + "  t.stock_suspension_message,                                    "
            + "  case                                                           "
            + "    when :accountCodeLevel > 1                                   "
            + "    then left(t.kmdm, 4)                                         "
            + "    else null                                                    "
            + "  end firstCode,                                                "
            + "  CASE                                                           "
            + "    WHEN :accountCodeLevel > 1                                   "
            + "    THEN firstTemp.kmmc                                             "
            + "    else null                                                    "
            + "  END firstName,                                                "
            + "  case                                                           "
            + "    when :accountCodeLevel > 2                                   "
            + "    then left(t.kmdm, 6)                                         "
            + "    else null                                                    "
            + "  end secondCode,                                                 "
            + "  CASE                                                           "
            + "    WHEN :accountCodeLevel > 2                                   "
            + "    THEN secondTemp.kmmc "
            + "    else null                                            "
            + "  END secondName,                                                 "
            + "  case                                                           "
            + "    when :accountCodeLevel > 3                                   "
            + "    then left(t.kmdm, 8)                                        "
            + "    else null                                                    "
            + "  end thirdCode,                                                  "
            + "  CASE                                                           "
            + "    WHEN :accountCodeLevel > 3                                   "
            + "    THEN thirdTemp.kmmc    "
            + "    else null                                          "
            + "  END thirdName,"
            + "	 DATE_FORMAT(CURRENT_DATE(), '%Y%m%d') ,"
            + "  t.trustee_id                "
            + "from                                                             "
            + "  t_raw_xin_fund_asset t   "
            + " LEFT JOIN                             "
            + "   (SELECT                             "
            + "     a.kmmc,                           "
            + "     a.kmdm                            "
            + "   FROM                                "
            + "     t_raw_xin_fund_asset a            "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 5  "
            + "     AND a.kmdm IS NOT NULL            "
            + "     AND a.kmdm <> ''                  "
            + "     AND ASCII(a.kmdm) < 127           "
            + "  and a.ywrq = :date     "
            + "  and a.product_id = :productId   "
            + "   GROUP BY a.kmdm) firstTemp          "
            + "   ON firstTemp.kmdm = LEFT(t.kmdm, 4) "
            + " LEFT JOIN                             "
            + "   (SELECT                             "
            + "     a.kmmc,                           "
            + "     a.kmdm                            "
            + "   FROM                                "
            + "     t_raw_xin_fund_asset a            "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 7  "
            + "     AND a.kmdm IS NOT NULL            "
            + "     AND a.kmdm <> ''                  "
            + "     AND ASCII(a.kmdm) < 127           "
            + "  and a.ywrq = :date     "
            + "  and a.product_id = :productId   "
            + "   GROUP BY a.kmdm) secondTemp         "
            + "   ON secondTemp.kmdm = LEFT(t.kmdm, 6)"
            + " LEFT JOIN                             "
            + "   (SELECT                             "
            + "     a.kmmc,                           "
            + "     a.kmdm                            "
            + "   FROM                                "
            + "     t_raw_xin_fund_asset a            "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 9  "
            + "     AND a.kmdm IS NOT NULL            "
            + "     AND a.kmdm <> ''                  "
            + "     AND ASCII(a.kmdm) < 127           "
            + "  and a.ywrq = :date     "
            + "  and a.product_id = :productId   "
            + "   GROUP BY a.kmdm) thirdTemp          "
            + "   ON thirdTemp.kmdm = LEFT(t.kmdm, 8) "
            + "where ascii(t.kmdm) < 127                                        "
            + "  and t.kmdm is not null                                         "
            + "  and t.kmdm <> ''                                               "
            + "  and CHARACTER_LENGTH(t.kmdm) = :accountCodelength    "
            + "  and t.ywrq = :date     "
            + "  and t.product_id = :productId   ", nativeQuery = true)
    public void saveFundValuation(@Param("accountCodeLevel") int level,
                                  @Param("accountCodelength") int accountCodelength,
                                  @Param("productId") String productId,
                                  @Param("dataSource") int dataSource,
                                  @Param("date") String date);

    /**
     * 插入产品估值表（业务）-特殊格式处理
     *
     * @param productId
     * @param dataSource
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_fund_valuation_table (        "
            + "   date,                                        "
            + "   product_id,                                  "
            + "   data_source,                                 "
            + "   account_code,                                "
            + "   account_name,                                "
            + "   amount,                                      "
            + "   unit_cost,                                   "
            + "   cost,                                        "
            + "   net_value_cost_ratio,                        "
            + "   market_value,                                "
            + "   market_capitalization,                       "
            + "   net_value_market_capitalization_value,       "
            + "   appreciation_valuation,                      "
            + "   stock_suspension_message,                    "
            + "   first_class_account_code,                   "
            + "   first_class_account_name,                    "
            + "   second_class_account_code,                   "
            + "   second_class_account_name,                   "
            + "   third_class_account_code,                    "
            + "   third_class_account_name,					  "
            + "   update_date,								  "
            + "   trustee_id								  "
            + " )                                              "
            + "SELECT 													 "
            + "  DATE_FORMAT(t.ywrq, '%Y%m%d') DATE,                      "
            + "  :productId productId,                                    "
            + "  :dataSource dataSource,                                  "
            + "  t.kmdm kmdm,                                             "
            + "  t.kmmc kmmc,                                             "
            + "  t.sl,                                                    "
            + "  t.dwcb,                                                  "
            + "  t.cb,                                                    "
            + "  t.cbzjz,                                                 "
            + "  t.hqjz,                                                  "
            + "  t.sz,                                                    "
            + "  t.szzjz,                                                 "
            + "  t.gzzz,                                                  "
            + "  t.stock_suspension_message,                              "
            + "  CASE                                                     "
            + "    WHEN 2 > 1                                             "
            + "    THEN LEFT(t.kmdm, 4)                                   "
            + "    ELSE NULL                                              "
            + "  END firstCode,                                           "
            + "  CASE                                                     "
            + "    WHEN 2 > 1                                             "
            + "    THEN firstTemp.kmmc                                    "
            + "    ELSE NULL                                              "
            + "  END firstName,                                           "
            + "  CASE                                                     "
            + "    WHEN 2 > 2                                             "
            + "    THEN LEFT(t.kmdm, 6)                                   "
            + "    ELSE NULL                                              "
            + "  END secondCode,                                          "
            + "  CASE                                                     "
            + "    WHEN 2 > 2                                             "
            + "    THEN secondTemp.kmmc                                   "
            + "    ELSE NULL                                              "
            + "  END secondName,                                          "
            + "  CASE                                                     "
            + "    WHEN 2 > 3                                             "
            + "    THEN LEFT(t.kmdm, 8)                                   "
            + "    ELSE NULL                                              "
            + "  END thirdCode,                                           "
            + "  CASE                                                     "
            + "    WHEN 2 > 3                                             "
            + "    THEN thirdTemp.kmmc                                    "
            + "    ELSE NULL                                              "
            + "  END thirdName,                                           "
            + "	 DATE_FORMAT(CURRENT_DATE(), '%Y%m%d') ,                 "
            + "  t.trustee_id                                             "
            + "FROM                                                       "
            + "  t_raw_xin_fund_asset t                                   "
            + " LEFT JOIN                                                 "
            + "   (SELECT                                                 "
            + "     a.kmmc,                                               "
            + "     a.kmdm                                                "
            + "   FROM                                                    "
            + "     t_raw_xin_fund_asset a                                "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 5                      "
            + "     AND a.kmdm IS NOT NULL                                "
            + "     AND a.kmdm <> ''                                      "
            + "     AND ASCII(a.kmdm) < 127                               "
            + "  AND a.ywrq = :DATE                                       "
            + "  AND a.product_id = :productId                            "
            + "   GROUP BY a.kmdm) firstTemp                              "
            + "   ON firstTemp.kmdm = LEFT(t.kmdm, 4)                     "
            + " LEFT JOIN                                                 "
            + "   (SELECT                                                 "
            + "     a.kmmc,                                               "
            + "     a.kmdm                                                "
            + "   FROM                                                    "
            + "     t_raw_xin_fund_asset a                                "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 7                      "
            + "     AND a.kmdm IS NOT NULL                                "
            + "     AND a.kmdm <> ''                                      "
            + "     AND ASCII(a.kmdm) < 127                               "
            + "  AND a.ywrq = :DATE                                       "
            + "  AND a.product_id = :productId                            "
            + "   GROUP BY a.kmdm) secondTemp                             "
            + "   ON secondTemp.kmdm = LEFT(t.kmdm, 6)                    "
            + " LEFT JOIN                                                 "
            + "   (SELECT                                                 "
            + "     a.kmmc,                                               "
            + "     a.kmdm                                                "
            + "   FROM                                                    "
            + "     t_raw_xin_fund_asset a                                "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 9                      "
            + "     AND a.kmdm IS NOT NULL                                "
            + "     AND a.kmdm <> ''                                      "
            + "     AND ASCII(a.kmdm) < 127                               "
            + "  AND a.ywrq = :DATE                                       "
            + "  AND a.product_id = :productId                            "
            + "   GROUP BY a.kmdm) thirdTemp                              "
            + "   ON thirdTemp.kmdm = LEFT(t.kmdm, 8)                     "
            + "WHERE ASCII(t.kmdm) < 127                                  "
            + "  AND t.kmdm IS NOT NULL                                   "
            + "  AND t.kmdm <> ''                                         "
            + "  AND CHARACTER_LENGTH(t.kmdm) NOT IN (4,6,8,13,14,15,17)  "
            + "  AND t.ywrq = :DATE                                       "
            + "  AND t.product_id = :productId  	                         ", nativeQuery = true)
    public void saveFundValuationException(@Param("productId") String productId,
                                           @Param("dataSource") int dataSource,
                                           @Param("DATE") String date);


    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "insert into t_fund_valuation_table (        "
            + "   date,                                        "
            + "   product_id,                                  "
            + "   data_source,                                 "
            + "   account_code,                                "
            + "   account_name,                                "
            + "   amount,                                      "
            + "   unit_cost,                                   "
            + "   cost,                                        "
            + "   net_value_cost_ratio,                        "
            + "   market_value,                                "
            + "   market_capitalization,                       "
            + "   net_value_market_capitalization_value,       "
            + "   appreciation_valuation,                      "
            + "   stock_suspension_message,                    "
            + "   first_class_account_code,                   "
            + "   first_class_account_name,                    "
            + "   second_class_account_code,                   "
            + "   second_class_account_name,                   "
            + "   third_class_account_code,                    "
            + "   third_class_account_name,					  "
            + "   update_date,								  "
            + "   trustee_id								  "
            + " )                                              "
            + "SELECT 													 "
            + "  DATE_FORMAT(t.ywrq, '%Y%m%d') DATE,                      "
            + "  :productId productId,                                    "
            + "  :dataSource dataSource,                                  "
            + "  t.kmdm kmdm,                                             "
            + "  t.kmmc kmmc,                                             "
            + "  t.sl,                                                    "
            + "  t.dwcb,                                                  "
            + "  t.cb,                                                    "
            + "  t.cbzjz,                                                 "
            + "  t.hqjz,                                                  "
            + "  t.sz,                                                    "
            + "  t.szzjz,                                                 "
            + "  t.gzzz,                                                  "
            + "  t.stock_suspension_message,                              "
            + "  CASE                                                     "
            + "    WHEN 2 > 1                                             "
            + "    THEN LEFT(t.kmdm, 4)                                   "
            + "    ELSE NULL                                              "
            + "  END firstCode,                                           "
            + "  CASE                                                     "
            + "    WHEN 2 > 1                                             "
            + "    THEN firstTemp.kmmc                                    "
            + "    ELSE NULL                                              "
            + "  END firstName,                                           "
            + "  CASE                                                     "
            + "    WHEN 2 > 2                                             "
            + "    THEN LEFT(t.kmdm, 6)                                   "
            + "    ELSE NULL                                              "
            + "  END secondCode,                                          "
            + "  CASE                                                     "
            + "    WHEN 2 > 2                                             "
            + "    THEN secondTemp.kmmc                                   "
            + "    ELSE NULL                                              "
            + "  END secondName,                                          "
            + "  CASE                                                     "
            + "    WHEN 2 > 3                                             "
            + "    THEN LEFT(t.kmdm, 8)                                   "
            + "    ELSE NULL                                              "
            + "  END thirdCode,                                           "
            + "  CASE                                                     "
            + "    WHEN 2 > 3                                             "
            + "    THEN thirdTemp.kmmc                                    "
            + "    ELSE NULL                                              "
            + "  END thirdName,                                           "
            + "	 DATE_FORMAT(CURRENT_DATE(), '%Y%m%d') ,                 "
            + "  t.trustee_id                                             "
            + "FROM                                                       "
            + "  t_raw_fund_valuation t                                   "
            + " LEFT JOIN                                                 "
            + "   (SELECT                                                 "
            + "     a.kmmc,                                               "
            + "     a.kmdm                                                "
            + "   FROM                                                    "
            + "     t_raw_fund_valuation a                                "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 5                      "
            + "     AND a.kmdm IS NOT NULL                                "
            + "     AND a.kmdm <> ''                                      "
            + "     AND ASCII(a.kmdm) < 127                               "
            + "  AND a.ywrq = :DATE                                       "
            + "  AND a.product_id = :productId                            "
            + "   GROUP BY a.kmdm,a.kmmc) firstTemp                              "
            + "   ON firstTemp.kmdm = LEFT(t.kmdm, 4)                     "
            + " LEFT JOIN                                                 "
            + "   (SELECT                                                 "
            + "     a.kmmc,                                               "
            + "     a.kmdm                                                "
            + "   FROM                                                    "
            + "     t_raw_fund_valuation a                                "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 7                      "
            + "     AND a.kmdm IS NOT NULL                                "
            + "     AND a.kmdm <> ''                                      "
            + "     AND ASCII(a.kmdm) < 127                               "
            + "  AND a.ywrq = :DATE                                       "
            + "  AND a.product_id = :productId                            "
            + "   GROUP BY a.kmdm,a.kmmc) secondTemp                             "
            + "   ON secondTemp.kmdm = LEFT(t.kmdm, 6)                    "
            + " LEFT JOIN                                                 "
            + "   (SELECT                                                 "
            + "     a.kmmc,                                               "
            + "     a.kmdm                                                "
            + "   FROM                                                    "
            + "     t_raw_fund_valuation a                                "
            + "   WHERE CHARACTER_LENGTH(a.kmdm) < 9                      "
            + "     AND a.kmdm IS NOT NULL                                "
            + "     AND a.kmdm <> ''                                      "
            + "     AND ASCII(a.kmdm) < 127                               "
            + "  AND a.ywrq = :DATE                                       "
            + "  AND a.product_id = :productId                            "
            + "   GROUP BY a.kmdm,a.kmmc) thirdTemp                              "
            + "   ON thirdTemp.kmdm = LEFT(t.kmdm, 8)                     "
            + "WHERE ASCII(t.kmdm) < 127                                  "
            + "  AND t.kmdm IS NOT NULL                                   "
            + "  AND t.kmdm <> ''                                         "
            + "  AND CHARACTER_LENGTH(t.kmdm) NOT IN (4,6,8,13,14,15,17)  "
            + "  AND t.ywrq = :DATE                                       "
            + "  AND t.product_id = :productId  	                         ", nativeQuery = true)
    public void saveFundValuation(@Param("productId") String productId,
                                  @Param("dataSource") int dataSource,
                                  @Param("DATE") String date
    );


    @Query(value = "SELECT s.date,s.product_id,s.industry,SUM(s.market_capitalization) "
            + "FROM t_fund_valuation_table s "
            + "WHERE s.industry IS NOT NULL AND s.market_capitalization IS NOT NULL "
            + "AND (s.product_id = :productID or :productID is null) "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.first_class_account_code = '1102' AND s.third_class_account_code IS NOT NULL "
            + "GROUP BY s.date,s.product_id,s.industry "
            + "ORDER BY s.date,s.product_id,s.industry", nativeQuery = true)
    public List<Object[]> findIndustryMarketValueByFundIDAndDatePeriod(@Param("productID") String productID,
                                                                       @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT s.date,s.product_id,SUM(s.market_capitalization) "
            + "FROM t_fund_valuation_table s "
            + "WHERE s.market_capitalization IS NOT NULL "
            + "AND (s.product_id = :productID or :productID is null) "
            + "AND (s.date >= :startDate or :startDate is null) "
            + "AND (s.date <= :endDate or :endDate is null) "
            + "AND s.account_code = '1102' AND s.first_class_account_code IS NULL "
            + "GROUP BY s.date,s.product_id "
            + "ORDER BY s.date,s.product_id", nativeQuery = true)
    public List<Object[]> findStockMarketValueByFundIDAndDatePeriod(@Param("productID") String productID,
                                                                    @Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "select new com.quantdo.iwin.entity.PositionSummary(v.date,substring(v.accountCode,9,length(v.thirdClassAccountCode)),"
            + "'',v.marketCapitalization,v.industry,'','t_fund_valuation_table',v.productId) "
            + "from FundValuation v "
            + "where v.firstClassAccountCode = '1102' and v.thirdClassAccountCode is not null "
            + "and v.marketCapitalization is not null "
            + "and (v.date >= :startDate or :startDate is null) "
            + "and (v.date <= :endDate or :endDate is null) "
            + "and (v.productId = :productID or :productID is null)")
    public List<PositionSummary> findstockDatasByFundIDAndDatePeriod(@Param("productID") String productID,
                                                                     @Param("startDate") String startDate, @Param("endDate") String endDate);


    /**
     * 更新估值表的行业信息
     */
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "UPDATE 											"
            + "   t_fund_valuation_table a                       "
            + " SET                                              "
            + "   a.industry = (                                 "
            + "   SELECT                                         "
            + "     c.industry                                   "
            + "   FROM                                           "
            + "     t_contract c                                 "
            + "   WHERE CHARACTER_LENGTH(a.account_code) >= 6    "
            + "     AND RIGHT(a.account_code, 6) = c.contract    "
            + "    and c.date = :date )"
            + "  where a.date = :date and a.product_id=:productId ", nativeQuery = true)
    public void updateValuationTable(@Param("date") String date, @Param("productId") String productId);

    @Query(value = "select new com.quantdo.iwin.entity.FundValuation(f.date,f.productId,sum(f.marketCapitalization)) "
            + "from FundValuation f "
            + "where f.marketCapitalization is not null "
            + "and f.accountCode in :accountCodes "
            + "and (f.productId = :productID or :productID is null) "
            + "and (f.date >= :startDate or :startDate is null) "
            + "and (f.date <= :endDate or :endDate is null) "
            + "group by f.date,f.productId "
            + "order by f.date,f.productId")
    public List<FundValuation> findAssetMarketValueByAccountCodes(@Param("productID") String productID,
                                                                  @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("accountCodes") List<String> accountCodes);


    /**
     * 查询估值表中经纪公司
     *
     * @param productId
     * @param date
     * @return
     */
    @Query(value = "SELECT t.account_name FROM t_fund_valuation_table t"
            + " WHERE t.second_class_account_code = '103113' AND t.product_id=:productId AND t.date=:date", nativeQuery = true)
    public List<String> getBrokerName(@Param("productId") String productId, @Param("date") String date);

    /**
     * 查询估值表当天产品ID
     *
     * @param date
     * @return
     */
    @Query(value = "SELECT distinct  CONCAT(t.product_id,'') FROM t_fund_valuation_table t WHERE t.date=:date", nativeQuery = true)
    public List<String> getProductIdList(@Param("date") String date);

    /**
     * 股指期货净头寸市值占净值
     *
     * @param
     * @return
     */
    @Query(value = " SELECT t.date date,f.net_value_market_capitalization_value a,v.net_value_market_capitalization_value b,c.net_value_market_capitalization_value c,  "
            + "t.net_value_market_capitalization_value d                                                                                                         "
            + " FROM t_fund_valuation_table  t                                                                                                                    "
            + " LEFT JOIN (SELECT t.product_id,t.date, t.net_value_market_capitalization_value FROM t_fund_valuation_table  t WHERE t.account_code='31020101' ) f "
            + " ON f.product_id = t.product_id AND f.date=t.date                                                                                                  "
            + " LEFT JOIN (SELECT t.product_id,t.date, t.net_value_market_capitalization_value FROM t_fund_valuation_table  t WHERE t.account_code='31020201' ) v "
            + " ON v.product_id = t.product_id AND v.date=t.date                                                                                                  "
            + " LEFT JOIN (SELECT t.product_id,t.date, t.net_value_market_capitalization_value FROM t_fund_valuation_table  t WHERE t.account_code='31020301' ) c "
            + " ON c.product_id = t.product_id AND c.date=t.date                                                                                                  "
            + " WHERE t.account_code='31020401'                                                                                                                   "
            + " AND t.product_id = :productId                                                                                                                     "
            + " ORDER BY t.date                                                                                                                                   ", nativeQuery = true)
    public List<Object[]> getNetValueCapitalizationValue(@Param("productId") String productId);

    /**
     * 股票投资市值占净值
     *
     * @param
     * @return
     */
    @Query(value = "select f from FundValuation f where f.productId = :productId and (f.accountCode = 1102)")
    public List<FundValuation> findNetValueofStockInvestment(@Param("productId") String productId);

    /**
     * 股指期货净头寸市值占净值
     *
     * @param
     * @return
     */
    @Query(value = "(SELECT 										    "
            + "  t.date,                                             "
            + "  t.net_value_market_capitalization_value netValue,   "
            + "  k.today kToday                                      "
            + "FROM                                                  "
            + "  t_fund_valuation_table t                            "
            + "  LEFT JOIN                                           "
            + "    (SELECT                                           "
            + "      tp.date,                                        "
            + "      tp.product_id,                                  "
            + "      tp.today                                        "
            + "    FROM                                              "
            + "      t_product_period_kpi_statistics tp              "
            + "    WHERE tp.KPI = :kpiCode) k                        "
            + "    ON t.product_id = k.product_id                    "
            + "    AND t.date = k.date                               "
            + "WHERE t.product_id = :productId                       "
            + "  AND (t.account_code = 1102)                         "
            + "  AND (t.date >= :beginDate OR :beginDate IS NULL)    "
            + "ORDER BY t.date)                                      "
            + "UNION (                                           "
            + "SELECT                                                "
            + "  t.date,                                             "
            + "  k.net_value_market_capitalization_value netValue,   "
            + "  t.today kToday                                      "
            + "FROM                                                  "
            + "  t_product_period_kpi_statistics t                   "
            + "  LEFT JOIN                                           "
            + "    (SELECT                                           "
            + "      tp.date,                                        "
            + "      tp.product_id,                                  "
            + "      tp.net_value_market_capitalization_value        "
            + "    FROM                                              "
            + "      t_fund_valuation_table tp                       "
            + "    WHERE tp.account_code = 1102) k                   "
            + "    ON t.product_id = k.product_id                    "
            + "    AND t.date = k.date                               "
            + "WHERE t.product_id = :productId                       "
            + "  AND (t.KPI = :kpiCode)                              "
            + "  AND (t.date >= :beginDate OR :beginDate IS NULL)    "
            + "ORDER BY t.date)                                      ", nativeQuery = true)
    public List<Object[]> getNetValueMarketCapitalizationValue(@Param("productId") String productId, @Param("kpiCode") String kpiCode,
                                                               @Param("beginDate") String beginDate);

    /**
     * 子基金估值表数据
     *
     * @param
     * @return
     */
    @Query(value = "select distinct f.date from FundValuation f where f.productId in :productIds ")
    public List<FundValuation> findFundValuationByProductIds(@Param("productIds") List<String> productIds);

    /**
     * 子基金债券市值
     *
     * @param
     * @return
     */
    @Query(value = "SELECT r.product_id,p.date,b.bond_name,p.market_capitalization FROM t_position_summary p "
            + "LEFT JOIN t_product_invester_relationship r                                              "
            + "ON p.invester_id = r.invester_id AND p.broker_id = r.broker_id                           "
            + "LEFT JOIN t_bond b                                                                       "
            + "ON b.bond_id=p.contact                                                                   "
            + "WHERE r.product_id IN(:productIds)                                                       "
            + "AND p.contact IN(SELECT b.bond_id FROM t_bond b)                                         "
            + "AND (p.date =:date or :date is NULL )                                                    "
            + "AND p.market_capitalization IS NOT NULL 												   "
            + "GROUP BY p.contact,r.product_id                                                          ", nativeQuery = true)
    public List<Object[]> getBondMarketValue(@Param("productIds") List<String> productIds,
                                             @Param("date") String date);

}
