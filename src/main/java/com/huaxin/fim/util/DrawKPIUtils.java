package com.huaxin.fim.util;


import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.entity.enums.dictionary.KPIConstant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawKPIUtils {

	public static ProductPeriodKPIStatistics calculateMaxRetracementValue(List<ProductPeriodKPIStatistics> list, ProductPeriodKPIStatistics varietyPeriod){
		String today = varietyPeriod.getDate();
		//样本数据		
		List<ProductPeriodKPIStatistics> oneMonthList = new ArrayList<>();
		List<ProductPeriodKPIStatistics> threeMonthList = new ArrayList<>();
		List<ProductPeriodKPIStatistics> sixMonthList = new ArrayList<>();
		List<ProductPeriodKPIStatistics> oneYearList = new ArrayList<>();
		List<ProductPeriodKPIStatistics> thisYearList = new ArrayList<>();
		List<ProductPeriodKPIStatistics> untilNowList = new ArrayList<>();
		
		BigDecimal oneMonthcompare = BigDecimal.ZERO;
		BigDecimal threeMonthcompare = BigDecimal.ZERO;
		BigDecimal sixMonthcompare = BigDecimal.ZERO;
		BigDecimal oneYearcompare = BigDecimal.ZERO;
		BigDecimal thisYearcompare = BigDecimal.ZERO;
		BigDecimal untilNowcompare = BigDecimal.ZERO;
		
		//回撤最大值
		BigDecimal oneMonthDrawDowncompare = BigDecimal.ZERO;
		BigDecimal threeMonthDrawDowncompare = BigDecimal.ZERO;
		BigDecimal sixMonthDrawDowncompare = BigDecimal.ZERO;
		BigDecimal oneYearDrawDowncompare = BigDecimal.ZERO;
		BigDecimal thisYearDrawDowncompare = BigDecimal.ZERO;
		BigDecimal untilNowDrawDowncompare = BigDecimal.ZERO;
		
		
		String oneMonth = DATE.addThreadDate(today, 0, -1, 0);
		String threeMonth = DATE.addThreadDate(today, 0, -3, 0);
		String sixMonth = DATE.addThreadDate(today, 0, -6, 0);
		String oneYear = DATE.addThreadDate(today, -1, 0, 0);
		String thisYear = DATE.addThreadDate(today, -1, 0, 0).substring(0,4).concat("1231");
		
		
		for (int i = 0; i < list.size(); i++) {
			String date = list.get(i).getDate();
			// 近1月		
			if(Integer.valueOf(date)>Integer.valueOf(oneMonth) && Integer.valueOf(date)<=Integer.valueOf(today)){
				oneMonthList.add(list.get(i));
			}
			// 近3月
			if(Integer.valueOf(date)>Integer.valueOf(threeMonth) && Integer.valueOf(date)<=Integer.valueOf(today) ){
				threeMonthList.add(list.get(i));
			}
			// 近6月
			if(Integer.valueOf(date)>Integer.valueOf(sixMonth) && Integer.valueOf(date)<=Integer.valueOf(today)){
				sixMonthList.add(list.get(i));
			}
			
			// 近1年
			if(Integer.valueOf(date)>Integer.valueOf(oneYear) && Integer.valueOf(date)<=Integer.valueOf(today)){
				oneYearList.add(list.get(i));
			}
			// 今年
			if(Integer.valueOf(date)>Integer.valueOf(thisYear) && Integer.valueOf(date)<=Integer.valueOf(today)){
				thisYearList.add(list.get(i));
			}
			// 成立以来
			if(Integer.valueOf(date)<=Integer.valueOf(today)){
				untilNowList.add(list.get(i));
			}	 
		}
		
		//净值差额和最小值
		BigDecimal oneMonthMin = oneMonthList.get(0).getToday();
		BigDecimal threeMonthMin = threeMonthList.get(0).getToday();
		BigDecimal sixMonthMin = sixMonthList.get(0).getToday();
		BigDecimal oneYearMin = oneYearList.get(0).getToday();
		BigDecimal thisYearMin = thisYearList.get(0).getToday();
		BigDecimal untilNowMin =  untilNowList.get(0).getToday();
		
		//净值差额和最大值
		BigDecimal oneMonthMaxSum = oneMonthList.get(0).getToday();
		BigDecimal threeMonthMaxSum = threeMonthList.get(0).getToday();
		BigDecimal sixMonthMaxSum = sixMonthList.get(0).getToday();
		BigDecimal oneYearMaxSum = oneYearList.get(0).getToday();
		BigDecimal thisYearMaxSum = thisYearList.get(0).getToday();
		BigDecimal untilNowMaxSum = untilNowList.get(0).getToday();
		
		//最大回撤对应最低点净值
		BigDecimal oneMonthNetValue = BigDecimal.ZERO;
		BigDecimal threeMonthNetValue = BigDecimal.ZERO;
		BigDecimal sixMonthNetValue = BigDecimal.ZERO;
		BigDecimal oneYearNetValue = BigDecimal.ZERO;
		BigDecimal thisYearNetValue = BigDecimal.ZERO;
		BigDecimal untilNowNetValue = BigDecimal.ZERO;
		
		//最大回撤对应最高点净值
		BigDecimal oneMonthMaxNetValue = oneMonthList.get(0).getNetAccumulativeValue();
		BigDecimal threeMonthMaxNetValue =threeMonthList.get(0).getNetAccumulativeValue();
		BigDecimal sixMonthMaxNetValue = sixMonthList.get(0).getNetAccumulativeValue();
		BigDecimal oneYearMaxNetValue = oneYearList.get(0).getNetAccumulativeValue();
		BigDecimal thisYearMaxNetValue = thisYearList.get(0).getNetAccumulativeValue();
		BigDecimal untilNowMaxNetValue = untilNowList.get(0).getNetAccumulativeValue();
		
		//净值差额和最小值对应日期
		String oneMonthDate = oneMonthList.get(0).getDate();
		String threeMonthDate = threeMonthList.get(0).getDate();
		String sixMonthDate = sixMonthList.get(0).getDate();
		String oneYearDate = oneYearList.get(0).getDate();
		String thisYearDate = thisYearList.get(0).getDate();
		String untilNowDate = untilNowList.get(0).getDate();
		
		//回撤
		BigDecimal oneMonthDrawDown = BigDecimal.ZERO;
		BigDecimal threeMonthDrawDown = BigDecimal.ZERO;
		BigDecimal sixMonthDrawDown = BigDecimal.ZERO;
		BigDecimal oneYearDrawDown = BigDecimal.ZERO;
		BigDecimal thisYearDrawDown = BigDecimal.ZERO;
		BigDecimal untilNowDrawDown = BigDecimal.ZERO;
		
		int oneMonthMaxNetValueCount = 0;
		int threeMonthMaxNetValueCount = 0;
		int sixMonthMaxNetValueCount = 0;
		int oneYearMaxNetValueCount = 0;
		int thisYearMaxNetValueCount = 0;
		int untilNowMaxNetValueCount = 0;
		
		int oneMonthMaxDrawDownFormactionCount = 0;
		int threeMonthMaxDrawDownFormactionCount = 0;
		int sixMonthMaxDrawDownFormactionCount = 0;
		int oneYearMaxDrawDownFormactionCount = 0;
		int thisYearMaxDrawDownFormactionCount = 0;
		int untilNowMaxDrawDownFormactionCount = 0;
		
		int oneMonthMinNetValueCount = 0;
		int threeMonthMinNetValueCount = 0;
		int sixMonthMinNetValueCount = 0;		
		int oneYearMinNetValueCount = 0;
		int thisYearMinNetValueCount = 0;
		int untilNowMinNetValueCount = 0;
		
		BigDecimal oneMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
		BigDecimal threeMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
		BigDecimal sixMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
		BigDecimal oneYearMinDrawDownFormactionCount = BigDecimal.ZERO;
		BigDecimal thisYearMinDrawDownFormactionCount = BigDecimal.ZERO;
		BigDecimal untilNowMinDrawDownFormactionCount = BigDecimal.ZERO;
		
		boolean isoneMonthCount = true;
		boolean isthreeMonthCount = true;
		boolean issixMonthCount = true;
		boolean isoneYearCount = true;
		boolean isthisYearCount = true;
		boolean isuntilNowCount = true;
		
			
		for (int i = 0; i < oneMonthList.size(); i++) {
			oneMonthcompare = oneMonthcompare.add(oneMonthList.get(i).getToday()); 
            if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
            		|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
            	//净值最大值
            	if (oneMonthcompare.doubleValue() > oneMonthMaxSum.doubleValue()){  
    				oneMonthMaxSum = oneMonthcompare;
    				oneMonthMin = oneMonthMaxSum;
    				oneMonthMaxNetValue = oneMonthList.get(i).getNetAccumulativeValue(); 
    				oneMonthMaxNetValueCount = i;    				
    				if(!isoneMonthCount){
    					oneMonthMinDrawDownFormactionCount = new BigDecimal((double)(i - oneMonthMinNetValueCount));
    				}
    				isoneMonthCount = true;
				}
				if (oneMonthcompare.doubleValue() < oneMonthMin.doubleValue()) {
    				oneMonthMin = oneMonthcompare;  
    				oneMonthNetValue = oneMonthList.get(i).getNetAccumulativeValue();
    				oneMonthDate = oneMonthList.get(i).getDate();
    			}       	 
            	if (oneMonthList.get(i).getNetAccumulativeValue().doubleValue()>=oneMonthMaxNetValue.doubleValue()) {
            		oneMonthDrawDown = BigDecimal.ZERO;
				}else if(oneMonthList.get(i).getNetAccumulativeValue().doubleValue()<oneMonthMaxNetValue.doubleValue()
						&& oneMonthcompare.doubleValue()>=oneMonthMin.doubleValue()){
					oneMonthDrawDown = (oneMonthNetValue.subtract(oneMonthMaxNetValue)).divide(oneMonthMaxNetValue,8,BigDecimal.ROUND_HALF_UP);
				}
            	if (oneMonthDrawDown.doubleValue() < oneMonthDrawDowncompare.doubleValue()) {
            		oneMonthDrawDowncompare = oneMonthDrawDown;
            		oneMonthMaxDrawDownFormactionCount = i-oneMonthMaxNetValueCount;
            		oneMonthMinNetValueCount = i;
            		isoneMonthCount = false;
            		oneMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isoneMonthCount && oneMonthMinNetValueCount < i){
    				oneMonthMinDrawDownFormactionCount = new BigDecimal((double)oneMonthList.size() - 1 - oneMonthMinNetValueCount + 0.1);
    			}
			}	
		      // 水上最大回撤
		      if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//净值最大值
		    	if ((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneMonthcompare.doubleValue() > oneMonthMaxSum.doubleValue())){  
					//净值差额最大值
					oneMonthMaxSum = oneMonthcompare;
					oneMonthMin = oneMonthMaxSum;
					oneMonthMaxNetValue = oneMonthList.get(i).getNetAccumulativeValue(); 
				}
				if ((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneMonthcompare.doubleValue() < oneMonthMin.doubleValue())) {
					oneMonthMin = oneMonthcompare;  
					oneMonthNetValue = oneMonthList.get(i).getNetAccumulativeValue();
					oneMonthDate = oneMonthList.get(i).getDate();
				}       	
		    	if ((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneMonthList.get(i).getNetAccumulativeValue().doubleValue()>=oneMonthMaxNetValue.doubleValue())) {
		    		oneMonthDrawDown = BigDecimal.ZERO;
				}else if((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneMonthList.get(i).getNetAccumulativeValue().doubleValue()<oneMonthMaxNetValue.doubleValue())
						&& oneMonthcompare.doubleValue()>=oneMonthMin.doubleValue()){
					oneMonthDrawDown =(oneMonthNetValue.subtract(oneMonthMaxNetValue)).divide(oneMonthMaxNetValue,8,BigDecimal.ROUND_HALF_UP);
				}
		    	if (oneMonthDrawDown.doubleValue() < oneMonthDrawDowncompare.doubleValue()) {
            		oneMonthDrawDowncompare = oneMonthDrawDown;
				}
			}
		    // 水下最大回撤
		    if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
		    		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
		    	//净值大于1无水下回撤
		    	if (oneMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					oneMonthMaxSum = oneMonthcompare;
					oneMonthMin = oneMonthMaxSum;
					oneMonthMaxNetValue = oneMonthList.get(i).getNetAccumulativeValue();
					oneMonthMaxNetValueCount = i;
					if(!isoneMonthCount){
    					oneMonthMinDrawDownFormactionCount = new BigDecimal((double)(i - oneMonthMinNetValueCount));
    				}
					isoneMonthCount = true;
				}
				if ((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (oneMonthcompare.doubleValue() < oneMonthMin.doubleValue())) {
					oneMonthMin = oneMonthcompare;  
					oneMonthNetValue = oneMonthList.get(i).getNetAccumulativeValue();
					oneMonthDate = oneMonthList.get(i).getDate();
				}       	
		    	if ((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (oneMonthList.get(i).getNetAccumulativeValue().doubleValue()>=oneMonthMaxNetValue.doubleValue())) {
		    		oneMonthDrawDown = BigDecimal.ZERO;
				}else if((oneMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (oneMonthList.get(i).getNetAccumulativeValue().doubleValue()<oneMonthMaxNetValue.doubleValue())
						&& oneMonthcompare.doubleValue()>=oneMonthMin.doubleValue()){
					oneMonthDrawDown = oneMonthNetValue.subtract(BigDecimal.ONE);
				}
		    	if (oneMonthDrawDown.doubleValue() < oneMonthDrawDowncompare.doubleValue()) {
            		oneMonthDrawDowncompare = oneMonthDrawDown;
            		oneMonthMaxDrawDownFormactionCount = i-oneMonthMaxNetValueCount;
            		oneMonthMinNetValueCount = i;
            		isoneMonthCount = false;
            		oneMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isoneMonthCount && oneMonthMinNetValueCount < i){
    				oneMonthMinDrawDownFormactionCount = new BigDecimal((double)oneMonthList.size() - 1 - oneMonthMinNetValueCount + 0.1);
    			}
			 }
			}
					
			for (int i = 0; i < threeMonthList.size(); i++) {
				threeMonthcompare = threeMonthcompare.add(threeMonthList.get(i).getToday());	
				if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
						|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
					//回去净值差额最小值和最大值
					if (threeMonthcompare.doubleValue() > threeMonthMaxSum.doubleValue()){
						threeMonthMaxSum = threeMonthcompare;
						threeMonthMin = threeMonthMaxSum;
						threeMonthMaxNetValue = threeMonthList.get(i).getNetAccumulativeValue();
						threeMonthMaxNetValueCount = i;
						if(!isthreeMonthCount){
	    					threeMonthMinDrawDownFormactionCount = new BigDecimal((double)(i - threeMonthMinNetValueCount));
	    				}
						isthreeMonthCount = true;
					}
					if (threeMonthcompare.doubleValue() < threeMonthMin.doubleValue()) {
						threeMonthMin = threeMonthcompare; 
						threeMonthNetValue = threeMonthList.get(i).getNetAccumulativeValue();
						threeMonthDate =  threeMonthList.get(i).getDate();
					}
					
		        	if (threeMonthList.get(i).getNetAccumulativeValue().doubleValue()>=threeMonthMaxNetValue.doubleValue()) {
						threeMonthDrawDown = BigDecimal.ZERO;
					}else if(threeMonthList.get(i).getNetAccumulativeValue().doubleValue()<threeMonthMaxNetValue.doubleValue()
							&& threeMonthcompare.doubleValue()>=threeMonthMin.doubleValue()){
						threeMonthDrawDown = (threeMonthNetValue.subtract(threeMonthMaxNetValue)).divide(threeMonthMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
					}
		        	if (threeMonthDrawDown.doubleValue() < threeMonthDrawDowncompare.doubleValue()) {
		        		threeMonthDrawDowncompare = threeMonthDrawDown;
		        		threeMonthMaxDrawDownFormactionCount = i-threeMonthMaxNetValueCount;
		        		threeMonthMinNetValueCount = i;
		        		isthreeMonthCount = false;
		        		threeMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
					}
		        	if(!isthreeMonthCount && threeMonthMinNetValueCount < i){
		    			threeMonthMinDrawDownFormactionCount = new BigDecimal((double)threeMonthList.size() - 1 - threeMonthMinNetValueCount + 0.1);
		    		}
			}
			 // 水上最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//回撤净值差额最大值
		    	if ( (threeMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (threeMonthcompare.doubleValue() > threeMonthMaxSum.doubleValue())){  
					//净值差额最大值
					threeMonthMaxSum = threeMonthcompare;
					threeMonthMin = threeMonthMaxSum;
					threeMonthMaxNetValue = threeMonthList.get(i).getNetAccumulativeValue(); 
				}
				if ((threeMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (threeMonthcompare.doubleValue() < threeMonthMin.doubleValue())) {
					threeMonthMin = threeMonthcompare;  
					threeMonthNetValue = threeMonthList.get(i).getNetAccumulativeValue();
					threeMonthDate = threeMonthList.get(i).getDate();
				}       	
		    	if ((threeMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (threeMonthList.get(i).getNetAccumulativeValue().doubleValue()>=threeMonthMaxNetValue.doubleValue())) {
		    		threeMonthDrawDown = BigDecimal.ZERO;
				}else if((threeMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (threeMonthList.get(i).getNetAccumulativeValue().doubleValue()<threeMonthMaxNetValue.doubleValue())
						&& threeMonthcompare.doubleValue()>=threeMonthMin.doubleValue()){
					threeMonthDrawDown = (threeMonthNetValue.subtract(threeMonthMaxNetValue)).divide(threeMonthMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
		    	if (threeMonthDrawDown.doubleValue() < threeMonthDrawDowncompare.doubleValue()) {
	        		threeMonthDrawDowncompare = threeMonthDrawDown;
				}
	        }
		   // 水下最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
	        		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
	        	//净值大于1无水下回撤
	        	if (threeMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					threeMonthMaxSum = threeMonthcompare;
					threeMonthMin = threeMonthMaxSum;
					threeMonthMaxNetValue = threeMonthList.get(i).getNetAccumulativeValue(); 
					threeMonthMaxNetValueCount = i;
					if(!isthreeMonthCount){
    					threeMonthMinDrawDownFormactionCount = new BigDecimal((double)(i - threeMonthMinNetValueCount));
    				}
					isthreeMonthCount = true;
				}
				if ((threeMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (threeMonthcompare.doubleValue() < threeMonthMin.doubleValue())) {
					threeMonthMin = threeMonthcompare;  
					threeMonthNetValue = threeMonthList.get(i).getNetAccumulativeValue();
					threeMonthDate = threeMonthList.get(i).getDate();
				}       	
	        	if ((threeMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (threeMonthList.get(i).getNetAccumulativeValue().doubleValue()>=threeMonthMaxNetValue.doubleValue())) {
	        		threeMonthDrawDown = BigDecimal.ZERO;
				}else if((threeMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (threeMonthList.get(i).getNetAccumulativeValue().doubleValue()<threeMonthMaxNetValue.doubleValue())
						&& threeMonthcompare.doubleValue()>=threeMonthMin.doubleValue()){
					threeMonthDrawDown = threeMonthNetValue.subtract(BigDecimal.ONE);
				}
	        	if (threeMonthDrawDown.doubleValue() < threeMonthDrawDowncompare.doubleValue()) {
	        		threeMonthDrawDowncompare = threeMonthDrawDown;
	        		threeMonthMaxDrawDownFormactionCount = i-threeMonthMaxNetValueCount;
	        		threeMonthMinNetValueCount = i;
	        		isthreeMonthCount = false;
	        		threeMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
	        	if(!isthreeMonthCount && threeMonthMinNetValueCount < i){
	    			threeMonthMinDrawDownFormactionCount = new BigDecimal((double)threeMonthList.size() - 1 - threeMonthMinNetValueCount + 0.1);
	    		}
			 }
		}
		for (int i = 0; i < sixMonthList.size(); i++) {
			sixMonthcompare = sixMonthcompare.add(sixMonthList.get(i).getToday());
            if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
            		|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
            	if (sixMonthcompare.doubleValue() > sixMonthMaxSum.doubleValue()){
					sixMonthMaxSum = sixMonthcompare;
					sixMonthMin = sixMonthMaxSum;
					sixMonthMaxNetValue = sixMonthList.get(i).getNetAccumulativeValue();
					sixMonthMaxNetValueCount = i;
					if(!issixMonthCount){
    					sixMonthMinDrawDownFormactionCount = new BigDecimal((double)(i - sixMonthMinNetValueCount));
    				}
					issixMonthCount = true;
				}
            	if (sixMonthcompare.doubleValue() < sixMonthMin.doubleValue()) {
    				sixMonthMin = sixMonthcompare;  
    				sixMonthNetValue = sixMonthList.get(i).getNetAccumulativeValue();
    				sixMonthDate = sixMonthList.get(i).getDate();
    			}
            	
            	if (sixMonthList.get(i).getNetAccumulativeValue().doubleValue()>=sixMonthMaxNetValue.doubleValue()) {
            		sixMonthDrawDown = BigDecimal.ZERO;
				}else if(sixMonthList.get(i).getNetAccumulativeValue().doubleValue()<sixMonthMaxNetValue.doubleValue()
						&& sixMonthcompare.doubleValue()>=sixMonthMin.doubleValue()){
					sixMonthDrawDown = (sixMonthNetValue.subtract(sixMonthMaxNetValue)).divide(sixMonthMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
            	if (sixMonthDrawDown.doubleValue() < sixMonthDrawDowncompare.doubleValue()) {
            		sixMonthDrawDowncompare = sixMonthDrawDown;
            		sixMonthMaxDrawDownFormactionCount = i-sixMonthMaxNetValueCount;
            		sixMonthMinNetValueCount = i;
            		issixMonthCount = false;
            		sixMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
				}            	
            	if(!issixMonthCount && sixMonthMinNetValueCount < i){
        			sixMonthMinDrawDownFormactionCount = new BigDecimal((double)sixMonthList.size() - 1 - sixMonthMinNetValueCount + 0.1);
        		}
			}
            // 水上最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//回撤净值差额最大值
		    	if ( (sixMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (sixMonthcompare.doubleValue() > sixMonthMaxSum.doubleValue())){  
					//净值差额最大值
					sixMonthMaxSum = sixMonthcompare;
					sixMonthMin = sixMonthMaxSum;
					sixMonthMaxNetValue = sixMonthList.get(i).getNetAccumulativeValue(); 
				}
				if ((sixMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (sixMonthcompare.doubleValue() < sixMonthMin.doubleValue())) {
					sixMonthMin = sixMonthcompare;  
					sixMonthNetValue = sixMonthList.get(i).getNetAccumulativeValue();
					sixMonthDate = sixMonthList.get(i).getDate();
				}       	
		    	if ((sixMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (sixMonthList.get(i).getNetAccumulativeValue().doubleValue()>=sixMonthMaxNetValue.doubleValue())) {
		    		sixMonthDrawDown = BigDecimal.ZERO;
				}else if((sixMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (sixMonthList.get(i).getNetAccumulativeValue().doubleValue()<sixMonthMaxNetValue.doubleValue())
						&& sixMonthcompare.doubleValue()>=sixMonthMin.doubleValue()){
					sixMonthDrawDown = (sixMonthNetValue.subtract(sixMonthMaxNetValue)).divide(sixMonthMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
		    	if (sixMonthDrawDown.doubleValue() < sixMonthDrawDowncompare.doubleValue()) {
            		sixMonthDrawDowncompare = sixMonthDrawDown;
				}
	        }
		    // 水下最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
	        		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
	        	//净值大于1无水下回撤
	        	if (sixMonthList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					sixMonthMaxSum = sixMonthcompare;
					sixMonthMin = sixMonthMaxSum;
					sixMonthMaxNetValue = sixMonthList.get(i).getNetAccumulativeValue(); 
					sixMonthMaxNetValueCount = i;
					if(!issixMonthCount){
    					sixMonthMinDrawDownFormactionCount = new BigDecimal((double)(i - sixMonthMinNetValueCount));
    				}
					issixMonthCount = true;
				}
				if ((sixMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (sixMonthcompare.doubleValue() < sixMonthMin.doubleValue())) {
					sixMonthMin = sixMonthcompare;  
					sixMonthNetValue = sixMonthList.get(i).getNetAccumulativeValue();
					sixMonthDate = sixMonthList.get(i).getDate();
				}       	
	        	if ((sixMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (sixMonthList.get(i).getNetAccumulativeValue().doubleValue()>=sixMonthMaxNetValue.doubleValue())) {
	        		sixMonthDrawDown = BigDecimal.ZERO;
				}else if((sixMonthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (sixMonthList.get(i).getNetAccumulativeValue().doubleValue()<sixMonthMaxNetValue.doubleValue())
						&& sixMonthcompare.doubleValue()>=sixMonthMin.doubleValue()){
					sixMonthDrawDown = sixMonthNetValue.subtract(BigDecimal.ONE);
				}
	        	if (sixMonthDrawDown.doubleValue() < sixMonthDrawDowncompare.doubleValue()) {
            		sixMonthDrawDowncompare = sixMonthDrawDown;
            		sixMonthMaxDrawDownFormactionCount = i-sixMonthMaxNetValueCount;
            		sixMonthMinNetValueCount = i;
            		issixMonthCount = false;
            		sixMonthMinDrawDownFormactionCount = BigDecimal.ZERO;
				}            	
            	if(!issixMonthCount && sixMonthMinNetValueCount < i){
        			sixMonthMinDrawDownFormactionCount = new BigDecimal((double)sixMonthList.size() - 1 - sixMonthMinNetValueCount + 0.1);
        		}
			 }
		}
		
		for (int i = 0; i < oneYearList.size(); i++) {
			oneYearcompare = oneYearcompare.add(oneYearList.get(i).getToday());
            if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
            		|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
            	if (oneYearcompare.doubleValue() > oneYearMaxSum.doubleValue()){
					oneYearMaxSum = oneYearcompare;
					oneYearMin= oneYearMaxSum;
					oneYearMaxNetValue = oneYearList.get(i).getNetAccumulativeValue();
					oneYearMaxNetValueCount = i;
					if(!isoneYearCount){
    					oneYearMinDrawDownFormactionCount = new BigDecimal((double)(i - oneYearMinNetValueCount));
    				}
					isoneYearCount = true;
				}
            	if (oneYearcompare.doubleValue() < oneYearMin.doubleValue()) {
    				oneYearMin = oneYearcompare;  
    				oneYearNetValue = oneYearList.get(i).getNetAccumulativeValue();
    				oneYearDate = oneYearList.get(i).getDate();
    			}
            	if (oneYearList.get(i).getNetAccumulativeValue().doubleValue()>=oneYearMaxNetValue.doubleValue()) {
            		oneYearDrawDown = BigDecimal.ZERO;
				}else if(oneYearList.get(i).getNetAccumulativeValue().doubleValue()<oneYearMaxNetValue.doubleValue()
						&& oneYearcompare.doubleValue()>=oneYearMin.doubleValue()){
					oneYearDrawDown = (oneYearNetValue.subtract(oneYearMaxNetValue)).divide(oneYearMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
            	if (oneYearDrawDown.doubleValue() < oneYearDrawDowncompare.doubleValue()) {
            		oneYearDrawDowncompare = oneYearDrawDown;
            		oneYearMaxDrawDownFormactionCount = i-oneYearMaxNetValueCount;
            		oneYearMinNetValueCount = i;
            		isoneYearCount = false;
            		oneYearMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isoneYearCount && oneYearMinNetValueCount < i){
        			oneYearMinDrawDownFormactionCount = new BigDecimal((double)oneYearList.size() - 1 - oneYearMinNetValueCount + 0.1);
        		}
			}
         // 水上最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//回撤净值差额最大值
		    	if ( (oneYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneYearcompare.doubleValue() > oneYearMaxSum.doubleValue())){  
					//净值差额最大值
					oneYearMaxSum = oneYearcompare;
					oneYearMin = oneYearMaxSum;
					oneYearMaxNetValue = oneYearList.get(i).getNetAccumulativeValue(); 
				}
				if ((oneYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneYearcompare.doubleValue() < oneYearMin.doubleValue())) {
					oneYearMin = oneYearcompare;  
					oneYearNetValue = oneYearList.get(i).getNetAccumulativeValue();
					oneYearDate = oneYearList.get(i).getDate();
				}       	
		    	if ((oneYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneYearList.get(i).getNetAccumulativeValue().doubleValue()>=oneYearMaxNetValue.doubleValue())) {
		    		oneYearDrawDown = BigDecimal.ZERO;
				}else if((oneYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (oneYearList.get(i).getNetAccumulativeValue().doubleValue()<oneYearMaxNetValue.doubleValue())
						&& oneYearcompare.doubleValue()>=oneYearMin.doubleValue()){
					oneYearDrawDown = (oneYearNetValue.subtract(oneYearMaxNetValue)).divide(oneYearMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
		    	if (oneYearDrawDown.doubleValue() < oneYearDrawDowncompare.doubleValue()) {
            		oneYearDrawDowncompare = oneYearDrawDown;
				}
	        }
		    // 水下最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
	        		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
	        	//净值大于1无水下回撤
	        	if (oneYearList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					oneYearMaxSum = oneYearcompare;
					oneYearMin = oneYearMaxSum;
					oneYearMaxNetValue = oneYearList.get(i).getNetAccumulativeValue(); 
					oneYearMaxNetValueCount = i;
					if(!isoneYearCount){
    					oneYearMinDrawDownFormactionCount = new BigDecimal((double)(i - oneYearMinNetValueCount));
    				}
					isoneYearCount = true;
				}
				if ((oneYearList.get(i).getNetAccumulativeValue().doubleValue() <1) && (oneYearcompare.doubleValue() < oneYearMin.doubleValue())) {
					oneYearMin = oneYearcompare;  
					oneYearNetValue = oneYearList.get(i).getNetAccumulativeValue();
					oneYearDate = oneYearList.get(i).getDate();
				}       	
	        	if ((oneYearList.get(i).getNetAccumulativeValue().doubleValue() <1) && (oneYearList.get(i).getNetAccumulativeValue().doubleValue()>=oneYearMaxNetValue.doubleValue())) {
	        		oneYearDrawDown = BigDecimal.ZERO;
				}else if((oneYearList.get(i).getNetAccumulativeValue().doubleValue() <1) && (oneYearList.get(i).getNetAccumulativeValue().doubleValue()<oneYearMaxNetValue.doubleValue())
						&& oneYearcompare.doubleValue()>=oneYearMin.doubleValue()){
					oneYearDrawDown = oneYearNetValue.subtract(BigDecimal.ONE);
				}
	        	if (oneYearDrawDown.doubleValue() < oneYearDrawDowncompare.doubleValue()) {
            		oneYearDrawDowncompare = oneYearDrawDown;
            		oneYearMaxDrawDownFormactionCount = i-oneYearMaxNetValueCount;
            		oneYearMinNetValueCount = i;
            		isoneYearCount = false;
            		oneYearMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isoneYearCount && oneYearMinNetValueCount < i){
        			oneYearMinDrawDownFormactionCount = new BigDecimal((double)oneYearList.size() - 1 - oneYearMinNetValueCount + 0.1);
        		}
			 }
		}
		
		for (int i = 0; i < thisYearList.size(); i++) {
			thisYearcompare = thisYearcompare.add(thisYearList.get(i).getToday());
            if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
            		|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
            	if (thisYearcompare.doubleValue() > thisYearMaxSum.doubleValue()){
					thisYearMaxSum = thisYearcompare;
					thisYearMin = thisYearMaxSum;
					thisYearMaxNetValue = thisYearList.get(i).getNetAccumulativeValue();
					thisYearMaxNetValueCount =i;
					if(!isthisYearCount){
    					thisYearMinDrawDownFormactionCount = new BigDecimal((double)(i - thisYearMinNetValueCount));
    				}
					isthisYearCount = true;
				}
            	if (thisYearcompare.doubleValue() < thisYearMin.doubleValue()) {
    				thisYearMin = thisYearcompare;  
    				thisYearNetValue = thisYearList.get(i).getNetAccumulativeValue();
    				thisYearDate = thisYearList.get(i).getDate(); 
    			}
            	if (thisYearList.get(i).getNetAccumulativeValue().doubleValue()>=thisYearMaxNetValue.doubleValue()) {
            		thisYearDrawDown = BigDecimal.ZERO;
				}else if(thisYearList.get(i).getNetAccumulativeValue().doubleValue()<thisYearMaxNetValue.doubleValue()
						&& thisYearcompare.doubleValue()>=thisYearMin.doubleValue()){
					thisYearDrawDown = (thisYearNetValue.subtract(thisYearMaxNetValue)).divide(thisYearMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
            	if (thisYearDrawDown.doubleValue() < thisYearDrawDowncompare.doubleValue()) {
            		thisYearDrawDowncompare = thisYearDrawDown;
            		thisYearMaxDrawDownFormactionCount = i-thisYearMaxNetValueCount;
            		thisYearMinNetValueCount = i;
            		isthisYearCount = false;
            		thisYearMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isthisYearCount && thisYearMinNetValueCount < i){
            		thisYearMinDrawDownFormactionCount = new BigDecimal((double)thisYearList.size() - 1 - thisYearMinNetValueCount + 0.1);
				}
			}	
            // 水上最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//回撤净值差额最大值
		    	if ( (thisYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (thisYearcompare.doubleValue() > thisYearMaxSum.doubleValue())){  
					//净值差额最大值
					thisYearMaxSum = thisYearcompare;
					thisYearMin = thisYearMaxSum;
					thisYearMaxNetValue = thisYearList.get(i).getNetAccumulativeValue(); 
				}
				if ((thisYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (thisYearcompare.doubleValue() < thisYearMin.doubleValue())) {
					thisYearMin = thisYearcompare;  
					thisYearNetValue = thisYearList.get(i).getNetAccumulativeValue();
					thisYearDate = thisYearList.get(i).getDate();
				}       	
		    	if ((thisYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (thisYearList.get(i).getNetAccumulativeValue().doubleValue()>=thisYearMaxNetValue.doubleValue())) {
		    		thisYearDrawDown = BigDecimal.ZERO;
				}else if((thisYearList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (thisYearList.get(i).getNetAccumulativeValue().doubleValue()<thisYearMaxNetValue.doubleValue())
						&& thisYearcompare.doubleValue()>=thisYearMin.doubleValue()){
					thisYearDrawDown =(thisYearNetValue.subtract(thisYearMaxNetValue)).divide(thisYearMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
		    	if (thisYearDrawDown.doubleValue() < thisYearDrawDowncompare.doubleValue()) {
            		thisYearDrawDowncompare = thisYearDrawDown;
				}
	        }
		    // 水下最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
	        		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
	        	//净值大于1无水下回撤
	        	if (thisYearList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					thisYearMaxSum = thisYearcompare;
					thisYearMin = thisYearMaxSum;
					thisYearMaxNetValue = thisYearList.get(i).getNetAccumulativeValue(); 
					thisYearMaxNetValueCount =i;
					if(!isthisYearCount){
    					thisYearMinDrawDownFormactionCount = new BigDecimal((double)(i - thisYearMinNetValueCount));
    				}
					isthisYearCount = true;
				}
				if ((thisYearList.get(i).getNetAccumulativeValue().doubleValue() <1) && (thisYearcompare.doubleValue() < thisYearMin.doubleValue())) {
					thisYearMin = thisYearcompare;  
					thisYearNetValue = thisYearList.get(i).getNetAccumulativeValue();
					thisYearDate = thisYearList.get(i).getDate();
				}       	
	        	if ((thisYearList.get(i).getNetAccumulativeValue().doubleValue() <1) && (thisYearList.get(i).getNetAccumulativeValue().doubleValue()>=thisYearMaxNetValue.doubleValue())) {
	        		thisYearDrawDown = BigDecimal.ZERO;
				}else if((thisYearList.get(i).getNetAccumulativeValue().doubleValue() <1) && (thisYearList.get(i).getNetAccumulativeValue().doubleValue()<thisYearMaxNetValue.doubleValue())
						&& thisYearcompare.doubleValue()>=thisYearMin.doubleValue()){
					thisYearDrawDown = thisYearNetValue.subtract(BigDecimal.ONE);
				}
	        	if (thisYearDrawDown.doubleValue() < thisYearDrawDowncompare.doubleValue()) {
            		thisYearDrawDowncompare = thisYearDrawDown;
            		thisYearMaxDrawDownFormactionCount = i-thisYearMaxNetValueCount;
            		thisYearMinNetValueCount = i;
            		isthisYearCount = false;
            		thisYearMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isthisYearCount && thisYearMinNetValueCount < i){
            		thisYearMinDrawDownFormactionCount = new BigDecimal((double)thisYearList.size() - 1 - thisYearMinNetValueCount + 0.1);
				}
			 }
		}

		for (int i = 0; i < untilNowList.size(); i++) {
			untilNowcompare = untilNowcompare.add(untilNowList.get(i).getToday());
            if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
            		|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
            	if (untilNowcompare.doubleValue() > untilNowMaxSum.doubleValue()){
    				untilNowMaxSum = untilNowcompare;
    				untilNowMin =untilNowMaxSum;
    				untilNowMaxNetValue = untilNowList.get(i).getNetAccumulativeValue();
    				untilNowMaxNetValueCount = i;
    				if(!isuntilNowCount){
    					untilNowMinDrawDownFormactionCount = new BigDecimal((double)(i - untilNowMinNetValueCount));
    				}
    				isuntilNowCount = true;
				}
            	if (untilNowcompare.doubleValue() < untilNowMin.doubleValue()) {
    				untilNowMin = untilNowcompare;  
    				untilNowNetValue = untilNowList.get(i).getNetAccumulativeValue();
    				untilNowDate = untilNowList.get(i).getDate();
    			}
            	if (untilNowList.get(i).getNetAccumulativeValue().doubleValue()>=untilNowMaxNetValue.doubleValue()) {
            		untilNowDrawDown = BigDecimal.ZERO;
				}else if(untilNowList.get(i).getNetAccumulativeValue().doubleValue()<untilNowMaxNetValue.doubleValue()
						&& untilNowcompare.doubleValue()>=untilNowMin.doubleValue()){
					untilNowDrawDown = (untilNowNetValue.subtract(untilNowMaxNetValue)).divide(untilNowMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
            	if (untilNowDrawDown.doubleValue() < untilNowDrawDowncompare.doubleValue()) {
            		untilNowDrawDowncompare = untilNowDrawDown;
            		untilNowMaxDrawDownFormactionCount = i-untilNowMaxNetValueCount;
            		untilNowMinNetValueCount = i;
            		isuntilNowCount = false;
            		untilNowMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isuntilNowCount && untilNowMinNetValueCount < i){
					untilNowMinDrawDownFormactionCount = new BigDecimal((double)untilNowList.size() - 1 - untilNowMinNetValueCount + 0.1);
				}
			}
           // 水上最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//回撤净值差额最大值
		    	if ( (untilNowList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (untilNowcompare.doubleValue() > untilNowMaxSum.doubleValue())){  
					//净值差额最大值
					untilNowMaxSum = untilNowcompare;
					untilNowMin = untilNowMaxSum;
					untilNowMaxNetValue = untilNowList.get(i).getNetAccumulativeValue(); 
				}
				if ((untilNowList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (untilNowcompare.doubleValue() < untilNowMin.doubleValue())) {
					untilNowMin = untilNowcompare;  
					untilNowNetValue = untilNowList.get(i).getNetAccumulativeValue();
					untilNowDate = untilNowList.get(i).getDate();
				}       	
		    	if ((untilNowList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (untilNowList.get(i).getNetAccumulativeValue().doubleValue()>=untilNowMaxNetValue.doubleValue())) {
		    		untilNowDrawDown = BigDecimal.ZERO;
				}else if((untilNowList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (untilNowList.get(i).getNetAccumulativeValue().doubleValue()<untilNowMaxNetValue.doubleValue())
						&& untilNowcompare.doubleValue()>=untilNowMin.doubleValue()){
					untilNowDrawDown = (untilNowNetValue.subtract(untilNowMaxNetValue)).divide(untilNowMaxNetValue,8, BigDecimal.ROUND_HALF_UP);
				}
		    	if (untilNowDrawDown.doubleValue() < untilNowDrawDowncompare.doubleValue()) {
            		untilNowDrawDowncompare = untilNowDrawDown;
				}
	        }
		    // 水下最大回撤
	        if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
	        		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
	        	//净值大于1无水下回撤
	        	if (untilNowList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					untilNowMaxSum = untilNowcompare;
					untilNowMin = untilNowMaxSum;
					untilNowMaxNetValueCount = i;
					if(!isuntilNowCount){
    					untilNowMinDrawDownFormactionCount = new BigDecimal((double)(i - untilNowMinNetValueCount));
    				}
					isuntilNowCount = true;
				}
				if ((untilNowList.get(i).getNetAccumulativeValue().doubleValue() <1) && (untilNowcompare.doubleValue() < untilNowMin.doubleValue())) {
					untilNowMin = untilNowcompare;  
					untilNowNetValue = untilNowList.get(i).getNetAccumulativeValue();
					untilNowDate = untilNowList.get(i).getDate();
				}       	
	        	if ((untilNowList.get(i).getNetAccumulativeValue().doubleValue() <1) && (untilNowList.get(i).getNetAccumulativeValue().doubleValue()>=untilNowMaxNetValue.doubleValue())) {
	        		untilNowDrawDown = BigDecimal.ZERO;
				}else if((untilNowList.get(i).getNetAccumulativeValue().doubleValue() <1) && (untilNowList.get(i).getNetAccumulativeValue().doubleValue()<untilNowMaxNetValue.doubleValue())
						&& untilNowcompare.doubleValue()>=untilNowMin.doubleValue()){
					untilNowDrawDown = untilNowNetValue.subtract(BigDecimal.ONE);
				}
	        	if (untilNowDrawDown.doubleValue() < untilNowDrawDowncompare.doubleValue()) {
            		untilNowDrawDowncompare = untilNowDrawDown;
            		untilNowMaxDrawDownFormactionCount = i-untilNowMaxNetValueCount;
            		untilNowMinNetValueCount = i;
            		isuntilNowCount = false;
            		untilNowMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isuntilNowCount && untilNowMinNetValueCount < i){
					untilNowMinDrawDownFormactionCount = new BigDecimal((double)untilNowList.size() - 1 - untilNowMinNetValueCount + 0.1);
				}
			 }
		}	
		
		//最大回撤
		if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN)) {
			if (oneMonthMaxNetValue.doubleValue() != 0 && oneMonthDate != null) {
				varietyPeriod.setOneMonth(oneMonthDrawDowncompare);
			}else{
				varietyPeriod.setOneMonth(BigDecimal.ZERO);
			}
			if (threeMonthMaxNetValue.doubleValue() !=0 && threeMonthDate != null) {
				varietyPeriod.setThreeMonth(threeMonthDrawDowncompare);
			}else{
				varietyPeriod.setThreeMonth(BigDecimal.ZERO);
			}
			if (sixMonthMaxNetValue.doubleValue() !=0 && sixMonthDate != null) {
				varietyPeriod.setSixMonth(sixMonthDrawDowncompare);
			}else{
				varietyPeriod.setSixMonth(BigDecimal.ZERO);
			}
			if (oneYearMaxNetValue.doubleValue() !=0 && oneYearDate != null) {
				varietyPeriod.setOneYear(oneYearDrawDowncompare);		
			}else{
				varietyPeriod.setOneYear(BigDecimal.ZERO);
			}
			if (thisYearMaxNetValue.doubleValue() !=0  && thisYearDate != null) {
				varietyPeriod.setThisYear(thisYearDrawDowncompare);
			}else{
				varietyPeriod.setThisYear(BigDecimal.ZERO);
			}
			if (untilNowMaxNetValue.doubleValue() !=0 && untilNowDate != null) {
				varietyPeriod.setUntilNow(untilNowDrawDowncompare);
			}else{
				varietyPeriod.setUntilNow(BigDecimal.ZERO);
			}
		}//水上最大回撤
		else if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {
			if (oneMonthMaxNetValue.doubleValue() != 0 && oneMonthDate != null && (oneMonthNetValue.doubleValue()>=1 || oneMonthMaxNetValue.doubleValue() >=1)) {
				varietyPeriod.setOneMonth(oneMonthDrawDowncompare);
			}else{
				varietyPeriod.setOneMonth(BigDecimal.ZERO);
			}
			if (threeMonthMaxNetValue.doubleValue() !=0  && threeMonthDate != null && (threeMonthNetValue.doubleValue()>=1 || threeMonthMaxNetValue.doubleValue() >=1)) {
				varietyPeriod.setThreeMonth(threeMonthDrawDowncompare);
			}else{
				varietyPeriod.setThreeMonth(BigDecimal.ZERO);
			}
			if (sixMonthMaxNetValue.doubleValue() !=0 && sixMonthDate != null && (sixMonthNetValue.doubleValue()>=1 || sixMonthMaxNetValue.doubleValue() >=1)) {
				varietyPeriod.setSixMonth(sixMonthDrawDowncompare);
			}else{
				varietyPeriod.setSixMonth(BigDecimal.ZERO);
			}
			if (oneYearMaxNetValue.doubleValue() !=0 && oneYearDate != null && (oneYearNetValue.doubleValue()>=1 || oneYearMaxNetValue.doubleValue() >=1)) {
				varietyPeriod.setOneYear(oneYearDrawDowncompare);		
			}else{
				varietyPeriod.setOneYear(BigDecimal.ZERO);
			}
			if (thisYearMaxNetValue.doubleValue() !=0 && thisYearDate != null && (thisYearNetValue.doubleValue()>=1 || thisYearMaxNetValue.doubleValue() >=1)) {
				varietyPeriod.setThisYear(thisYearDrawDowncompare);
			}else{
				varietyPeriod.setThisYear(BigDecimal.ZERO);
			}
			if (untilNowMaxNetValue.doubleValue() !=0 && untilNowDate != null && (untilNowNetValue.doubleValue()>=1 || untilNowMaxNetValue.doubleValue() >=1)) {
				varietyPeriod.setUntilNow(untilNowDrawDowncompare);
			}else{
				varietyPeriod.setUntilNow(BigDecimal.ZERO);
			}
	   }//水下最大回撤		
	   else if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN)) {
			if (oneMonthDate != null && oneMonthNetValue.doubleValue()<1 ) {
				varietyPeriod.setOneMonth(oneMonthDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setOneMonth(BigDecimal.ZERO);
			}
			if (threeMonthDate != null && threeMonthNetValue.doubleValue()<1 ) {
				varietyPeriod.setThreeMonth(threeMonthDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setThreeMonth(BigDecimal.ZERO);
			}
			if (sixMonthDate != null && sixMonthNetValue.doubleValue()<1 ) {
				varietyPeriod.setSixMonth(sixMonthDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setSixMonth(BigDecimal.ZERO);
			}
			if (oneYearDate != null && oneYearNetValue.doubleValue()<1 ) {
				varietyPeriod.setOneYear(oneYearDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));		
			}else{
				varietyPeriod.setOneYear(BigDecimal.ZERO);
			}
			if (thisYearDate != null && thisYearNetValue.doubleValue()<1 ) {
				varietyPeriod.setThisYear(thisYearDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setThisYear(BigDecimal.ZERO);
			}
			if (untilNowDate != null && untilNowNetValue.doubleValue()<1 ){
				varietyPeriod.setUntilNow(untilNowDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setUntilNow(BigDecimal.ZERO);
			}	
     }
     //最大回撤形成周期,水下最大回撤形成周期
     else if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)) {
    	 if (oneMonthDate != null) {
				varietyPeriod.setOneMonth(new BigDecimal(oneMonthMaxDrawDownFormactionCount));
			}else{
				varietyPeriod.setOneMonth(BigDecimal.ZERO);
			}
			if (threeMonthDate != null) {
				varietyPeriod.setThreeMonth(new BigDecimal(threeMonthMaxDrawDownFormactionCount));
			}else{
				varietyPeriod.setThreeMonth(BigDecimal.ZERO);
			}
			if (sixMonthDate != null) {
				varietyPeriod.setSixMonth(new BigDecimal(sixMonthMaxDrawDownFormactionCount));
			}else{
				varietyPeriod.setSixMonth(BigDecimal.ZERO);
			}
			if (oneYearDate != null) {
				varietyPeriod.setOneYear(new BigDecimal(oneYearMaxDrawDownFormactionCount));		
			}else{
				varietyPeriod.setOneYear(BigDecimal.ZERO);
			}
			if (thisYearDate != null) {
				varietyPeriod.setThisYear(new BigDecimal(thisYearMaxDrawDownFormactionCount));
			}else{
				varietyPeriod.setThisYear(BigDecimal.ZERO);
			}
			if (untilNowDate != null) {
				varietyPeriod.setUntilNow(new BigDecimal(untilNowMaxDrawDownFormactionCount));
			}else{
				varietyPeriod.setUntilNow(BigDecimal.ZERO);
			}
     }
	 //最大回撤恢复周期,水下最大回撤恢复周期
     else if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
		    if (oneMonthDate != null) {
				varietyPeriod.setOneMonth(oneMonthMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setOneMonth(BigDecimal.ZERO);
			}
			if (threeMonthDate != null) {
				varietyPeriod.setThreeMonth(threeMonthMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setThreeMonth(BigDecimal.ZERO);
			}
			if (sixMonthDate != null) {
				varietyPeriod.setSixMonth(sixMonthMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setSixMonth(BigDecimal.ZERO);
			}
			if (oneYearDate != null) {
				varietyPeriod.setOneYear(oneYearMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));		
			}else{
				varietyPeriod.setOneYear(BigDecimal.ZERO);
			}
			if (thisYearDate != null) {
				varietyPeriod.setThisYear(thisYearMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setThisYear(BigDecimal.ZERO);
			}
			if (untilNowDate != null) {
				varietyPeriod.setUntilNow(untilNowMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				varietyPeriod.setUntilNow(BigDecimal.ZERO);
			}
     }
		return varietyPeriod;
   }
	
	
	public static Map<String,Object> calculateMaxDrawdownValue(List<ProductPeriodKPIStatistics> list,ProductPeriodKPIStatistics varietyPeriod, int month){
		Map<String,Object> returnList = new HashMap<String,Object>();
		String today = varietyPeriod.getDate();
		String statStartDate = "";
		String maxDrawdownStartDate = "";
		String newestMaxNetValueDate = "";
		String maxDrawdownEndDate = "";
		if(month==0){ //成立以来
			statStartDate = DATE.addThreadDate(list.get(0).getDate(),0,0,-1);
		}else if(month==99999){ //今年以来
			statStartDate = DATE.addThreadDate(today, -1, 0, 0).substring(0,4).concat("1231");
		}else{
			statStartDate = DATE.addThreadDate(today, 0, 0-month, 0);
		}
		List<ProductPeriodKPIStatistics> monthList = new ArrayList<>();
		
		BigDecimal monthcompare = BigDecimal.ZERO;
		
		//回撤最大值
		BigDecimal monthDrawDowncompare = BigDecimal.ZERO;
		//取得本次参与计算的样本列表
		for (int i = 0; i < list.size(); i++) {
			String date = list.get(i).getDate();
			// 近N月		
			if(Integer.valueOf(date)>Integer.valueOf(statStartDate) && Integer.valueOf(date)<=Integer.valueOf(today)){
				monthList.add(list.get(i));
			}
		}
		if(monthList.size()==0){
			returnList.put("value", BigDecimal.ZERO);
			returnList.put("maxDrawdownStartDate", "");
			returnList.put("maxDrawdownEndDate", "");
			return returnList;
		}
		//净值差额和最小值
		BigDecimal monthMin = monthList.get(0).getToday();
		//净值差额和最大值
		BigDecimal monthMaxSum = monthList.get(0).getToday();
		
		//最大回撤对应最低点净值
		BigDecimal monthNetValue = BigDecimal.ZERO;
		
		//最大回撤对应最高点净值
		BigDecimal monthMaxNetValue = monthList.get(0).getNetAccumulativeValue();
		
		//净值差额和最小值对应日期
		String monthDate = monthList.get(0).getDate();
		
		//最大回撤起期(当前最高点)
		maxDrawdownStartDate = monthList.get(0).getDate();
		newestMaxNetValueDate = monthList.get(0).getDate();
		
		//回撤
		BigDecimal monthDrawDown = BigDecimal.ZERO;
		
		int monthMaxNetValueCount = 0;
		
		int monthMaxDrawDownFormactionCount = 0;
		
		int monthMinNetValueCount = 0;
		
		BigDecimal monthMinDrawDownFormactionCount = BigDecimal.ZERO;
		
		boolean isMonthCount = true;
		
		for (int i = 0; i < monthList.size(); i++) {
			monthcompare = monthcompare.add(monthList.get(i).getToday()); 
            if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE)
            		|| varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE)) {
            	//净值累计差额大于累计至前一日的最大值 -> 净值新高点
            	if (monthcompare.doubleValue() > monthMaxSum.doubleValue()){  
    				monthMaxSum = monthcompare;
    				monthMin = monthMaxSum;
    				monthMaxNetValue = monthList.get(i).getNetAccumulativeValue(); 
    				newestMaxNetValueDate = monthList.get(i).getDate();
    				monthMaxNetValueCount = i;    				
    				if(!isMonthCount){ // 计算最大回撤恢复期
    					monthMinDrawDownFormactionCount = new BigDecimal((double)(i - monthMinNetValueCount));
    				}
    				isMonthCount = true;
				}
            	//净值累计差额小于累计至前一日的最小值 -> 净值新低点
				if (monthcompare.doubleValue() < monthMin.doubleValue()) {
    				monthMin = monthcompare;  
    				monthNetValue = monthList.get(i).getNetAccumulativeValue();
    				monthDate = monthList.get(i).getDate();
    			}  
				//计算回撤
            	if (monthList.get(i).getNetAccumulativeValue().doubleValue()>=monthMaxNetValue.doubleValue()) {
            		monthDrawDown = BigDecimal.ZERO;
				}else if(monthList.get(i).getNetAccumulativeValue().doubleValue()<monthMaxNetValue.doubleValue()
						&& monthcompare.doubleValue()>=monthMin.doubleValue()){
					monthDrawDown = (monthList.get(i).getNetAccumulativeValue().subtract(monthMaxNetValue)).divide(monthMaxNetValue,8,BigDecimal.ROUND_HALF_UP);
				}
            	//当前回撤小于之前最大回撤 -> 更新最大回撤
            	if (monthDrawDown.doubleValue() < monthDrawDowncompare.doubleValue()) {
            		monthDrawDowncompare = monthDrawDown;
            		monthMaxDrawDownFormactionCount = i-monthMaxNetValueCount; //计算最大回撤形成期
                    monthMinNetValueCount = i; //记录最大回撤笔数
            		isMonthCount = false;
            		monthMinDrawDownFormactionCount = BigDecimal.ZERO;
            		maxDrawdownStartDate = newestMaxNetValueDate;
            		maxDrawdownEndDate = monthList.get(i).getDate();
				}
            	// 直到最后最大回撤未恢复，标注恢复周期未结束(+0.1)
            	if(!isMonthCount && monthMinNetValueCount < i){
    				monthMinDrawDownFormactionCount = new BigDecimal((double)monthList.size() - 1 - monthMinNetValueCount + 0.1);
    			}
			}	
		      // 水上最大回撤
		      if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {       	
		    	//净值最大值
		    	if ((monthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (monthcompare.doubleValue() > monthMaxSum.doubleValue())){  
					//净值差额最大值
					monthMaxSum = monthcompare;
					monthMin = monthMaxSum;
					monthMaxNetValue = monthList.get(i).getNetAccumulativeValue(); 
				}
				if ((monthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (monthcompare.doubleValue() < monthMin.doubleValue())) {
					monthMin = monthcompare;  
					monthNetValue = monthList.get(i).getNetAccumulativeValue();
					monthDate = monthList.get(i).getDate();
				}       	
		    	if ((monthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (monthList.get(i).getNetAccumulativeValue().doubleValue()>=monthMaxNetValue.doubleValue())) {
		    		monthDrawDown = BigDecimal.ZERO;
				}else if((monthList.get(i).getNetAccumulativeValue().doubleValue() >=1) && (monthList.get(i).getNetAccumulativeValue().doubleValue()<monthMaxNetValue.doubleValue())
						&& monthcompare.doubleValue()>=monthMin.doubleValue()){
					monthDrawDown =(monthNetValue.subtract(monthMaxNetValue)).divide(monthMaxNetValue,8,BigDecimal.ROUND_HALF_UP);
				}
		    	if (monthDrawDown.doubleValue() < monthDrawDowncompare.doubleValue()) {
            		monthDrawDowncompare = monthDrawDown;
				}
			}
		    // 水下最大回撤
		    if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)
		    		|| varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
		    	//净值大于1无水下回撤
		    	if (monthList.get(i).getNetAccumulativeValue().doubleValue() >=1){  
					//净值差额最大值
					monthMaxSum = monthcompare;
					monthMin = monthMaxSum;
					monthMaxNetValue = monthList.get(i).getNetAccumulativeValue();
					monthMaxNetValueCount = i;
					if(!isMonthCount){
    					monthMinDrawDownFormactionCount = new BigDecimal((double)(i - monthMinNetValueCount));
    				}
					isMonthCount = true;
				}
				if ((monthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (monthcompare.doubleValue() < monthMin.doubleValue())) {
					monthMin = monthcompare;  
					monthNetValue = monthList.get(i).getNetAccumulativeValue();
					monthDate = monthList.get(i).getDate();
				}       	
		    	if ((monthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (monthList.get(i).getNetAccumulativeValue().doubleValue()>=monthMaxNetValue.doubleValue())) {
		    		monthDrawDown = BigDecimal.ZERO;
				}else if((monthList.get(i).getNetAccumulativeValue().doubleValue() <1) && (monthList.get(i).getNetAccumulativeValue().doubleValue()<monthMaxNetValue.doubleValue())
						&& monthcompare.doubleValue()>=monthMin.doubleValue()){
					monthDrawDown = monthNetValue.subtract(BigDecimal.ONE);
				}
		    	if (monthDrawDown.doubleValue() < monthDrawDowncompare.doubleValue()) {
            		monthDrawDowncompare = monthDrawDown;
            		monthMaxDrawDownFormactionCount = i-monthMaxNetValueCount;
            		monthMinNetValueCount = i;
            		isMonthCount = false;
            		monthMinDrawDownFormactionCount = BigDecimal.ZERO;
				}
            	if(!isMonthCount && monthMinNetValueCount < i){
    				monthMinDrawDownFormactionCount = new BigDecimal((double)monthList.size() - 1 - monthMinNetValueCount + 0.1);
    			}
			 }
		}
			
		//最大回撤
		if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN)) { //统一取today栏位
			if (monthMaxNetValue.doubleValue() != 0 && monthDate != null) {
				returnList.put("value", monthDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
				returnList.put("maxDrawdownStartDate", maxDrawdownStartDate);
				returnList.put("maxDrawdownEndDate", maxDrawdownEndDate);
			}else{
				returnList.put("value", BigDecimal.ZERO);
				returnList.put("maxDrawdownStartDate", "");
				returnList.put("maxDrawdownEndDate", "");
			}
			
		}//水上最大回撤
		else if (varietyPeriod.getKPI().equals(KPIConstant.MAXWATERDRAWDOWN)) {
			if (monthMaxNetValue.doubleValue() != 0 && monthDate != null && (monthNetValue.doubleValue()>=1 || monthMaxNetValue.doubleValue() >=1)) {
				returnList.put("value", monthDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				returnList.put("value", BigDecimal.ZERO);
			}
	   }//水下最大回撤		
	   else if (varietyPeriod.getKPI().equals(KPIConstant.MAXUNDERWATERDRAWDOWN)) {
			if (monthDate != null && monthNetValue.doubleValue()<1 ) {
				returnList.put("value", monthDrawDowncompare.setScale(8, BigDecimal.ROUND_HALF_UP));
			}else{
				returnList.put("value", BigDecimal.ZERO);
			}
	   }
     //最大回撤形成周期,水下最大回撤形成周期
     else if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_FORMATION_CYCLE) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_FORMATION_CYCLE)) {
    	 if (monthDate != null) {
				returnList.put("value", new BigDecimal(monthMaxDrawDownFormactionCount));
			}else{
				returnList.put("value", BigDecimal.ZERO);
			}
     }
	 //最大回撤恢复周期,水下最大回撤恢复周期
     else if (varietyPeriod.getKPI().equals(KPIConstant.MAXDRAWDOWN_RECOVERY_CYCLE) || varietyPeriod.getKPI().equals(KPIConstant.DRAWDOWN_RECOVERY_CYCLE)) {
	    if (monthDate != null) {
			returnList.put("value", monthMinDrawDownFormactionCount.setScale(8, BigDecimal.ROUND_HALF_UP));
		}else{
			returnList.put("value", BigDecimal.ZERO);
		}
     }
		return returnList;
   }
}
