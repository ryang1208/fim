package com.huaxin.fim.api;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.entity.PositionSummary;

/**
 * 
 * @author
 * @date
 * @version 1.0
 */
@Gateway
public interface PositionSummaryService {
	
	public PositionSummary add(PositionSummary positionSummary) throws ServiceException;
	
	public void delete(long id) throws ServiceException;
	
	public PositionSummary update(PositionSummary positionSummary) throws ServiceException;
	
	public List<PositionSummary> findByCondition(String productName, String beginDate, String endDate) throws ServiceException;
	
	public List<PositionSummary> findAll() throws ServiceException;
	
}
