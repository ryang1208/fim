package com.huaxin.fim.api;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.entity.PositionCloseDetails;

/**
 * 
 * @author
 * @date
 * @version 1.0
 */
@Gateway
public interface PositionCloseDetailsService {
	
	public PositionCloseDetails add(PositionCloseDetails positionCloseDetails) throws ServiceException;
	
	public void delete(long id) throws ServiceException;
	
	public PositionCloseDetails update(PositionCloseDetails positionCloseDetails) throws ServiceException;
	
	public List<PositionCloseDetails> findByCondition(String productName, String beginDate, String endDate) throws ServiceException;
	
	public List<PositionCloseDetails> findAll() throws ServiceException;
	
}
