package com.huaxin.fim.api.https;

import javax.validation.constraints.NotNull;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.https.HttpResponse;

/**
 * 
 * @Description:基金净值查询接口
 * @author lihuijun
 *
 * @date:  2017年2月23日 下午1:57:27
 *
 */
@Gateway
public interface ImportDataFromXINService {
	
	/**
	 * 按照业务日期查询基金净值
	 * @param date
	 * @return
	 * @throws ServiceException
	 */
	public HttpResponse getFundNetAssetByDate(@NotNull(message = "1|查询日期不能为空") String date, @NotNull String scheduleName)throws Exception;

	/** 执行 */
	public void execute(String scheduleName) throws ServiceException;
	
	/** 更新基金净值 */
	public void updateFundNetValue(String date, Integer dataSource) throws ServiceException;
	/** 更新Pending-job */
	public void updatePendingjob(String date, Integer dataSource) throws ServiceException;
	
}
