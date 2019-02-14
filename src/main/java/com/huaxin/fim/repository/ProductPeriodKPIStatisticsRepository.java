package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.response.AlphaBetaResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductPeriodKPIStatistics.class)
@Named("productPeriodKPIStatisticsRepository")
public interface ProductPeriodKPIStatisticsRepository extends CrudRepository<ProductPeriodKPIStatistics, Long> {
	

	public List<ProductPeriodKPIStatistics> findAll();
	
	/**
	 * 风格分析(证券)-市值配置变化、股息率配置变化
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI in :KPIList "
			+ "and (p.date >= :startDate or :startDate is null) "
			+ "and (p.date <= :endDate or :endDate is null) "
			+ "and p.productID = :productID "
			+ "order by p.date,p.productID,p.KPI")
	public List<ProductPeriodKPIStatistics> findByKPIListAndProductIDAndDatePeriod(@Param("KPIList") List<String> KPIList,
                                                                                   @Param("productID") String productID, @Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 日期区间产品累计净值收益率
	 */
	@Query(value = "select i from ProductPeriodKPIStatistics i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and (i.productID = :productID or :productID is null) "
			+ "and i.today is not null and i.KPI = '020032' "
			+ "order by i.productID,i.date")
	public List<ProductPeriodKPIStatistics> findYieldRateByDatePeriod(@Param("startDate") String startDate,
                                                                      @Param("endDate") String endDate, @Param("productID") String productID);

	/**
	 * 日期区间产品各资产类别市值
	 */
	@Query(value = "select i from ProductPeriodKPIStatistics i "
			+ "where (i.date >= :startDate or :startDate is null) "
			+ "and (i.date <= :endDate or :endDate is null) "
			+ "and (i.productID = :productID or :productID is null) "
			+ "and i.today is not null and i.KPI in ('020068','020069','020070','020071',"
			+ "	'020072','020081','020082','020083','020084','020085','020086','020097','020098') "
			+ "order by i.productID,i.date")
	public List<ProductPeriodKPIStatistics> findAssetMarketValueByDatePeriod(@Param("startDate") String startDate,
                                                                             @Param("endDate") String endDate, @Param("productID") String productID);

	/**
	 * 风格分析(证券)-收益率相关性
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI in :KPIList "
			+ "and p.date = ("
			+ "	select MAX(k.date) from ProductPeriodKPIStatistics k "
			+ "	where k.KPI in :KPIList and (k.productID = :productID or :productID is null) ) "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.KPI")
	public List<ProductPeriodKPIStatistics> findCoefficientByKPIListAndProductID(@Param("KPIList") List<String> KPIList,
                                                                                 @Param("productID") String productID);

	/**
	 * 日期区间,某产品指定KPI值
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI in (:KPIList) "
			+ "and (p.date >= :startDate or :startDate is null) "
			+ "and (p.date <= :endDate or :endDate is null) "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.date,p.KPI")
	public List<ProductPeriodKPIStatistics> findProductKPIsByKPIListAndDatePeriod(@Param("KPIList") List<String> KPIList,
                                                                                  @Param("productID") String productID, @Param("startDate") String startDate, @Param("endDate") String endDate);

	/**
	 * 获取风格类型列表
	 * @param productId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ " where p.KPI in (:kpiCodes) "
			+ " and (p.date >= :beginDate or :beginDate is null)"
			+ " and ( p.date <= :endDate or :endDate is null)"
			+ " and p.productID = :productId")
	public List<ProductPeriodKPIStatistics> getStyleTyleList(@Param("kpiCodes") List<String> kpiCodes,
                                                             @Param("productId") String productId, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	/**
	 * 五日收益率标准差统计是否满5天
	 * @param productId
	 * @param date
	 * @return
	 */
	@Query(value="SELECT COUNT(t.date) FROM ProductPeriodKPIStatistics t WHERE t.date<= :date AND t.productID=:productId AND t.KPI=020032 ")
	public int getCountDays(@Param("productId") String productId, @Param("date") String date);


