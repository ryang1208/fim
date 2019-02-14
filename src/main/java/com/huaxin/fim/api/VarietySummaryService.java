package com.huaxin.fim.api;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.entity.VarietySummary;

/**
 * 
 * @author
 * @date
 * @version 1.0
 */
@Gateway
public interface VarietySummaryService {
	
	public VarietySummary add(VarietySummary varietySummary) throws ServiceException;
	
	public void delete(long id) throws ServiceException;
	
	public VarietySummary update(VarietySummary varietySummary) throws ServiceException;
	
	public List<VarietySummary> findByCondition(String productName, String beginDate, String endDate) throws ServiceException;
	
	public List<VarietySummary> findAll() throws ServiceException;
	
	
}
