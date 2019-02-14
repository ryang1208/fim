package com.huaxin.fim.util;

import com.huaxin.fim.entity.entity.Contract;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SyncContractFromWind {
	private static final Log logger = LogFactory.getLog(SyncContractFromWind.class);

	public static Connection getSqlServerConnection(String url, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		} catch (Exception ex) {
			logger.error("sqlserver驱动加载失败!", ex);
		}
		try {
			conn = DriverManager.getConnection(url, userName, password);
			logger.info("成功连接sqlserver数据库！");
			return conn;
		} catch (Exception e) {
			logger.error("连接sqlserver数据库失败!", e);
		}
		return null;
	}

	public static Connection getMySqlConnection(String url, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			logger.error("mysql驱动加载失败!", ex);
		}
		try {
			conn = DriverManager.getConnection(url, userName, password);
			logger.info("成功连接mysql数据库！");
			return conn;
		} catch (Exception e) {
			logger.error("连接mysql数据库失败!", e);
		}
		return null;
	}

	public static Connection getOracleConnection(String url, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (Exception ex) {
			logger.error("oracle驱动加载失败!", ex);
		}
		try {
			conn = DriverManager.getConnection(url, userName, password);
			logger.info("成功连接oracle数据库！");
			return conn;
		} catch (Exception e) {
			logger.error("连接oracle数据库失败!", e);
		}
		return null;
	}

	public static Connection getConnection(String dbType, String url, String userName, String password) {
		dbType = "sqlserver";
		url = "jdbc:sqlserver://192.168.101.156:1433; DatabaseName=WIND";
		userName = "wind";
		password = "Iwin@1234";
		Connection conn = null;
		if ("sqlserver".equals(dbType.toLowerCase()))
			conn = getSqlServerConnection(url, userName, password);
		if ("mysql".equals(dbType.toLowerCase()))
			conn = getMySqlConnection(url, userName, password);
		if ("oracle".equals(dbType.toLowerCase()))
			conn = getOracleConnection(url, userName, password);
		return conn;
	}

	public static void closeConnection(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			logger.error("关闭ResultSet异常", e);
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				logger.error("关闭Statement异常", e);
			} finally {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					logger.error("关闭数据库连接异常", e);
				}
			}
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			logger.error("关闭数据库连接异常", e);
		}
	}

	public static List<Contract> getContractListFromSqlServer(String statDate) {
		logger.info("接wind合约数据，日期【"+statDate+"】-------------------begin");
		Connection conn = SyncContractFromWind.getConnection(null, null, null, null);
		Statement stmt = null;
		List<Contract> cList = new ArrayList<Contract>();
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String lastYear = DATE.addDate(statDate, -1, 0, 0);
			String sql =" SELECT DISTINCT                                                                   "
					+"   p.trade_dt AS DATE,                                                             "
					+"   a.exchangeId,                                                                   "
					+"   a.contract,                                                                     "
					+"   a.varietyId,                                                                    "
					+"   a.contract_multiplier,                                                          "
					+"   a.currency,                                                                     "
					+"   a.assetType,                                                                    "
					+"   a.contractName,                                                                 "
					+"   c.INDUSTRIESNAME,                                                               "
					+"   CASE                                                                            "
					+"     WHEN p.s_dq_tradestatus = '停牌'                                              "
					+"     THEN '0'                                                                      "
					+"     ELSE '1'                                                                      "
					+"   END AS isSuspension,                                                            "
					+"   p.s_dq_preclose AS closePriceLastDay,                                           "
					+"   p.s_dq_open AS openPriceToday,                                                  "
					+"   p.s_dq_close AS priceToday,                                                     "
					+"   p.s_dq_close AS closePriceToday,                                                "
					+"   d.S_DQ_MV AS marketValue,                                                       "
					+"   d.S_VAL_PE_TTM AS peRatio,                                                      "
					+"   d.S_VAL_PB_NEW AS pbRatio,                                                      "
					+"   (SELECT                                                                         "
					+"     ISNULL(                                                                       "
					+"       CAST(                                                                       "
					+"         SUM(1 / S_PRICE_DIV_DPS) / 100 AS NUMERIC (16, 4)                         "
					+"       ),                                                                          "
					+"       0.00                                                                        "
					+"     )                                                                             "
					+"   FROM                                                                            "
					+"     wind.dbo.AShareEODDerivativeIndicator                                         "
					+"   WHERE S_INFO_WINDCODE = a.S_INFO_WINDCODE                                       "
					+"     AND TRADE_DT >= "+lastYear+"     AND trade_dt <= "+statDate+") dividendRatio,                                      "
					+"   a.S_INFO_LISTDATE listingDate,                                                  "
					+"   p.s_dq_pctchange dailyYieldRate,                                                "
					+"   (SELECT                                                                         "
					+"     top 1 s_fa_debttoassets                                                       "
					+"   FROM                                                                            "
					+"     wind.dbo.AShareFinancialIndicator                                             "
					+"   WHERE S_info_windcode = a.S_INFO_WINDCODE                                       "
					+"     AND ANN_DT < p.trade_dt                                                       "
					+"   ORDER BY ANN_DT DESC) assetDebtRatio,                                           "
					+"   (SELECT                                                                         "
					+"     top 1 s_fa_operateincome_ttm                                                  "
					+"   FROM                                                                            "
					+"     wind.dbo.ashareTTMHIS                                                         "
					+"   WHERE S_info_windcode = a.S_INFO_WINDCODE                                       "
					+"     AND report_period < p.trade_dt                                                "
					+"   ORDER BY report_period DESC) cashEarning,                                       "
					+"   (SELECT                                                                         "
					+"     top 1 s_fa_gr_ttm                                                             "
					+"   FROM                                                                            "
					+"     wind.dbo.ashareTTMHIS                                                         "
					+"   WHERE S_info_windcode = a.S_INFO_WINDCODE                                       "
					+"     AND report_period < p.trade_dt                                                "
					+"   ORDER BY report_period DESC) totalEarning,                                      "
					+"   p.s_dq_amount turnover                                                          "
					+" FROM                                                                              "
					+"   (SELECT                                                                         "
					+"     d.S_INFO_EXCHMARKET AS exchangeId,                                            "
					+"     d.S_INFO_CODE AS contract,                                                    "
					+"     d.S_INFO_CODE AS varietyId,                                                   "
					+"     1 AS contract_multiplier,                                                     "
					+"     d.CRNCY_CODE AS currency,                                                     "
					+"     5 AS assetType,                                                               "
					+"     d.S_INFO_NAME AS contractName,                                                "
					+"     d.S_INFO_WINDCODE,                                                            "
					+"     d.S_INFO_LISTDATE                                                             "
					+"   FROM                                                                            "
					+"     wind.dbo.AshareDescription d                                                  "
					+"   WHERE d.S_INFO_DELISTDATE IS NULL                                               "
					+"     AND d.S_INFO_EXCHMARKET IS NOT NULL) a                                        "
					+"   INNER JOIN wind.dbo.AshareSECNIndustriesClass ic                                "
					+"     ON a.S_INFO_WINDCODE = ic.S_INFO_WINDCODE                                     "
					+"   INNER JOIN wind.dbo.AshareIndustriesCode c                                      "
					+"     ON ic.SEC_IND_CODE = c.INDUSTRIESCODE                                         "
					+"     AND c.USED = 1                                                                "
					+"     AND ic.CUR_SIGN = 1                                                           "
					+"   INNER JOIN wind.dbo.ASHAREEODPRICES p                                           "
					+"     ON a.S_INFO_WINDCODE = p.S_INFO_WINDCODE                                      "
					+"     AND p.trade_dt = "+statDate+"                                                     "
					+"   LEFT JOIN wind.dbo.AShareEODDerivativeIndicator d                               "
					+"     ON a.S_INFO_WINDCODE = d.S_INFO_WINDCODE                                      "
					+"     AND d.TRADE_DT = "+statDate+"                                                     "
					+" WHERE a.contractName NOT LIKE '%(仿真)%'                                          "
					+" UNION                                                                             "
					+" ALL                                                                               "
					+" SELECT DISTINCT   "+statDate+" AS DATE,                               "
					+"   f.S_INFO_EXCHMARKET AS exchangeId,                                              "
					+"   f.S_INFO_CODE AS contract,                                                      "
					+"   f.FS_INFO_SCCODE AS varietyId,                                                  "
					+"   CASE                                                                            "
					+"     WHEN p.S_INFO_CEMULTIPLIER IS NULL                                            "
					+"     THEN CAST(p.S_INFO_PUNIT AS NUMERIC (20, 4))                                  "
					+"     ELSE CAST(                                                                    "
					+"       p.S_INFO_PUNIT * p.S_INFO_CEMULTIPLIER AS NUMERIC (20, 4)                   "
					+"     )                                                                             "
					+"   END AS contract_multiplier,                                                     "
					+"   'CNY' AS currency,                                                              "
					+"   1 AS assetType,                                                                 "
					+"   f.S_INFO_NAME AS contractName,                                                  "
					+"   NULL AS INDUSTRIESNAME,                                                         "
					+"   NULL AS isSuspension,                                                           "
					+"   CASE                                                                            "
					+"     WHEN fp.s_dq_presettle IS NOT NULL                                            "
					+"     THEN fp.s_dq_presettle                                                        "
					+"     ELSE ip.s_dq_presettle                                                        "
					+"   END AS closePriceLastDay,                                                       "
					+"   CASE                                                                            "
					+"     WHEN fp.s_dq_open IS NOT NULL                                                 "
					+"     THEN fp.s_dq_open                                                             "
					+"     ELSE ip.s_dq_open                                                             "
					+"   END AS openPriceToday,                                                          "
					+"   CASE                                                                            "
					+"     WHEN fp.s_dq_settle IS NOT NULL                                               "
					+"     THEN fp.s_dq_settle                                                           "
					+"     ELSE ip.s_dq_settle                                                           "
					+"   END AS priceToday,                                                              "
					+"   CASE                                                                            "
					+"     WHEN fp.s_dq_close IS NOT NULL                                                "
					+"     THEN fp.s_dq_close                                                            "
					+"     ELSE ip.s_dq_close                                                            "
					+"   END AS closePriceToday,                                                         "
					+"   NULL AS marketValue,                                                            "
					+"   NULL AS peRatio,                                                                "
					+"   NULL AS pbRatio,                                                                "
					+"   NULL AS dividendRatio,                                                          "
					+"   NULL AS listingDate,                                                            "
					+"   NULL AS dailyYieldRate,                                                         "
					+"   NULL AS assetDebtRatio,                                                         "
					+"   NULL AS cashEarning,                                                            "
					+"   NULL AS totalEarning,                                                           "
					+"   NULL AS turnover                                                                "
					+" FROM                                                                              "
					+"   wind.dbo.CFuturesDescription f                                                  "
					+"   INNER JOIN wind.dbo.CFuturescontpro p                                           "
					+"     ON f.FS_INFO_TYPE = 1                                                         "
					+"     AND f.S_INFO_WINDCODE = p.S_INFO_WINDCODE                                     "
					+"   LEFT JOIN                                                                       "
					+"     (SELECT DISTINCT                                                              "
					+"       td.S_INFO_WINDCODE,                                                         "
					+"       s_dq_presettle,                                                             "
					+"       td.s_dq_settle,                                                             "
					+"       td.s_dq_close,                                                              "
					+"       td.s_dq_open                                                                "
					+"     FROM                                                                          "
					+"       wind.dbo.CCOMMODITYFUTURESEODPRICES td                                      "
					+"     WHERE trade_dt = "+statDate+"                                 "
					+"       AND td.OPDATE =                                                             "
					+"       (SELECT                                                                     "
					+"         MAX(OPDATE)                                                               "
					+"       FROM                                                                        "
					+"         wind.dbo.CCOMMODITYFUTURESEODPRICES t1                                    "
					+"       WHERE td.S_INFO_WINDCODE = t1.S_INFO_WINDCODE                               "
					+"         AND t1.trade_dt = "+statDate+")) fp                             "
					+"     ON fp.S_INFO_WINDCODE = f.S_INFO_WINDCODE                                     "
					+"   LEFT JOIN wind.dbo.CIndexFuturesEODPrices ip                                    "
					+"     ON f.S_INFO_WINDCODE = ip.S_INFO_WINDCODE                                     "
					+"     AND ip.trade_dt = "+statDate+"                                      "
					+" WHERE f.S_INFO_NAME NOT LIKE '%(仿真)%'                                           "
					+" UNION                                                                             "
					+" ALL                                                                               "
					+" SELECT DISTINCT   "+statDate+" AS DATE,                               "
					+"   CASE                                                                            "
					+"     p.S_INFO_EXNAME                                                               "
					+"     WHEN '深交所'                                                                 "
					+"     THEN 'SZSE'                                                                   "
					+"     WHEN '上交所'                                                                 "
					+"     THEN 'SSE'                                                                    "
					+"     WHEN '大商所'                                                                 "
					+"     THEN 'DCE'                                                                    "
					+"     WHEN '上期所'                                                                 "
					+"     THEN 'SHFE'                                                                   "
					+"     WHEN '郑商所'                                                                 "
					+"     THEN 'CZCE'                                                                   "
					+"     WHEN '中金所'                                                                 "
					+"     THEN 'CFFEX'                                                                  "
					+"     ELSE NULL                                                                     "
					+"   END AS exchangeId,                                                              "
					+"   i.S_INFO_CODE AS contract,                                                      "
					+"   CASE                                                                            "
					+"     WHEN p.S_INFO_EXNAME = '深交所'                                               "
					+"     OR p.S_INFO_EXNAME = '上交所'                                                 "
					+"     THEN i.S_INFO_CODE                                                            "
					+"     WHEN p.S_INFO_EXNAME = '中金所'                                               "
					+"     THEN p.S_INFO_CODE                                                            "
					+"     ELSE c.S_INFO_CODE                                                            "
					+"   END AS varietyId,                                                               "
					+"   CASE                                                                            "
					+"     WHEN p.S_INFO_STRIKERATIO IS NOT NULL                                         "
					+"     THEN p.S_INFO_STRIKERATIO                                                     "
					+"     ELSE p.S_INFO_COUNIT                                                          "
					+"   END AS contract_multiplier,                                                     "
					+"   'CNY' AS currency,                                                              "
					+"   '2' AS assetType,                                                               "
					+"   i.S_INFO_NAME AS contractName,                                                  "
					+"   NULL AS INDUSTRIESNAME,                                                         "
					+"   NULL AS isSuspension,                                                           "
					+"   cp.S_DQ_OPEN AS openPriceToday,                                                 "
					+"   cp.S_DQ_PRESETTLE AS closePriceLastDay,                                         "
					+"   cp.S_DQ_SETTLE AS priceToday,                                                   "
					+"   cp.S_DQ_CLOSE AS closePriceToday,                                               "
					+"   NULL AS marketValue,                                                            "
					+"   NULL AS peRatio,                                                                "
					+"   NULL AS pbRatio,                                                                "
					+"   NULL AS dividendRatio,                                                          "
					+"   NULL AS listingDate,                                                            "
					+"   NULL AS dailyYieldRate,                                                         "
					+"   NULL AS assetDebtRatio,                                                         "
					+"   NULL AS cashEarning,                                                            "
					+"   NULL AS totalEarning,                                                           "
					+"   NULL AS turnover                                                                "
					+" FROM                                                                              "
					+"   wind.dbo.ChinaOptionDescription i                                               "
					+"   INNER JOIN wind.dbo.ChinaOptionContpro p                                        "
					+"     ON i.S_INFO_SCCODE = p.S_INFO_CODE                                            "
					+"   LEFT JOIN wind.dbo.CFUTURESCONTPRO c                                            "
					+"     ON c.S_INFO_WINDCODE = p.S_INFO_WINDCODE                                      "
					+"   LEFT JOIN wind.dbo.CHINAOPTIONEODPRICES cp                                      "
					+"     ON cp.S_INFO_WINDCODE = i.S_INFO_WINDCODE                                     "
					+"     AND cp.trade_dt =  "+statDate+"                                      "
					+" WHERE i.S_INFO_NAME NOT LIKE '%(仿真)%'                                           ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String date = rs.getString("date");
				String exchangeId = rs.getString("exchangeId");
				String contract = rs.getString("contract");
				String varietyId = rs.getString("varietyId");
				String contract_multiplier = rs.getString("contract_multiplier");
				String currency = rs.getString("currency");
				String assetType = rs.getString("assetType");
				String contractName = rs.getString("contractName");
				String industry = rs.getString("INDUSTRIESNAME");
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
				// System.out.print("date:" + date);
				// System.out.print(", exchangeId: " + exchangeId);
				// System.out.print(", contract: " + contract);
				// System.out.print(", varietyId: " + varietyId);
				// System.out.print(", contract_multiplier: " +
				// contract_multiplier);
				// System.out.print(", currency: " + currency);
				// System.out.print(", assetType: " + assetType);
				// System.out.print(", contractName: " + contractName);
				// System.out.print(", INDUSTRIESNAME: " + industry);
				// System.out.print(", isSuspension: " + isSuspension);
				// System.out.print(", closePriceLastDay: " +
				// closePriceLastDay);
				// System.out.print(", openPriceToday: " + openPriceToday);
				// System.out.print(", priceToday: " + priceToday);
				// System.out.print(", closePriceToday: " + closePriceToday);
				// System.out.print(", marketValue: " + marketValue);
				// System.out.print(", peRatio: " + peRatio);
				// System.out.print(", dividendRatio: " + dividendRatio);
				// System.out.print(", listingDate: " + listingDate);
				// System.out.print(", dailyYieldRate: " + dailyYieldRate);
				// System.out.print(", assetDebtRatio: " + assetDebtRatio);
				// System.out.print(", cashEarning: " + cashEarning);
				// System.out.print(", totalEarning: " + totalEarning);
				// System.out.println(", turnover: " + turnover);
				//
				Contract c = new Contract();
				c.setDate(date);
				c.setExchangeId(exchangeId);
				c.setContract(contract);
				c.setVarietyId(varietyId);
				c.setContract_multiplier(!StringUtils.isEmpty(contract_multiplier) ? new BigDecimal(contract_multiplier) : null);
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
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("接wind合约数据，日期【"+statDate+"】-------------------异常");
			return null;
		}finally{
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		logger.info("接wind合约数据，日期【"+statDate+"】-------------------end");
		return cList;
	}
}
