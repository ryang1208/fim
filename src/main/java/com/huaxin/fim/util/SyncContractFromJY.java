package com.huaxin.fim.util;

import com.dev.framework.core.configure.ConfigureProperties;
import com.huaxin.fim.api.ContractService;
import com.huaxin.fim.dao.ContractDao;
import com.huaxin.fim.entity.entity.Contract;
import com.huaxin.fim.repository.ContractRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncContractFromJY {
	private static final Log logger = LogFactory.getLog(SyncContractFromJY.class);
	
	public static Connection getConnection(String dbType, String url, String userName, String password) {
		ConfigureProperties configure = (ConfigureProperties) SpringUtils.getBean("configureProperties");
		dbType = "sqlserver";
		url = configure.getProperty("jy.url");
		userName = configure.getProperty("jy.userName");
		password = configure.getProperty("jy.password");

		Connection conn = null;
		conn = SyncContractFromWind.getSqlServerConnection(url, userName, password);
		return conn;
	}

	public static void getContractListFromSqlServer(String beginDate,String endDate) {
		ContractRepository contractRepository = (ContractRepository) SpringUtils.getBean("contractRepository");
		ContractDao contractDao = (ContractDao) SpringUtils.getBean("contractDao");
		ContractService contractService = (ContractService) SpringUtils.getBean("contractService");
		logger.info("接JY合约数据，日期【"+beginDate+"】到【"+endDate+"】-------------------begin");
		Connection conn = SyncContractFromJY.getConnection(null, null, null, null);
		Statement stmt = null;
		ResultSet rs = null;
		String statDate = beginDate;
		try {
			stmt = conn.createStatement();
			while (!DATE.isAfter(DATE.threadParse(statDate, "yyyyMMdd"), DATE.threadParse(endDate, "yyyyMMdd"))) {
				List<Contract> cList = new ArrayList<Contract>();
				// 1、接聚源合约数据
				String sql ="SELECT                                                                                                                                                                                                 "
						+"  CONVERT(VARCHAR(10), a.TradingDay, 112)DATE,                                                                                                                                                         "
						+"  CASE WHEN s.SecuMarket =51 THEN 'CFFEX'                                                                                                                                                              "
						+"   WHEN s.SecuMarket =15 THEN 'CZCE'                                                                                                                                                                   "
						+"   WHEN s.SecuMarket=13 THEN 'DCE'                                                                                                                                                                     "
						+"   WHEN s.SecuMarket=10 THEN 'SHFE'                                                                                                                                                                    "
						+"   WHEN s.SecuMarket=83 THEN 'SSE'                                                                                                                                                                     "
						+"   WHEN s.SecuMarket=90 THEN 'SZSE'                                                                                                                                                                    "
						+"   ELSE CONVERT(VARCHAR,s.SecuMarket) END  exchangeId,                                                                                                                                                 "
						+"  s.SecuCode contract,                                                                                                                                                                                 "
						+"  s.SecuCode varietyId,                                                                                                                                                                                "
						+"  1 contractMultiplier,                                                                                                                                                                                "
						+"  'CNY' currency,                                                                                                                                                                                      "
						+"  '5' assetType,                                                                                                                                                                                       "
						+"  s.SecuAbbr contractName,                                                                                                                                                                             "
						+"  d.FirstIndustryName  industry,                                                                                                                                                                       "
						+" CASE WHEN l.InnerCode IS NULL THEN '0' ELSE '1' END isSuspension,                                                                                                                                     "
						+" CAST(a.PrevClosePrice  AS NUMERIC(20,4))  closePriceLastDay,                                                                                                                                          "
						+" CAST(a.OpenPrice  AS NUMERIC(20,4))   openPriceToday,                                                                                                                                                 "
						+" CAST(a.ClosePrice   AS NUMERIC(20,4))  priceToday,                                                                                                                                                    "
						+" CAST(a.ClosePrice  AS NUMERIC(20,4))  closePriceToday,                                                                                                                                                "
						+" CAST(a.NegotiableMV  AS NUMERIC(20,4))  marketValue,                                                                                                                                                       "
						+" CAST(f.PE   AS NUMERIC(20,4))  peRatio,                                                                                                                                                               "
						+" CAST( f.PB   AS NUMERIC(20,4))  pbRatio,                                                                                                                                                              "
						+" CAST(f.DividendRatio  AS NUMERIC(9,4))  dividendRatio,                                                                                                                                                "
						+" CONVERT(VARCHAR(10), s.ListedDate, 112)listingDate,                                                                                                                                                   "
						+" a.ChangePCT dailyYieldRate,                                                                                                                                                                           "
						+" CAST((SELECT  top 1 CASE WHEN TotalAssets IS NULL THEN NULL ELSE ISNULL(TotalLiability,0)/TotalAssets END FROM LC_BalanceSheetAll WHERE CompanyCode  = s.CompanyCode AND EndDate <=a.TradingDay ORDER  "
						+" BY EndDate DESC)AS NUMERIC(20,4)) assetDebtRatio,                                                                                                                                                     "
						+" (SELECT  top 1 CAST(TotalOperatingRevenue AS NUMERIC(20,4)) FROM LC_IncomeStatementAll WHERE CompanyCode  = s.CompanyCode AND EndDate <=a.TradingDay ORDER BY EndDate DESC) cashEarning,              "
						+" (SELECT  top 1 CAST(TotalOperatingRevenue AS NUMERIC(20,4)) FROM LC_IncomeStatementAll WHERE CompanyCode  = s.CompanyCode AND EndDate <=a.TradingDay ORDER BY EndDate DESC) totalEarning,             "
						+" CAST(a.TurnoverValue AS NUMERIC(20,4)) turnover                                                                                                                                                       "
						+"FROM QT_Performance a                                                                                                                                                                                  "
						+"LEFT JOIN SecuMain s ON a.InnerCode = s.InnerCode                                                                                                                                                      "
						+"LEFT JOIN LC_CSIIndusPE b ON a.InnerCode = b.InnerCode AND  CONVERT(VARCHAR(10), a.TradingDay, 112) = CONVERT(VARCHAR(10), b.TradingDate, 112)  AND StatType=1 AND StatRatio =1                        "
						+"LEFT JOIN (select * from (                                                                                                                                                                             "
						+"	select ROW_NUMBER() over(partition by d.CompanyCode order by d.CompanyCode,d.InfoPublDate desc) pid, *                                                                                               "
						+"	from LC_ExgIndustry d                                                                                                                                                                                "
						+"	where d.Standard = '24'                                                                                                                                                                              "
						+"	and d.InfoPublDate <= '"+statDate+"')X                                                                                                                                                                   "
						+"	where pid = 1                                                                                                                                                                                        "
						+"	) d ON s.CompanyCode = d.CompanyCode                                                                                                                                                                 "
						+"LEFT JOIN LC_SuspendResumption l ON l.InnerCode = s.InnerCode AND CONVERT(VARCHAR(10), a.TradingDay, 112) = CONVERT(VARCHAR(10),l.SuspendDate, 112)                                                    "
						+"LEFT JOIN LC_DIndicesForValuation f ON a.InnerCode = f.InnerCode AND CONVERT(VARCHAR(10), a.TradingDay, 112) = CONVERT(VARCHAR(10),f.TradingDay, 112)                                                  "
						+"WHERE CONVERT(VARCHAR(10), a.TradingDay, 112)  = '"+statDate+"'";
				rs = stmt.executeQuery(sql);
	
				while (rs.next()) {
					String date = rs.getString("date");
					String exchangeId = rs.getString("exchangeId");
					String contract = rs.getString("contract");
					String varietyId = rs.getString("varietyId");
					String contractMultiplier = rs.getString("contractMultiplier");
					String currency = rs.getString("currency");
					String assetType = rs.getString("assetType");
					String contractName = rs.getString("contractName");
					String industry = rs.getString("industry");
					String isSuspension = rs.getString("isSuspension");
					String closePriceLastDay = rs.getString("closePriceLastDay");
					String openPriceToday = rs.getString("openPriceToday");
					String priceToday = rs.getString("priceToday");
					String closePriceToday = rs.getString("closePriceToday");
					String marketValue = rs.getString("marketValue");
					String peRatio = rs.getString("peRatio");
					String pbRatio = rs.getString("pbRatio");
					String dividendRatio = rs.getString("dividendRatio");
					String listingDate = rs.getString("listingDate");
					String dailyYieldRate = rs.getString("dailyYieldRate");
					String assetDebtRatio = rs.getString("assetDebtRatio");
					String cashEarning = rs.getString("cashEarning");
					String totalEarning = rs.getString("totalEarning");
					String turnover = rs.getString("turnover");
					Contract c = new Contract();
					c.setDate(date);
					c.setExchangeId(exchangeId);
					c.setContract(contract);
					c.setVarietyId(varietyId);
					c.setContract_multiplier(!StringUtils.isEmpty(contractMultiplier) ? new BigDecimal(contractMultiplier) : null);
					c.setCurrency(currency);
					c.setAssetType(assetType);
					c.setContractName(contractName);
					c.setIndustry(industry);
					c.setIsSuspension(isSuspension);
					c.setClosePriceLastDay(!StringUtils.isEmpty(closePriceLastDay) ? new BigDecimal(closePriceLastDay) : null);
					c.setOpenPriceToday(!StringUtils.isEmpty(openPriceToday) ? new BigDecimal(openPriceToday) : null);
					c.setPriceToday(!StringUtils.isEmpty(priceToday) ? new BigDecimal(priceToday) : null);
					c.setClosePriceToday(!StringUtils.isEmpty(closePriceToday) ? new BigDecimal(closePriceToday) : null);
					c.setMarketValue(!StringUtils.isEmpty(marketValue) ? new BigDecimal(marketValue) : null);
					c.setPeRatio(!StringUtils.isEmpty(peRatio) ? new BigDecimal(peRatio) : null);
					c.setPbRatio(!StringUtils.isEmpty(pbRatio) ? new BigDecimal(pbRatio) : null);
					c.setDividendRatio(!StringUtils.isEmpty(dividendRatio) ? new BigDecimal(dividendRatio) : null);
					c.setListingDate(listingDate);
					c.setDailyYieldRate(!StringUtils.isEmpty(dailyYieldRate) ? new BigDecimal(dailyYieldRate) : null);
					c.setAssetDebtRatio(!StringUtils.isEmpty(assetDebtRatio) ? new BigDecimal(assetDebtRatio) : null);
					c.setCashEarning(!StringUtils.isEmpty(cashEarning) ? new BigDecimal(cashEarning) : null);
					c.setTotalEarning(!StringUtils.isEmpty(totalEarning) ? new BigDecimal(totalEarning) : null);
					c.setTurnover(!StringUtils.isEmpty(turnover) ? new BigDecimal(turnover) : null);
					cList.add(c);
				}
				
				if (cList != null && cList.size() > 0) {
					Map<String, Contract> v = new ConcurrentHashMap<String, Contract>();
					for (Contract c : cList) {
						v.put(c.getDate() +  "#" + c.getContract(), c);
					}
					cList.clear();
					for (String key : v.keySet()) {
						cList.add(v.get(key));
					}
				}
				
				// 2、删除当日合约
				contractRepository.delContractByDate(statDate);
				// 3、保存入库
				contractDao.saveContract(null, null, cList);
				// 4、更新盘行等字段
				contractService.updateContractInfo(statDate);
				statDate = DATE.addThreadDate(statDate, 0, 0, 1);
			}
			rs.close();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			logger.info("接JY合约数据，日期【"+statDate+"】-------------------异常      "+e.getMessage());
			logger.info("异常描述："+e.getStackTrace());
		}finally{
			SyncContractFromWind.closeConnection(rs, stmt, conn);
		}
		logger.info("接JY合约数据，日期【"+beginDate+"】到【"+endDate+"】------------------end");
	}
}