	/**
	 * 获取收益率
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI = '020032' "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.date,p.KPI")
	public List<ProductPeriodKPIStatistics> findYIELDRATIOProductKPIsByKPIList(@Param("productID") String productID);

	/**
	 * 获取年化收益率
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI = '030002' "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.date,p.KPI")
	public List<ProductPeriodKPIStatistics> findYIELDRATIOProductKPIsByProductID(@Param("productID") String productID);

	/**
	 * 前端展示alpha和贝塔值
	 */
	@Query(value = "SELECT p.date date,k.value alphaValue,p.value betaVale FROM t_product_index_period_kpi_statistics p "
			+ "LEFT JOIN (SELECT t.date,t.value FROM t_product_index_period_kpi_statistics t "
			+ "WHERE t.KPI = :alphaValueKPI AND t.index_id = :indexID AND t.period_type = '6' "
			+ "and t.product_id = :productId) k ON p.date = k.date "
			+ "WHERE p.KPI = :kpiCode "
			+ "and p.product_id = :productId AND p.index_id = :indexID AND p.period_type = '0' "
			+ "and (p.date >= :beginDate or :beginDate is null) "
			+ "order by p.date" , nativeQuery = true)
	public List<AlphaBetaResponse> findAlphaAndBetaByProductID(@Param("kpiCode") String kpiCode,
															   @Param("alphaValueKPI") String alphaValueKPI, @Param("productId") String productId,
															   @Param("beginDate") String beginDate, @Param("indexID") String indexID);

	/**
	 * 日期,某产品指定KPI值
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI = :betaKPI "
			+ "and (p.date = :statdate or :statdate is null) "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.date")
	public ProductPeriodKPIStatistics findProductKPIsByKPIAndDate(@Param("betaKPI") String betaKPI,
                                                                  @Param("productID") String productID, @Param("statdate") String statdate);

	/**
	 * 某产品指定KPI值
	 */
	@Query(value = " SELECT  MIN(t.date) FROM t_product_period_kpi_statistics t "
			+ "LEFT JOIN (SELECT  t.product_id product_id, MIN(t.until_now) until_now  "
			+ "FROM t_product_period_kpi_statistics t  WHERE t.product_id = :productId AND t.KPI=030033) p  "
			+ "ON p.product_id = t.product_id WHERE t.product_id = :productId  "
			+ "AND p.until_now = t.until_now " , nativeQuery = true)
	public String findMaxDrawdownCycleDate(@Param("productId") String productId);

	/**
	 * 根据产品ID和日期获取alpha和beta值
	 */
	@Query(value = "SELECT p.date date,k.today alphaValue,p.today betaVale FROM t_product_period_kpi_statistics p "
			+ "LEFT JOIN (SELECT p.date,p.today FROM t_product_period_kpi_statistics p WHERE "
			+ "p.KPI = :alphaKPI "
			+ "and (p.product_id = :productId or :productId is null)) k ON p.date=k.date "
			+ "WHERE p.KPI = :betaKPI "
			+ "and (p.product_id = :productId or :productId is null) "
			+ "and (p.date = :statdate or :statdate is null) "
			+ "order by p.date" , nativeQuery = true)
	public List<Object[]> findAlphaAndBetaByProductIDAndDate(@Param("alphaKPI") String alphaKPI, @Param("betaKPI") String betaKPI,
                                                             @Param("productId") String productId, @Param("statdate") String statdate);

	/**
	 * 前端展示alpha和贝塔值
	 */
	@Query(value = "SELECT p.date date,p.value alphaValue,k.value timingValue FROM t_product_index_period_kpi_statistics p "
			+ "LEFT JOIN (SELECT p.date,p.value FROM t_product_index_period_kpi_statistics p WHERE "
			+ "p.KPI = :timingValueKPI and p.period_type = '6' and p.index_id = :indexID "
			+ "and p.product_id = :productId ) k ON p.date=k.date "
			+ "WHERE p.KPI = :kpiCode and p.period_type = '6' and p.index_id = :indexID "
			+ "and p.product_id = :productId "
			+ "and (p.date >= :beginDate or :beginDate is null) "
			+ "order by p.date" , nativeQuery = true)
	public List<Object[]> findAlphaAndTimingValueByProductID(@Param("kpiCode") String kpiCode, @Param("timingValueKPI") String timingValueKPI,
                                                             @Param("productId") String productId, @Param("beginDate") String beginDate, @Param("indexID") String indexID);

