package com.huaxin.fim.util;

import com.dev.framework.core.configure.ConfigureProperties;
import com.huaxin.fim.dao.IndexContentDao;
import com.huaxin.fim.entity.entity.IndexContent;
import com.huaxin.fim.repository.IndexContentRepository;
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

public class SyncIndexContentFromJY {
	private static final Log logger = LogFactory.getLog(SyncIndexContentFromJY.class);
	
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

	public static void getIndexContenttListFromSqlServer(String beginDate,String endDate) {
		IndexContentRepository indexContentRepository = (IndexContentRepository) SpringUtils.getBean("indexContentRepository");
		IndexContentDao indexContentDao = (IndexContentDao) SpringUtils.getBean("indexContentDao");
		logger.info("接JY合约数据，日期【"+beginDate+"】到【"+endDate+"】-------------------begin");
		Connection conn = SyncIndexContentFromJY.getConnection(null, null, null, null);
		Statement stmt = null;
		ResultSet rs = null;
		String statDate = beginDate;
		try {
			stmt = conn.createStatement();
			while (!DATE.isAfter(DATE.threadParse(statDate, "yyyyMMdd"), DATE.threadParse(endDate, "yyyyMMdd"))) {
				List<IndexContent> cList = new ArrayList<IndexContent>();
				// 1、接聚源指数数据
				String sql ="select                                                                                                               "
					+"  CONVERT(varchar(10),d.TradingDay ,112) date,                                                                       "
					+"  '000300' indexId, c.FirstIndustryName industry,                                                                    "
					+"  cast((sum(d.ClosePrice) - sum(d.PrevClosePrice))/sum(d.PrevClosePrice) as numeric(16,4)) as baseYieldRate ,        "
					+"  cast(sum(a.Weight) as numeric(16,4)) baseWeight                                                                    "
					+"from (select * from QT_DailyQuote                                                                                    "
					+"where InnerCode in (select InnerCode                                                                                 "
					+"			from LC_IndexComponentsWeight                                                                              "
					+"			where IndexCode = (select InnerCode from SecuMain where SecuCode = '000300' and SecuMarket = '83')         "
					+"			and CONVERT(varchar(10), EndDate, 112)  = (select                                                          "
					+"				top 1 CONVERT(varchar(10), EndDate, 112)                                                               "
					+"				from LC_IndexComponentsWeight                                                                          "
					+"				where IndexCode = (select InnerCode from SecuMain where SecuCode = '000300' and SecuMarket = '83')     "
					+"				order by CONVERT(varchar(10), EndDate, 112) desc))                                                     "
					+"	and CONVERT(varchar(10), TradingDay, 112) ='"+statDate+"'	)d                                                                                                                 "
					+"left join (select * from LC_IndexComponentsWeight                                                                    "
					+"			where IndexCode = (select                                                                                  "
					+"				InnerCode                                                                                              "
					+"				from SecuMain                                                                                          "
					+"				where SecuCode = '000300' and SecuMarket = '83')                                                       "
					+"			and CONVERT(varchar(10), EndDate, 112) = (select                                                           "
					+"				top 1 CONVERT(varchar(10), EndDate, 112)                                                               "
					+"				from LC_IndexComponentsWeight                                                                          "
					+"				where IndexCode = (select InnerCode from SecuMain where SecuCode = '000300' and SecuMarket = '83')     "
					+"				order by CONVERT(varchar(10), EndDate, 112) desc)                                                      "
					+"	)a on a.InnerCode = d.InnerCode                                                                                    "
					+" LEFT JOIN SecuMain s ON a.InnerCode = s.InnerCode                                                                   "
					+" LEFT JOIN (select * from (                                                                                          "
					+"	select ROW_NUMBER() over(partition by d.CompanyCode order by d.CompanyCode,d.InfoPublDate desc) pid, *             "
					+"	from LC_ExgIndustry d                                                                                              "
					+"	where d.Standard = '24'                                                                                            "
					+"	and d.InfoPublDate <= '"+statDate+"')X                                                                               "
					+"	where pid = 1                                                                                                      "
					+"	) c ON s.CompanyCode = c.CompanyCode                                                                               "
					+"where                                                                                                                "
					+"  CONVERT(varchar(10), d.TradingDay, 112) ='"+statDate+"' group by d.TradingDay,c.FirstIndustryName "
					+"  UNION                                                                     "
					+"  ALL                                                                       "
					+" select                                                                                                               "
					+"  CONVERT(varchar(10),d.TradingDay ,112) date,                                                                       "
					+"  '000905' indexId, c.FirstIndustryName industry,                                                                    "
					+"  cast((sum(d.ClosePrice) - sum(d.PrevClosePrice))/sum(d.PrevClosePrice) as numeric(16,4)) as baseYieldRate ,        "
					+"  cast(sum(a.Weight) as numeric(16,4)) baseWeight                                                                    "
					+"from (select * from QT_DailyQuote                                                                                    "
					+"where InnerCode in (select InnerCode                                                                                 "
					+"			from LC_IndexComponentsWeight                                                                              "
					+"			where IndexCode = (select InnerCode from SecuMain where SecuCode = '000905' and SecuMarket = '83')         "
					+"			and CONVERT(varchar(10), EndDate, 112)  = (select                                                          "
					+"				top 1 CONVERT(varchar(10), EndDate, 112)                                                               "
					+"				from LC_IndexComponentsWeight                                                                          "
					+"				where IndexCode = (select InnerCode from SecuMain where SecuCode = '000905' and SecuMarket = '83')     "
					+"				order by CONVERT(varchar(10), EndDate, 112) desc))                                                     "
					+"	and CONVERT(varchar(10), TradingDay, 112) ='"+statDate+"'	)d                                                                                                                 "
					+"left join (select * from LC_IndexComponentsWeight                                                                    "
					+"			where IndexCode = (select                                                                                  "
					+"				InnerCode                                                                                              "
					+"				from SecuMain                                                                                          "
					+"				where SecuCode = '000905' and SecuMarket = '83')                                                       "
					+"			and CONVERT(varchar(10), EndDate, 112) = (select                                                           "
					+"				top 1 CONVERT(varchar(10), EndDate, 112)                                                               "
					+"				from LC_IndexComponentsWeight                                                                          "
					+"				where IndexCode = (select InnerCode from SecuMain where SecuCode = '000905' and SecuMarket = '83')     "
					+"				order by CONVERT(varchar(10), EndDate, 112) desc)                                                      "
					+"	)a on a.InnerCode = d.InnerCode                                                                                    "
					+" LEFT JOIN SecuMain s ON a.InnerCode = s.InnerCode                                                                   "
					+" LEFT JOIN (select * from (                                                                                          "
					+"	select ROW_NUMBER() over(partition by d.CompanyCode order by d.CompanyCode,d.InfoPublDate desc) pid, *             "
					+"	from LC_ExgIndustry d                                                                                              "
					+"	where d.Standard = '24'                                                                                            "
					+"	and d.InfoPublDate <= '"+statDate+"')X                                                                               "
					+"	where pid = 1                                                                                                      "
					+"	) c ON s.CompanyCode = c.CompanyCode                                                                               "
					+"where                                                                                                                "
					+"  CONVERT(varchar(10), d.TradingDay, 112) ='"+statDate+"' group by d.TradingDay,c.FirstIndustryName";
				rs = stmt.executeQuery(sql);
	
				while (rs.next()) {
					String date = rs.getString("date");
					String indexId = rs.getString("indexId");
					String industry = rs.getString("industry");
					String baseYieldRate = rs.getString("baseYieldRate");
					String baseWeight = rs.getString("baseWeight");
					IndexContent c = new IndexContent();
					c.setDate(date);
					c.setIndexId(indexId);
					c.setIndustry(industry);
					c.setBaseYieldRate(!StringUtils.isEmpty(baseYieldRate) ? new BigDecimal(baseYieldRate) : null);
					c.setBaseWeight(!StringUtils.isEmpty(baseWeight) ? new BigDecimal(baseWeight) : null);
					cList.add(c);
				}
				// 2、删除当日合约
				indexContentRepository.delIndexContentByDate(statDate);
				// 3、保存入库
				indexContentDao.saveIndexContent(cList);
				statDate = DATE.addThreadDate(statDate, 0, 0, 1);
			}
			rs.close();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			logger.info("接JY指数标准数据，日期【"+statDate+"】-------------------异常      "+e.getMessage());
			logger.info("异常描述："+e.getStackTrace());
		}finally{
			SyncContractFromWind.closeConnection(rs, stmt, conn);
		}
		logger.info("接JY合约数据，日期【"+beginDate+"】到【"+endDate+"】------------------end");
	}
}
