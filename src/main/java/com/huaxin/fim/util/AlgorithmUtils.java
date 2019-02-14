package com.huaxin.fim.util;

import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.entity.Contract;
import com.huaxin.fim.entity.entity.Index;
import com.huaxin.fim.entity.entity.temp.TmpContractEntity;
import com.huaxin.fim.entity.entity.temp.TmpRegressionData;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlgorithmUtils {
	
	// 常量定义
	/**
	 * 抽样标准差模式
	 */
	public final static int STD_SAMPLE = 1;
	/**
	 * 全样标准差模式
	 */
	public final static int STD_WHOLE = 2;
	
	// 错误码定义
	private final static int LIST_IS_BLANK = 10001;				// 集合为空
	private final static int TWO_LIST_SIZE_NOT_EQUAL = 10002;	// 两个集合的长度不一致
	private final static int LIST_ELEMENT_IS_NULL = 10003;		// 集合元素为null
	private final static int OBJ_TYPE_NOT_SUPPORT = 10004;		// 对象类型不支持
	private final static int COUNT_REGRESSION_FAILED = 10005;	// 计算回归结果失败
	private final static int ROWNUM_LESS_THAN_COLNUM = 10006;	// 二维矩阵行数比列数少
	
	/**
	 * 计算相关系数
	 * y = ax + b -> a, b的值</br>
	 * 传入参数集合元素仅支持BigDecimal和Double
	 * @param listX	第一个数据集(x序列)
	 * @param listY	第二个数据集(y序列)
	 * @return	
	 * map对象,返回值类型皆为Double</br>
	 * get("a")即获取相关系数</br>
	 * @throws ServiceException
	 */
	public static Map<String, Double> getCorrelationCoefficient(List<?> listX, List<?> listY) throws ServiceException {
		
		if(listX == null || listX.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合都不能为空");
		
		if(listY == null || listY.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合都不能为空");
		
		if(listX.size() != listY.size())
			throw new ServiceException(TWO_LIST_SIZE_NOT_EQUAL, "两个集合元素数量必须一致");
		
		Map<String,Double> result = new HashMap<String,Double>();	// 结果
		
		try{
			// 1. 获得平均值
			Double xAvg = 0D;
			Double yAvg = 0D;
		
			xAvg = AlgorithmUtils.avg(listX);
			yAvg = AlgorithmUtils.avg(listY);
		
			// 2. 计算Lxy = sum{(xi - xAvg)*(yi - yAvg)}
			Double Lxy = 0D;
			for(int i = 0; i < listX.size(); i++){
				Double tmp1 = 0D;
				Double tmp2 = 0D;
				
				Double xValue = AlgorithmUtils.getObjDoubleValue(listX.get(i));
				Double yValue = AlgorithmUtils.getObjDoubleValue(listY.get(i));
				
				if(xValue == null){
					throw new ServiceException(LIST_ELEMENT_IS_NULL, "listX数据中不能有null值");
				}
				
				if(yValue == null){
					throw new ServiceException(LIST_ELEMENT_IS_NULL, "listY数据中不能有null值");
				}
				
				tmp1 = xValue - xAvg;
				tmp2 = yValue - yAvg;
				
				Lxy = Lxy + (tmp1 * tmp2);
			}
			
			// 3. 计算Lxx = sqrt(sum{(xi - xAvg)*(xi - xAvg)})
			Double Lxx = 0D;
			for(Object x : listX){
				Double tmp = 0D;
				
				Double xValue = AlgorithmUtils.getObjDoubleValue(x);
				
				tmp = xValue - xAvg;
				Lxx += tmp * tmp;
			}
			Lxx = Math.sqrt(Lxx);
			
			// 4. 计算Lyy = sqrt(sum{(yi - yAvg)*(yi - yAvg)})
			Double Lyy = 0D;
			for(Object y : listY){
				Double tmp = 0D;
				
				Double yValue = AlgorithmUtils.getObjDoubleValue(y);
				
				tmp = yValue - yAvg;
				Lyy += tmp * tmp;
			}
			Lyy = Math.sqrt(Lyy);
			
			// 5. a = Lxy / (Lxx*Lyy)(相关系数)
			Double a = null;
			
			if(Lxx.doubleValue() == 0||Lyy.doubleValue() == 0){
				result.put("a", null);
				return result;
			}else{
				a = Lxy / (Lxx*Lyy);
			}
			
			// 6. b = yAvg - a * xAvg
			Double b = yAvg - (a * xAvg);
			
			result.put("a", a);
			result.put("b", b);
			return result;
		}catch(ServiceException e){
			throw e;
		}
		
	}
	
	
	/**
	 * 计算一元线性回归值
	 * y = ax + b -> a, b的值</br>
	 * 传入参数集合元素仅支持BigDecimal和Double
	 * @param listX	第一个数据集(x序列)
	 * @param listY	第二个数据集(y序列)
	 * @return	
	 * map对象,返回值类型皆为Double</br>
	 * get("a")即获取系数a</br>
	 * get("b")即获取截距b
	 * @throws ServiceException
	 */
	public static Map<String, Double> getSimpleLinearRegression(List<?> listX, List<?> listY) throws ServiceException {
		
		if(listX == null || listX.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合都不能为空");
		
		if(listY == null || listY.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合都不能为空");
		
		if(listX.size() != listY.size())
			throw new ServiceException(TWO_LIST_SIZE_NOT_EQUAL, "两个集合元素数量必须一致");
		
		Map<String,Double> result = new HashMap<String,Double>();	// 结果
		
		try{
			// 1. 获得平均值
			Double xAvg = 0D;
			Double yAvg = 0D;
		
			xAvg = AlgorithmUtils.avg(listX);
			yAvg = AlgorithmUtils.avg(listY);
		
			// 2. 计算Lxy = sum{(xi - xAvg)*(yi - yAvg)}
			Double Lxy = 0D;
			for(int i = 0; i < listX.size(); i++){
				Double tmp1 = 0D;
				Double tmp2 = 0D;
				
				Double xValue = AlgorithmUtils.getObjDoubleValue(listX.get(i));
				Double yValue = AlgorithmUtils.getObjDoubleValue(listY.get(i));
				
				if(xValue == null){
					throw new ServiceException(LIST_ELEMENT_IS_NULL, "listX数据中不能有null值");
				}
				
				if(yValue == null){
					throw new ServiceException(LIST_ELEMENT_IS_NULL, "listY数据中不能有null值");
				}
				
				tmp1 = xValue - xAvg;
				tmp2 = yValue - yAvg;
				
				Lxy = Lxy + (tmp1 * tmp2);
			}
			
			// 3. 计算Lxx = sum{(xi - xAvg)*(xi - xAvg)}
			Double Lxx = 0D;
			for(Object x : listX){
				Double tmp = 0D;
				
				Double xValue = AlgorithmUtils.getObjDoubleValue(x);
				
				tmp = xValue - xAvg;
				Lxx += tmp * tmp;
			}
			
			// 4. a = Lxy / Lxx(相关系数)
			Double a = null;
			
			if(Lxx.doubleValue() == 0){
				result.put("a", null);
				result.put("b", null);
				return result;
			}else{
				a = Lxy / Lxx;
			}
				
			// 5. b = yAvg - a*xAvg
			Double b = yAvg - a * xAvg;
			
			result.put("a", a);
			result.put("b", b);
			return result;
		}catch(ServiceException e){
			throw e;
		}
		
	}
	
	/**
	 * 计算数值集合平均值
	 * @param list	数值序列集合(仅支持BigDecimal和Double)
	 * @return	返回集合的平均值
	 * @throws ServiceException
	 */
	public static Double avg(List<?> list) throws ServiceException {
		
		if(list == null || list.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "集合不能为空");
		
		Double result = 0D;
		int count = 0;
		
		try{
			for(Object n : list){
				
				Double dValue = AlgorithmUtils.getObjDoubleValue(n);
				if(dValue != null){
					result += dValue.doubleValue();
					count++;
				}
				
			}
			
			result = result / count;
			return result;
		}catch(ServiceException e){
			throw e;
		}
		
	}
	
	/**
	 * 将传入参数对象转为Double数据类型,仅支持Double和BigDecimal
	 * @param obj	待转换对象
	 * @return	Double对象orNULL
	 * @throws ServiceException
	 */
	public static Double getObjDoubleValue(Object obj) throws ServiceException {
		
		if(obj != null){
			if(obj instanceof Double){
				return (Double) obj;
			}else if(obj instanceof BigDecimal){
				return ((BigDecimal) obj).doubleValue();
			}else{
				throw new ServiceException(OBJ_TYPE_NOT_SUPPORT, "元素类型只支持BigDecimal和Double");
			}
		}else{
			return null;
		}
	}
	
	/**
	 * 计算传入集合的标准差,仅支持Double和BigDecimal
	 * @param list	待计算集合
	 * @param stdMode 标准差计算模式:1 抽样/2 全样
	 * @return	Double结果orNull
	 * @throws ServiceException
	 */
	public static Double getStandardDevition(List<?> list, int stdMode) throws ServiceException {
		
		if(list == null || list.size() == 0)
			return null;
		
		if(list.size() == 1 && stdMode == STD_SAMPLE)
			return null;
		
		try{
			Double sumValue = 0D;
			Double avgValue = AlgorithmUtils.avg(list);
			int count = 0;
			
			for(Object obj : list){
				Double d = AlgorithmUtils.getObjDoubleValue(obj);
				if(obj != null){
					sumValue += (d - avgValue) * (d - avgValue);
					count++;
				}
			}
			
			if(stdMode == STD_SAMPLE){		// 抽样标准差
				return Math.sqrt(sumValue/(count - 1));
			}
			if(stdMode == STD_WHOLE){		// 全样本标准差
				return Math.sqrt(sumValue/count);
			}
			
			return null;
		}catch(ServiceException e){
			throw e;
		}
		
	}
	
	/**
	 * 计算集合求和结果
	 * @param list	待求和集合
	 * @return	求和值
	 * @throws ServiceException
	 */
	public static Double sum(List<?> list) throws ServiceException {
		if(list == null || list.size() == 0)
			return 0D;
		
		Double result = 0D;
		try{
			for(Object obj : list){
				Double tmp = AlgorithmUtils.getObjDoubleValue(obj);
				if(tmp != null){
					result += tmp;
				}
			}
			
			return result;
		}catch(ServiceException e){
			throw e;
		}
		
	}
	
	/**
	 * 根据两个数据集合获取残差序列结果</br>
	 * 仅支持集合元素Double和BigDecimal类型集合</br>
	 * 集合元素TmpContractEntity,contractID作为合约编号,取value1值进行计算</br>
	 * 两集合contractID顺序默认已对应,若结果无需考虑残差所属的合约代码则可以无视,否则返回合约代码为listX合约代码
	 * @param listX	
	 * @param listY
	 * @return	残差序列TmpContractEntity对象集合(contractID,value1)
	 * @throws ServiceException
	 */
	public static List<TmpContractEntity> getResidualList(List<TmpContractEntity> listX, List<TmpContractEntity> listY) throws ServiceException {
		
		if(listX == null || listX.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合都不能为空");
		
		if(listY == null || listY.size() == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合都不能为空");
		
		if(listX.size() != listY.size())
			throw new ServiceException(TWO_LIST_SIZE_NOT_EQUAL, "两个集合元素数量必须一致");
		
		try {
			// 计算回归方程
			List<BigDecimal> lx = listX.stream().map(x -> x.getValue1()).collect(Collectors.toList());
			List<BigDecimal> ly = listY.stream().map(y -> y.getValue1()).collect(Collectors.toList());
			Map<String, Double> paramResult = AlgorithmUtils.getSimpleLinearRegression(lx, ly);
			if(paramResult != null && paramResult.get("a") != null && paramResult.get("b") != null){
				Double a = paramResult.get("a");
				Double b = paramResult.get("b");
				List<TmpContractEntity> residualList = new ArrayList<TmpContractEntity>();	// 残差结果集
				for(int i = 0;i < listX.size();i++){
					TmpContractEntity r = new TmpContractEntity();
					r.setContractID(listY.get(i).getContractID());
					// 残差 = y - ax - b
					Double tmp = AlgorithmUtils.getObjDoubleValue(ly.get(i)) - AlgorithmUtils.getObjDoubleValue(lx.get(i)) * a - b;
					r.setValue1(new BigDecimal(tmp));
					residualList.add(r);
				}
				
				return residualList;
			}else{
				throw new ServiceException(COUNT_REGRESSION_FAILED, "计算一元回归方程失败");
			}
		} catch (ServiceException e) {
			throw e;
		}
		
	}
	
	
	// ----------------------------- 公用因子收益率算法 -------------------------------
	/**
	 * 根据因子序列计算某天因子收益率
	 * @param factorList	因子序列(TmpContractEntity对象,contractID为合约代码,排序按value1值)
	 * @param contractList	取某日wind合约数据
	 * @param sortType		排序方式,1: 从小到大, 其他:从大到小
	 * @param date			统计日
	 * @return	因子收益率BigDecimal值
	 * @throws ServiceException
	 */
	public static BigDecimal getFactorProfitRatio(List<TmpContractEntity> factorList, List<Contract> contractList, String sortType, String date) throws ServiceException {
		
		if(factorList == null || factorList.size() == 0 || contractList == null || contractList.size() == 0)
			return null;
		
		// 过滤出当日合约
		List<Contract> tdContractList = contractList.stream().filter(c -> c.getDate().equals(date)).collect(Collectors.toList());
		
		if(tdContractList == null || tdContractList.size() == 0)
			return null;
				
		List<TmpContractEntity> poolPlus = null;
		List<TmpContractEntity> poolMinus = null;
		
		// 1.找到后10%的数据池pool+,前10%的数据池pool-
		int totalSize = factorList.size();
		int tenPercentLoc = totalSize / 10;
		
		// 2.取value1按指定排序规则排序
		if(sortType.equals(FactorConstant.ASC)){		// 小到大
			factorList.sort((a,b) -> a.getValue1().compareTo(b.getValue1()));
			poolMinus = factorList.stream().limit(tenPercentLoc).collect(Collectors.toList());
			factorList.sort((a,b) -> b.getValue1().compareTo(a.getValue1()));
			poolPlus = factorList.stream().limit(tenPercentLoc).collect(Collectors.toList());
		}else if(sortType.equals(FactorConstant.DESC)){					// 大到小
			factorList.sort((a,b) -> a.getValue1().compareTo(b.getValue1()));
			poolPlus = factorList.stream().limit(tenPercentLoc).collect(Collectors.toList());
			factorList.sort((a,b) -> b.getValue1().compareTo(a.getValue1()));
			poolMinus = factorList.stream().limit(tenPercentLoc).collect(Collectors.toList());
		}
		
		// 3.从wind合约数据中找Pool+和Pool-中每只股票当日收益率R+,R-
		List<BigDecimal> RPlus = new ArrayList<BigDecimal>();
		List<BigDecimal> RMinus = new ArrayList<BigDecimal>();
		
		poolPlus.stream().forEach(p -> {
			Contract contract = tdContractList.stream().filter(c -> c.getContract().equals(p.getContractID())).findFirst().orElse(null);
			if(contract != null){
				BigDecimal dailyYieldRate = contract.getDailyYieldRate();
				if(dailyYieldRate != null){
					RPlus.add(dailyYieldRate);
				}
			}
		});
		
		poolMinus.stream().forEach(p -> {
			Contract contract = tdContractList.stream().filter(c -> c.getContract().equals(p.getContractID())).findFirst().orElse(null);
			if(contract != null){
				BigDecimal dailyYieldRate = contract.getDailyYieldRate();
				if(dailyYieldRate != null){
					RMinus.add(dailyYieldRate);
				}
			}
		});
		
		// 4.当日因子收益率 = avg(poolPlus集合的个股date日收益率R+) - avg(poolMinus集合的个股date日收益率R-)
		Double meanRPlus = AlgorithmUtils.avg(RPlus);
		Double meanRMinus = AlgorithmUtils.avg(RMinus);
		
		BigDecimal result = new BigDecimal(meanRPlus - meanRMinus).setScale(8, BigDecimal.ROUND_HALF_UP);
		
		return result;
	}
	
	/**
	 * 根据传入的合约及指标列表进行排序，回传列表依照合约及日期一一对应(指标排序列表=listX，合约列表=listY)
	 * @param contractList
	 * @param indexList
	 * @return
	 * @throws ServiceException
	 */
	public static Map<String,List<Contract>> getSortList(List<Contract> contractList, List<Index> indexList) throws ServiceException {
		Map<String,List<Contract>> resultList = new HashMap<String, List<Contract>>();
		//合约排序 Collections.sort自带的排序
		Collections.sort(contractList,new Comparator<Contract>() {
			@Override  
			public int compare(Contract o1, Contract o2) {
				// 按合约排序
				return o1.getContract().compareTo(o2.getContract());
			};
		});
		List<Contract> listX = new ArrayList<Contract>();
		List<Contract> listY = new ArrayList<Contract>();
		
		for(Contract con:contractList ){
			for(Index indexData:indexList){
				Contract contractX = new Contract();
				if(indexData.getDate().equals(con.getDate())){//根据日期重新生成list
					contractX.setDate(indexData.getDate());
					contractX.setContract(con.getContract());
					contractX.setDailyYieldRate(indexData.getDailyYieldRate());
					listX.add(contractX);
					listY.add(con);
				}
			}
		}
		resultList.put("listX", listX);
		resultList.put("listY", listY);
			
		return resultList;
	}
	
	/**
	 * 计算多元回归系数
	 * y1 = b0 + b1x11 + b2x12 + .. + bmx1m + e1</br>
	 * y2 = b0 + b1x21 + b2x22 + .. + bmx2m + e2</br>
	 * yn = b0 + b1xn1 + b2xn2 + .. + bmxnm + en</br>
	 * 所有数据格式都为double基本类型及由其组成的数组,Double对象不支持</br>
	 * 需要注意：n必须>m,即行数必须多于列数
	 * @param y	一维数组(n*1)
	 * @param x	二维数组(n*m)
	 * @return	系数(一维数组 (m+1)*1)
	 * @throws ServiceException
	 */
	public static double[] getMultiLinearRegression(double[] y, double[][] x) throws ServiceException {
		
		if(x == null || x.length == 0 || y == null || y.length == 0 || x[0].length == 0)
			throw new ServiceException(LIST_IS_BLANK, "两个集合元素都不能为空");
		
		if(x.length != y.length)
			throw new ServiceException(TWO_LIST_SIZE_NOT_EQUAL, "y数量和x的行数量必须一致");
		
		if(x[0].length >= y.length){
			throw new ServiceException(ROWNUM_LESS_THAN_COLNUM, "x二维数组,行数必须比列数多且不能相等");
		}
		
		try{
			// 普通最小二乘法计算
			OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
			regression.newSampleData(y, x);
			double [] beta = regression.estimateRegressionParameters();		// 系数集合
			return beta;
		}catch(Exception e){
			throw new ServiceException(COUNT_REGRESSION_FAILED, "计算多元回归失败: " + e.getMessage());
		}
		
	}
	
	/**
	 * 根据x[]、y数据得到多元回归结果
	 * @param datas
	 * @return
	 * @throws ServiceException
	 */
	public static double[] getRegression(List<TmpRegressionData> datas) throws ServiceException {
		
		if(datas == null || datas.size() == 0)
			return null;
		
 		int rowNum = datas.size();
		int colNum = datas.get(0).getX().length;
		if(rowNum <= colNum){	// 行数必须多于列数
			return null;
		}else{
			double [] y = new double[rowNum];
			double [] [] x = new double[rowNum][colNum];
			for(int i = 0;i < datas.size();i++){
				y[i] = datas.get(i).getY();
				x[i] = datas.get(i).getX();
			}
			
			try {
				double [] result = AlgorithmUtils.getMultiLinearRegression(y, x);
				return result;
			} catch (ServiceException e) {
				throw e;
			}
		}
		
	}
	
}
