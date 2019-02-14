package com.huaxin.fim.util;


import com.huaxin.fim.entity.entity.InvesterFund;
import com.huaxin.fim.entity.entity.PositionSummary;
import com.huaxin.fim.entity.entity.ProductIndustryPeriodStatistics;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculate {

	//计算风险度均值
	public static ProductPeriodKPIStatistics calculateProductPeriodByAverage(List<InvesterFund> list, ProductPeriodKPIStatistics productPeriod){
		String today = productPeriod.getDate();
		BigDecimal untilNowEquity = BigDecimal.ZERO;
		int untilNowCount = 0;
		for(InvesterFund calPeriod:list){
			String date = calPeriod.getDate();
			// 成立以来
			if(Integer.valueOf(date)<=Integer.valueOf(today)){
				if (calPeriod.getRiskDegree().doubleValue() > 0) {
					untilNowEquity = untilNowEquity.add(calPeriod.getRiskDegree());
				}
				untilNowCount ++;
			}
		}
		
		if (untilNowCount !=0) {
			productPeriod.setUntilNow(untilNowEquity.divide(new BigDecimal(untilNowCount), 8, BigDecimal.ROUND_HALF_UP));
		}
		return productPeriod;
	}
	
	//计算行业涨跌幅
	public static ProductIndustryPeriodStatistics calculateStockIndustryUpDown(List<PositionSummary> list, ProductIndustryPeriodStatistics industryPeriod){
		String today = industryPeriod.getDate();
		String industry =industryPeriod.getIndustry();
		//样本数据		
		List<PositionSummary> oneMonthList = new ArrayList<>();
		List<PositionSummary> threeMonthList = new ArrayList<>();
		List<PositionSummary> sixMonthList = new ArrayList<>();
		List<PositionSummary> oneYearList = new ArrayList<>();
		List<PositionSummary> thisYearList = new ArrayList<>();
		List<PositionSummary> untilNowList = new ArrayList<>();
		
		String oneMonth = DATE.addThreadDate(today, 0, -1, 0);
		String threeMonth = DATE.addThreadDate(today, 0, -3, 0);
		String sixMonth = DATE.addThreadDate(today, 0, -6, 0);
		String oneYear = DATE.addThreadDate(today, -1, 0, 0);
		String thisYear = DATE.addThreadDate(today, -1, 0, 0).substring(0,4).concat("1231");
				
		BigDecimal oneMonthEntry = BigDecimal.ZERO;
		BigDecimal threeMonthEntry = BigDecimal.ZERO;
		BigDecimal sixMonthEntry = BigDecimal.ZERO;
		BigDecimal oneYearEntry = BigDecimal.ZERO;
		BigDecimal thisYearEntry = BigDecimal.ZERO;
		BigDecimal untilNowEntry = BigDecimal.ZERO;
		
		
		for (int i = 0; i < list.size(); i++) {
			String date = list.get(i).getDate();
			String Industry = list.get(i).getIndustry();
			// 近1月		
			if(Integer.valueOf(date)>Integer.valueOf(oneMonth) && Integer.valueOf(date)<=Integer.valueOf(today)
					&& Industry.equals(industry)){
				oneMonthList.add(list.get(i));
			}
			// 近3月
			if(Integer.valueOf(date)>Integer.valueOf(threeMonth) && Integer.valueOf(date)<=Integer.valueOf(today)
					&& Industry.equals(industry)){
				threeMonthList.add(list.get(i));
			}
			// 近6月
			if(Integer.valueOf(date)>Integer.valueOf(sixMonth) && Integer.valueOf(date)<=Integer.valueOf(today)
					&& Industry.equals(industry)){
				sixMonthList.add(list.get(i));
			}
			
			// 近1年
			if(Integer.valueOf(date)>Integer.valueOf(oneYear) && Integer.valueOf(date)<=Integer.valueOf(today)
					&& Industry.equals(industry)){
				oneYearList.add(list.get(i));
			}
			// 今年
			if(Integer.valueOf(date)>Integer.valueOf(thisYear) && Integer.valueOf(date)<=Integer.valueOf(today)
					&& Industry.equals(industry)){
				thisYearList.add(list.get(i));
			}
			// 成立以来
			if(Integer.valueOf(date)<=Integer.valueOf(today) && Industry.equals(industry)){
				untilNowList.add(list.get(i));
			}	 
		}
		
		if (oneMonthList.get(0).getMarketCapitalization().doubleValue() != 0) {
			oneMonthEntry = (oneMonthList.get(oneMonthList.size()-1).getMarketCapitalization().subtract(oneMonthList.get(0).getMarketCapitalization()).
					divide(oneMonthList.get(0).getMarketCapitalization(), 8, BigDecimal.ROUND_HALF_UP));
		}
		if (threeMonthList.get(0).getMarketCapitalization().doubleValue() != 0) {
			threeMonthEntry = (threeMonthList.get(threeMonthList.size()-1).getMarketCapitalization().subtract(threeMonthList.get(0).getMarketCapitalization()).
					divide(threeMonthList.get(0).getMarketCapitalization(), 8, BigDecimal.ROUND_HALF_UP));
		}
		if (sixMonthList.get(0).getMarketCapitalization().doubleValue() != 0) {
			sixMonthEntry = (sixMonthList.get(sixMonthList.size()-1).getMarketCapitalization().subtract(sixMonthList.get(0).getMarketCapitalization()).
					divide(sixMonthList.get(0).getMarketCapitalization(), 8, BigDecimal.ROUND_HALF_UP));
		}
		if (oneYearList.get(0).getMarketCapitalization().doubleValue() != 0) {
			oneYearEntry = (oneYearList.get(oneYearList.size()-1).getMarketCapitalization().subtract(oneYearList.get(0).getMarketCapitalization()).
					divide(oneYearList.get(0).getMarketCapitalization(), 8, BigDecimal.ROUND_HALF_UP));
		}
		if (thisYearList.get(0).getMarketCapitalization().doubleValue() != 0) {
			thisYearEntry = (thisYearList.get(thisYearList.size()-1).getMarketCapitalization().subtract(thisYearList.get(0).getMarketCapitalization()).
					divide(thisYearList.get(0).getMarketCapitalization(), 8, BigDecimal.ROUND_HALF_UP));
		}
		if (untilNowList.get(0).getMarketCapitalization().doubleValue() != 0) {
			untilNowEntry = (untilNowList.get(untilNowList.size()-1).getMarketCapitalization().subtract(untilNowList.get(0).getMarketCapitalization()).
					divide(untilNowList.get(0).getMarketCapitalization(), 8, BigDecimal.ROUND_HALF_UP));
		}
		
		industryPeriod.setToday(null);
		industryPeriod.setOneMonth(oneMonthEntry);
		industryPeriod.setThreeMonth(threeMonthEntry);
		industryPeriod.setSixMonth(sixMonthEntry);
		industryPeriod.setOneYear(oneYearEntry);
		industryPeriod.setThisYear(thisYearEntry);
		industryPeriod.setUntilNow(untilNowEntry);	
		
		return industryPeriod;
	}
}
