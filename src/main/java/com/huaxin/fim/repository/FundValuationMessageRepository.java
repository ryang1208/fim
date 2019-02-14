package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.FundValuationMessage;
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
 * @author liumd
 *
 */
@Repository(value = "fundValuationMessageRepository")
@EntityClass(entityClass = FundValuationMessage.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface FundValuationMessageRepository extends CrudRepository<FundValuationMessage, Long> {
	
	
	@Query(value="SELECT new com.quantdo.iwin.entity.FundValuationMessage(t.productId, MAX(t.date)) "
			+ "FROM FundValuationMessage t WHERE t.type='基金资产净值' "
			+ "GROUP BY t.productId")
	public List<FundValuationMessage> findByProductId();
	
	/**
	 * 删除产品估值信息表（业务）
	 * @param date
	 * @param productId
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from FundValuationMessage p "
			+ "where p.date=:date and p.productId=:productId")
	public void delMegByDateAndProductId(@Param("date") String date, @Param("productId") String productId);

	/**
	 * 保存基金产品估值详细信息表(业务)
	 * @param productId
	 * @param dataSource
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" insert into "
			+ "t_fund_valuation_message(                       "
			+"   date,                                                     "
			+"   product_id,                                               "
			+"   data_source,                                              "
			+"   type,                                                     "
			+"   value,                                                    "
			+"   market_value,                                             "
			+"   appreciation_valuation,                                   "
			+"   propportion,"
			+"   update_date ,                                              "
			+"   trustee_id                                               "
			+" )                                                           "
			+" SELECT                                                      "
			+"   DATE_FORMAT(a.ywrq, '%Y%m%d') DATE,                       "
			+ "  :productId productId,                                          "
			+ "  :dataSource dataSource,                                        "
			+"   REPLACE(a.kmdm, ':', '') TYPE,                            "
			+"   CASE                                                      "
			+"     WHEN LOCATE('净值',  REPLACE((a.kmdm),',','')) > 0      "
			+"     OR a.kmdm = '本年已实现收益:'                           "
			+"     OR a.kmdm = '本月已实现收益:'                           "
			+"     OR a.kmdm = '从成立日开始的累计已实现收益:'             "
			+"     OR a.kmdm = '可分配利润:'                               "
			+"     OR a.kmdm = '单位可分配利润:'                           "
			+"     THEN REPLACE(a.kmmc,',','')     "
			+"     ELSE REPLACE(a.cb,',','') "
			+"   END VALUE,                                                "
			+"   a.sz marketValue,                                         "
			+"   a.gzzz appreciationValuation,                             "
			+"   CASE                                                      "
			+"     WHEN a.kmdm = '证券投资合计:'                           "
			+"     THEN a.sl                                               "
			+"    ELSE NULL                                "
			+"   END propportion,"
			+"   (SELECT DATE_FORMAT(NOW(), '%Y%m%d') FROM DUAL)  ,"
			+ " a.trustee_id         "
			+" FROM                                                        "
			+"   t_raw_xin_fund_asset a                                    "
			+" WHERE (                                                     "
			+"     LOCATE(':', a.kmdm) = CHAR_LENGTH(a.kmdm)               "
			+"     OR LOCATE(':', a.kmdm) = 0                              "
			+"   )                                                         "
			+"   AND ASCII(a.kmdm) >= 127  "
			+ "  and a.ywrq=:date    "
			+ "  and a.product_id = :productId  ",nativeQuery=true)
	public void saveValudationMessage(@Param("productId") String productId,
                                      @Param("dataSource") int dataSource,
                                      @Param("date") String date);


	/**
	 * 保存基金产品估值详细信息表(业务)
	 * @param productId
	 * @param dataSource
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" insert into "
			+ "t_fund_valuation_message(                       "
			+"   date,                                                     "
			+"   product_id,                                               "
			+"   data_source,                                              "
			+"   type,                                                     "
			+"   value,                                                    "
			+"   market_value,                                             "
			+"   appreciation_valuation,                                   "
			+"   propportion,"
			+"   update_date ,                                              "
			+"   trustee_id                                               "
			+" )                                                           "
			+" SELECT                                                      "
			+"   DATE_FORMAT(a.ywrq, '%Y%m%d') DATE,                       "
			+ "  :productId productId,                                          "
			+ "  :dataSource dataSource,                                        "
			+"   REPLACE(a.kmdm, ':', '') TYPE,                            "
			+"   CASE                                                      "
			+"     WHEN LOCATE('净值',  REPLACE((a.kmdm),',','')) > 0      "
			+"     OR a.kmdm = '本年已实现收益:'                           "
			+"     OR a.kmdm = '本月已实现收益:'                           "
			+"     OR a.kmdm = '从成立日开始的累计已实现收益:'             "
			+"     OR a.kmdm = '可分配利润:'                               "
			+"     OR a.kmdm = '单位可分配利润:'                           "
			+"     THEN REPLACE(a.kmmc,',','')     "
			+"     ELSE REPLACE(a.cb,',','') "
			+"   END VALUE,                                                "
			+"   a.sz marketValue,                                         "
			+"   a.gzzz appreciationValuation,                             "
			+"   CASE                                                      "
			+"     WHEN a.kmdm = '证券投资合计:'                           "
			+"     THEN a.sl                                               "
			+"    ELSE NULL                                "
			+"   END propportion,"
			+"   (SELECT DATE_FORMAT(NOW(), '%Y%m%d') FROM DUAL)  ,"
			+ " a.trustee_id         "
			+" FROM                                                        "
			+"   t_raw_fund_valuation a                                    "
			+" WHERE (                                                     "
			+"     LOCATE(':', a.kmdm) = CHAR_LENGTH(a.kmdm)               "
			+"     OR LOCATE(':', a.kmdm) = 0                              "
			+"   )                                                         "
			+"   AND ASCII(a.kmdm) >= 127  "
			+ "  and a.ywrq=:date    "
			+ "  and a.product_id = :productId  ",nativeQuery=true)
	public void saveValudationMessageByFund(@Param("productId") String productId,
                                            @Param("dataSource") int dataSource,
                                            @Param("date") String date);



	/**
	 * 查询估值表当天产品ID
	 * @param date
	 * @return
	 */
	@Query(value="SELECT distinct  CONCAT(t.product_id,'')  FROM t_fund_valuation_message t WHERE t.date=:date",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);

	/**
	 * 查询产品ID总资产净值
	 * @param date
	 * @return
	 */
	@Query(value="SELECT new com.quantdo.iwin.entity.FundValuationMessage(t.productId, t.date, t.market_value) "
			+ "FROM FundValuationMessage t WHERE (t.type like '资产类合计%' or t.type like '资产合计%') "
			+ "AND t.productId=:productId "
			+ "AND (t.date >= :startDate or :startDate is null) "
			+ "AND (t.date <= :endDate or :endDate is null) "
			+ "GROUP BY t.date")
	public List<FundValuationMessage> findAssetByProductId(@Param("productId") String productId, @Param("startDate") String startDate,
                                                           @Param("endDate") String endDate);
	
	
}