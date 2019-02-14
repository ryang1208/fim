package com.huaxin.fim.dao;

import java.math.BigDecimal;
import java.util.List;

public class StandardDeviation {
	/**
	 * 数列平均值
	 * @param list	Double的list数组
	 * @return
	 */
	public static Double getAverage(List<Double> list){
		Double sumValue = 0D;
		
		if(list == null || list.size() == 0) return 0D;
		
		for(Double d : list){
			sumValue += d;
		}
		
		return sumValue/list.size();
		
	}
	
	/**
	 * 数列的标准差
	 * @param list	Double的list数组
	 * @return
	 */
	public static Double getStandardDevition(List<Double> list){
		Double sumValue = 0D;
		Double avgValue = getAverage(list);
		
		if(list == null || list.size() <= 1) return 0D;
		
		for(Double d : list){
			sumValue += (d - avgValue) * (d - avgValue);
		}
		
		return Math.sqrt(sumValue/(list.size()));
		
	}
	
	public static BigDecimal getBigDecimalAverage(List<BigDecimal> list){
		BigDecimal sumValue = BigDecimal.ZERO;
		
		if(list == null || list.size() == 0) return BigDecimal.ZERO;
		
		for(BigDecimal d : list){
			sumValue = sumValue.add(d);
		}
		
		return new BigDecimal(sumValue.doubleValue()/(list.size()));
		
	}
	
	/**
	 * 数列的标准差
	 * @param 
	 * @return
	 */
	public static Double getBigDecimalStandardDevition(List<BigDecimal> list){
		BigDecimal sumValue = BigDecimal.ZERO;
		BigDecimal avgValue = getBigDecimalAverage(list);
		
		if(list == null || list.size() <= 1) return 0D;
		
		for(BigDecimal d : list){
			sumValue = sumValue.add((d.subtract(avgValue)).pow(2));
		}
		
		return Math.sqrt(sumValue.doubleValue()/(list.size()));
		
	}
	
	public static Double transNullToZero(Double doubleValue){
		return doubleValue == null ? 0D : doubleValue;
	}

	public static BigDecimal formatdouble(double val,int len)
	{
		BigDecimal bval = new BigDecimal(val);
		return bval.setScale(len, BigDecimal.ROUND_HALF_UP);
	}
	
	public static BigDecimal formatdouble(double val)
	{
		return formatdouble(val,6);
	}
    
	/**
     * 协方差方法
     * @param xList
     * @param yList
     * @return
     */
    public static Double getCovariance(List<Double> xList,List<Double> yList){
        Double sumValue = 0D;
        Double xAvgValue = getAverage(xList);
        Double yAvgValue = getAverage(yList);

        if (xList == null || xList.size() <= 1)
            return 0D;
        
        if (yList == null || yList.size() <= 1)
            return 0D;

        for (int i=0;i<xList.size();i++) {
            sumValue += (xList.get(i) - xAvgValue) * (yList.get(i) - yAvgValue);
        }
        return sumValue/(xList.size()-1);
    }

    
    /**
	 * 数列平均值
	 * @param list	Double的list数组
	 * @return
	 */
	public static BigDecimal getAverageForBigDecimal(List<BigDecimal> list){
		BigDecimal sumValue = BigDecimal.ZERO;
		
		if(list == null || list.size() == 0) return BigDecimal.ZERO;
		
		for(BigDecimal d : list){
			sumValue = sumValue.add(d);
		}
		
		return sumValue.divide(new BigDecimal(list.size()),8,BigDecimal.ROUND_HALF_UP);
		
	}
	
    /**
     * 协方差方法
     * @param xList
     * @param yList
     * @return
     */
    public static BigDecimal getCovarianceForBigDecimal(List<BigDecimal> xList,List<BigDecimal> yList){
    	BigDecimal sumValue = BigDecimal.ZERO;
        BigDecimal xAvgValue = getAverageForBigDecimal(xList);
        BigDecimal yAvgValue = getAverageForBigDecimal(yList);

        if (xList == null || xList.size() <= 1)
            return BigDecimal.ZERO;
        
        if (yList == null || yList.size() <= 1)
            return BigDecimal.ZERO;

        for (int i=0;i<xList.size();i++) {
            sumValue = sumValue.add((xList.get(i).subtract(xAvgValue)).multiply((yList.get(i).subtract(yAvgValue))));
        }
        return sumValue.divide(new BigDecimal(xList.size()-1),8,BigDecimal.ROUND_HALF_UP);
    }
}