	/**
	 * 获取相关KPI
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI = :KPI "
			+ "and (p.productID = :productID or :productID is null) "
			+ "order by p.productID,p.date")
	public List<ProductPeriodKPIStatistics> findProductKPIsByProductIdAndKPI(@Param("productID") String productID, @Param("KPI") String KPI);


	/**
	 * 获取基差和超额收益率指标
	 */
	@Query(value = "SELECT p.date date,p.today abnormalReturnVale,k.today basisValue FROM t_product_period_kpi_statistics p "
			+ "LEFT JOIN (SELECT p.date,p.today FROM t_product_period_kpi_statistics p WHERE "
			+ "p.KPI = :kpiCode "
			+ "and (p.product_id = :productId or :productId is null)) k ON p.date=k.date "
			+ "WHERE p.KPI = :abnormalReturnKPI "
			+ "and (p.product_id = :productId or :productId is null) "
			+ "and (p.date >= :beginDate or :beginDate is null) "
			+ "order by p.date" , nativeQuery = true)
	public List<Object[]> findBasisByProductID(@Param("kpiCode") String kpiCode, @Param("abnormalReturnKPI") String abnormalReturnKPI,
                                               @Param("productId") String productId, @Param("beginDate") String beginDate);

	/**
	 * 获取相关KPI对应日期的值
	 */
	@Query(value = "select p.today FROM t_product_period_kpi_statistics p "
			+ "where p.KPI = :KPI "
			+ "and (p.product_id = :productID or :productID is null) "
			+ "and (p.date = :beginDate or :beginDate is null) "
			+ "order by p.product_id,p.date" , nativeQuery = true)
	public BigDecimal findProductKPIsByProductIdAndKPIAadDate(@Param("productID") String productID,
                                                              @Param("KPI") String KPI, @Param("beginDate") String beginDate);

	/**
	 * 获取相关KPI值得最大日期
	 */
	@Query(value = "select Max(p.date) FROM t_product_period_kpi_statistics p "
			+ "where p.KPI = :KPI "
			+ "and (p.product_id = :productID or :productID is null) "
			+ "order by p.product_id,p.date" , nativeQuery = true)
	public String findMaxDateByIdAndKPI(@Param("productID") String productID, @Param("KPI") String KPI);

	/**
	 * 获取某产品某日某指标
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI = :kpi "
			+ "and p.productID = :productID "
			+ "and p.date <= :date")
	public List<ProductPeriodKPIStatistics> findYieldRatioByDateAndProduct(@Param("productID") String productID,
                                                                           @Param("date") String date, @Param("kpi") String kpi);

	/**
	 * 获取某产品指定指标最新单日数据
	 */
	@Query("select p from ProductPeriodKPIStatistics p "
			+ "where CONCAT(p.date,'#',p.KPI) in ( "
			+ "select CONCAT(MAX(w.date),'#',w.KPI) "
			+ "from ProductPeriodKPIStatistics w "
			+ "where w.productID = :productID "
			+ "group by w.KPI) "
			+ "and p.productID = :productID and p.KPI in (:kpis)")
	public List<ProductPeriodKPIStatistics> findByMaxDateProductIDAndKPIs(@Param("productID") String productID,
                                                                          @Param("kpis") List<String> kpis);

	/**
	 * 获取最新一天需要计算指标的产品列表
	 * @param date
	 * @return
	 */
	@Query(value="SELECT product_id FROM t_product_net_value WHERE DATE >:date GROUP BY product_id ",nativeQuery=true)
	public List<String> getProductIdList(@Param("date") String date);

	/**
	 * 获取最新一天需要计算指标的产品列表
	 * @param date
	 * @return
	 */
	@Query(value=" SELECT                              "
				+"     t.product_id                      "
				+"   FROM                                 "
				+"     t_product_period_his_statistics t            "
				+"   WHERE t.date = :date           "
				+"   GROUP BY t.product_id  ",nativeQuery=true)
	public List<String> getLastDayProductIdList(@Param("date") String date);


	/**
	 * 获取最新一天需要计算指标的产品列表
	 * @param date
	 * @return
	 */
	@Query(value=" SELECT                              "
				+"     t.product_id                      "
				+"   FROM                                 "
				+"     t_product_period_kpi_statistics t            "
				+"   WHERE t.date = :date           "
				+"   GROUP BY t.product_id  ",nativeQuery=true)
	public List<String> getLastDaykpiProductIdList(@Param("date") String date);

