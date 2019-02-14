package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Contract;
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
@Repository(value = "contractRepository")
@EntityClass(entityClass = Contract.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface ContractRepository extends CrudRepository<Contract, Long> {
	
	@Query(value = "select c from Contract c "
			+ "where c.date in (:date) and  (c.assetType = :assetType or :assetType is null) "
			+ "order by c.date")
	public List<Contract> findByAssetTypeAndDate(@Param("date") List<String> date, @Param("assetType") String assetType);

	@Query(value = "select c from Contract c "
			+ "where c.date >= :startDate and c.date <= :endDate "
			+ "and (c.assetType = :assetType or :assetType is null) "
			+ "order by c.date")
	public List<Contract> findByAssetTypeAndDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("assetType") String assetType);

	@Query(value = "select c from Contract c "
			+ "where c.date >= :startDate and c.date <= :endDate "
			+ "and c.assetType <> '1' "
			+ "order by c.date")
	public List<Contract> findSecurityContractByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 按照当日市值排序获取对应主键集合
	 * @param date
	 * @return
	 */
	@Query(value="SELECT id FROM t_contract WHERE asset_type = '5' AND DATE = :date "
			+ "ORDER BY market_value DESC", nativeQuery = true)
	public List<String> getContractIdListByMarketValue(@Param("date") String date);

	/**
	 * 更新合约行情盘行字段
	 * @param ids
	 * @param stockType
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" update  t_contract set stock_type =:stockType "
			+ " where id in(:ids) ",nativeQuery=true)
	public void updateContractStockType(@Param("ids") List<String> ids, @Param("stockType") String stockType);

	/**
	 * 在指定盘行组内按照当日市净率+市盈率降序
	 * @param date
	 * @param stockType
	 * @return
	 */
	@Query(value="SELECT id "
			+ "   FROM t_contract "
			+ "   WHERE asset_type = '5'  "
			+ "        AND DATE = :date "
			+ "        AND stock_type = :stockType "
			+ "        ORDER BY (pe_ratio+pb_ratio) DESC", nativeQuery = true)
	public List<String> getContractIdListByRatio(@Param("date") String date, @Param("stockType") String stockType);

	/**
	 * 更新合约行情成长价值字段
	 * @param ids
	 * @param stockType
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" update  t_contract set stock_growth_value =:growth "
			+ " where id in(:ids) and stock_type = :stockType",nativeQuery=true)
	public void updateContractGrowthValue(@Param("ids") List<String> ids, @Param("stockType") String stockType, @Param("growth") String growth);

	@Query(value = "select c from Contract c "
			+ "where c.date >= :startDate and c.date <= :endDate "
			+ "and c.assetType = '5' and c.dividendRatio is not null")
	public List<Contract> findStockDividendRatioContractByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 更新合约的市值类型
	 * @param date
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" UPDATE 									   "
				+"   t_contract                                "
				+" SET                                         "
				+"   market_value_type = (                     "
				+"     CASE                                    "
				+"       WHEN market_value >= 50000000000      "
				+"       THEN 1                                "
				+"       WHEN market_value < 50000000000       "
				+"       AND market_value >= 10000000000       "
				+"       THEN 2                                "
				+"       WHEN market_value < 10000000000       "
				+"       AND market_value >= 2000000000        "
				+"       THEN 3                                "
				+"       ELSE 4                                "
				+"     END                                     "
				+"   )                                         "
				+" WHERE DATE = :date                       "
				+"   AND asset_type = '5'  ",nativeQuery=true)
	public void updateContractMarketValueType(@Param("date") String date);

	@Query(value = "select c from Contract c where c.date = :date")
	public List<Contract> findByDate(@Param("date") String date);


	@Query(value = "SELECT DISTINCT t.contract FROM t_contract t WHERE t.variety_id IN(:varietyId) "
			+ "AND (RIGHT(t.contract_name,4) = :contractName) " ,nativeQuery=true)
	public String findContractByVarietyIdAndName(@Param("varietyId") List<String> varietyId, @Param("contractName") String contractName);

	@Query("select new com.quantdo.iwin.entity.Contract(c.date,c.contract,c.assetType,c.industry,"
			+ "c.pbRatio,c.assetDebtRatio,c.cashEarning,c.totalEarning,c.dailyYieldRate,c.marketValue) "
			+ "from Contract c "
			+ "where c.date >= :startDate "
			+ "and c.date <= :endDate "
			+ "and c.listingDate <= :listingDate "
			+ "and c.contract in :contractIDs")
	public List<Contract> findByDateAndListingDateAndContractIDs(@Param("startDate") String startDate,
                                                                 @Param("endDate") String endDate, @Param("listingDate") String listingDate,
                                                                 @Param("contractIDs") List<String> contractIDs);

	@Query("select new com.quantdo.iwin.entity.Contract(c.date,c.contract,c.assetType,c.industry,"
			+ "c.pbRatio,c.assetDebtRatio,c.cashEarning,c.totalEarning,c.dailyYieldRate,c.marketValue) "
			+ "from Contract c "
			+ "where c.date >= :startDate "
			+ "and c.date <= :endDate "
			+ "and c.listingDate <= :listingDate ")
	public List<Contract> findByDateAndListingDate(@Param("startDate") String startDate,
                                                   @Param("endDate") String endDate, @Param("listingDate") String listingDate);

	/**
	 * 查询股票每年营业总额
	 */
	@Query(value = "SELECT t.date,t.contract,t.industry,t.total_earning "
			+ "FROM t_contract t WHERE CONCAT(t.contract,t.date) IN ("
			+ "SELECT CONCAT(c.contract,MAX(c.date)) "
			+ "FROM t_contract c "
			+ "WHERE asset_type = 5 AND total_earning IS NOT NULL "
			+ "GROUP BY SUBSTR(c.date,1,4),contract) ", nativeQuery = true)
	public List<Object[]> findTotalEarningYearEnd();

	/**
	 * 查找某日证券各行业日收益总和
	 */
	@Query(value = "SELECT c.date,c.industry,AVG(c.daily_yield_rate) "
			+ "FROM t_contract c "
			+ "WHERE c.asset_type = '5' AND c.date = :date AND c.listing_date <= :threeMonthBeforeDate "
			+ "GROUP BY c.industry", nativeQuery = true)
	public List<Object[]> getStockAvgYieldRateByIndustry(@Param("date") String date, @Param("threeMonthBeforeDate") String threeMonthBeforeDate);

	/**
	 * 根据日期区段获取期间每个月证券换手率,日期区间左闭右开
	 */
	@Query(value = "SELECT LN(SUM(c.turnover)/SUM(c.market_value)),SUBSTR(c.date, 1, 6),c.contract "
			+ "FROM t_contract c "
			+ "WHERE c.asset_type = '5' "
			+ "AND c.date >= :startDate "
			+ "AND c.date <= :endDate "
			+ "AND c.listing_date <= :threeMonthBeforeDate "
			+ "GROUP BY c.contract,SUBSTR(c.date, 1, 6)", nativeQuery = true)
	public List<Object[]> getMonthStockTunByDatePeriod(@Param("startDate") String startDate, @Param("endDate") String endDate,
                                                       @Param("threeMonthBeforeDate") String threeMonthBeforeDate);


	/**
	 * 查找N个交易日前的那一天日期
	 */
	@Query(value = "SELECT DISTINCT DATE FROM t_contract WHERE asset_type = '5' ORDER BY DATE DESC LIMIT :beforeDate", nativeQuery = true)
	public List<String> findDateDescByDateLen(@Param("beforeDate") int beforeDate);

	/**
	 * 根据日期删除合约
	 * @param date
	 */
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" delete from   t_contract  where date=:date",nativeQuery=true)
	public void delContractByDate(@Param("date") String date);

	@Query(value = "SELECT DISTINCT asset_type FROM t_contract WHERE date=:date and (contract=:contact)", nativeQuery = true)
	public String getAssetType(@Param("date") String date, @Param("contact") String contact);

	@Query(value = "SELECT DISTINCT industry,variety_id,asset_type FROM t_contract WHERE date=:date and (contract=:contact)", nativeQuery = true)
	public List<Object[]> findIndustryAssetTypeByContract(@Param("date") String date, @Param("contact") String contact);


	public List<Contract> findByContractAndDate(String contract, String date);

	public Contract findByDateAndContract(String date, String contract);


	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from t_contract where date=:date and asset_type=:assetType",nativeQuery = true)
	public void delContractByDateAndAssetType(@Param("date") String date, @Param("assetType") String assetType);


}
