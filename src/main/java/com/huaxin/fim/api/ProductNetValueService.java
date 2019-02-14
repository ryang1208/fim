package com.huaxin.fim.api;

import java.util.List;
import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.ProductNetValue;

import java.util.Map;

/**
 * 
 * @author
 * @date
 * @version 1.0
 */
@Gateway
public interface ProductNetValueService {
	
	public ProductNetValue add(ProductNetValue productNetValue) throws ServiceException;
	
	public void delete(long id) throws ServiceException;
	
	public ProductNetValue update(ProductNetValue productNetValue) throws ServiceException;
	
	public List<ProductNetValue> findByCondition(String contact, String beginDate, String endDate) throws ServiceException;
	
	public List<ProductNetValue> findAll() throws ServiceException;
	
}