	/**
	 * 获取最新一天需要计算指标的产品列表
	 * @param date
	 * @return
	 */
	@Query(value=" SELECT                              "
				+"     t.product_id                      "
				+"   FROM                                 "
				+"     t_product_period_kpi_statistics t            "
				+"   WHERE t.date = :date  and t.kpi=:kpiCode         "
				+"   GROUP BY t.product_id  ",nativeQuery=true)
	public List<String> getLastDayProductIdByKpiList(@Param("date") String date, @Param("kpiCode") String kpiCode);

	/**
	 * 获取所需KPI
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI in (:KPIList) "
			+ "and p.productID = :productId "
			+ "and p.date >= :startDate "
			+ "and p.date <= :endDate "
			+ "GROUP BY DATE ,KPI ")
	public List<ProductPeriodKPIStatistics> findProductPeriodKPIStatisticsByProductId(@Param("productId") String productId,
                                                                                      @Param("KPIList") List<String> KPIList, @Param("startDate") String startDate, @Param("endDate") String endDate);


	/**
	 * 获取相关子基金相关特定KPI数据
	 */
	@Query(value = "select * FROM t_product_period_kpi_statistics p "
			+ "where p.KPI in ('020068','020069','020070','020071',"
			+ "'020081','020082','020083','020084','020085','020086','020097','020098') "
			+ "and (p.product_id in (:productIds))"
			+ "and (p.date =:date) "
			+ "order by p.product_id,p.date" , nativeQuery = true)
	public List<ProductPeriodKPIStatistics> findMaxDateByIdsAndKPI(@Param("productIds") List<String> productIds, @Param("date") String date);
	/**
	 * 获取母基金相关指标日期
	 */
	@Query(value = "SELECT t.date FROM 						"
					+"(SELECT                               "
					+"  p.date date ,SUM(p.today) today     "
					+"FROM                                  "
					+"  t_product_period_kpi_statistics p   "
					+"WHERE p.KPI IN (                      "
					+"    '020068',                         "
					+"    '020069',                         "
					+"    '020070',                         "
					+"    '020071',                         "
					+"    '020081',                         "
					+"    '020082',                         "
					+"    '020083',                         "
					+"    '020084',                         "
					+"    '020085',                         "
					+"    '020086',                         "
					+"    '020097',                         "
					+"    '020098'                          "
					+"  )                                   "
					+"  AND (p.product_id =:productId)      "
					+"  GROUP BY p.date) t                  "
					+"  WHERE t.today > 0                   "
					+"  ORDER BY t.date DESC                " , nativeQuery = true)
	public List<String> findMaxDateByParentIdAndKPI(@Param("productId") String productId);

	/**
	 * 获取相关日期列表
	 */
	@Query(value = "select p.date FROM t_product_period_kpi_statistics p "
			+ "where p.KPI = :KPI "
			+ "and (p.product_id = :productID or :productID is null) "
			+ "order by p.date desc " , nativeQuery = true)
	public List<String> findDateListByIdAndKPI(@Param("productID") String productID, @Param("KPI") String KPI);

	/**
	 * 获取相关子基金相关KPI数据
	 */
	@Query(value = "select * FROM t_product_period_kpi_statistics p "
			+ "where p.KPI =:KPI "
			+ "and (p.product_id in (:productIds))"
			+ "and (p.date =:date) "
			+ "order by p.product_id,p.date" , nativeQuery = true)
	public List<ProductPeriodKPIStatistics> findKPIStatisticsByIdsAndKPI(@Param("KPI") String KPI, @Param("productIds") List<String> productIds, @Param("date") String date);

	/**
	 * 获取相关子基金相关KPI数据
	 */
	@Query(value = "select p from ProductPeriodKPIStatistics p "
			+ "where p.KPI =:KPI "
			+ "and p.productID =:productId "
			+ "and p.date >= :beginDate and p.date <=:endDate ")
	public List<ProductPeriodKPIStatistics> getBuyOrSellTurnoverList(@Param("KPI") String KPI, @Param("productId") String prouctId,
                                                                     @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	@Query(value = "select date from t_product_period_kpi_statistics where product_id = :productId and kpi in ('020060','020061') and date >=:beginDate and date <=:endDate group by date",nativeQuery=true)
	public List<String> getBuyOrSellTurnoverDays(@Param("productId") String prouctId, @Param("beginDate") String beginDate, @Param("endDate") String endDate);
	
}	