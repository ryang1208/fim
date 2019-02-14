package com.huaxin.fim.util;

import com.huaxin.fim.entity.entity.Index;
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

public class SyncIndexFromWind {
	private static final Log logger = LogFactory.getLog(SyncIndexFromWind.class);

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

	public static List<Index> getContractListFromSqlServer(String statDate) {
		logger.info("接wind合约数据，日期【"+statDate+"】-------------------begin");
		Connection conn = SyncIndexFromWind.getConnection(null, null, null, null);
		Statement stmt = null;
		List<Index> indexList = new ArrayList<Index>();
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql ="  SELECT DISTINCT                                                             "
						+"    i.TRADE_DT AS date,                                                       "
						+"    '000905' AS indexId,                                                      "
						+"    '中证500' AS indexName,                                                   "
						+"    i.S_DQ_CLOSE AS closePrice,                                               "
						+"    CAST(                                                                     "
						+"      (i.S_DQ_CLOSE - i.S_DQ_PRECLOSE) / i.S_DQ_PRECLOSE AS NUMERIC (16, 4) "
						+"    ) AS dailyYieldRate,                                                    "
						+"    c.S_DQ_CLOSE AS IFICPrice                                               "
						+"  FROM                                                                      "
						+"    wind.dbo.AIndexEODPrices i                                              "
						+"    LEFT JOIN CINDEXFUTURESEODPRICES c                                      "
						+"      ON i.TRADE_DT = c.TRADE_DT                                            "
						+"      AND c.S_INFO_WINDCODE = 'IC00.CFE'                                    "
						+"  WHERE i.TRADE_DT = "+statDate +"    AND i.S_INFO_WINDCODE = '000905.SH'                                     "
						+"  UNION                                                                     "
						+"  ALL                                                                       "
						+"  SELECT DISTINCT                                                           "
						+"    i.TRADE_DT AS date,                                                     "
						+"    '000300' AS indexId,                                                    "
						+"    '沪深300' AS indexName,                                                 "
						+"    i.S_DQ_CLOSE AS closePrice,                                             "
						+"    CAST(                                                                   "
						+"      (i.S_DQ_CLOSE - i.PRE_CLOSE) / i.PRE_CLOSE AS NUMERIC (16, 4)         "
						+"    ) AS dailyYieldRate,                                                    "
						+"    c.S_DQ_CLOSE AS IFICPrice                                               "
						+"  FROM                                                                      "
						+"    WIND.dbo.HS300IEODPRICES i                                              "
						+"    LEFT JOIN CINDEXFUTURESEODPRICES c                                      "
						+"      ON i.TRADE_DT = c.TRADE_DT                                            "
						+"      AND c.S_INFO_WINDCODE = 'IF00.CFE'                                    "
						+"  WHERE i.S_INFO_WINDCODE = '000300.SH'                                     "
						+"    AND i.TRADE_DT = "+statDate;
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String date = rs.getString("date");
				String indexId = rs.getString("indexId");
				String indexName = rs.getString("indexName");
				String closePrice = rs.getString("closePrice");
				String dailyYieldRate = rs.getString("dailyYieldRate");
				String IFICPrice = rs.getString("IFICPrice");
				Index index = new Index();
				index.setDate(date);
				index.setIndexId(indexId);
				index.setIndexName(indexName);
				index.setClosePrice(!StringUtils.isEmpty(closePrice) ? new BigDecimal(closePrice) : null);
				index.setDailyYieldRate(!StringUtils.isEmpty(dailyYieldRate) ? new BigDecimal(dailyYieldRate) : null);
				index.setIFICPrice(!StringUtils.isEmpty(IFICPrice) ? new BigDecimal(IFICPrice) : null);
				indexList.add(index);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("接wind行情数据，日期【"+statDate+"】-------------------异常");
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
		logger.info("接wind行情数据，日期【"+statDate+"】-------------------end");
		return indexList;
	}
}
