package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.CustomParameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

@Repository
@EntityClass(entityClass = CustomParameter.class)
@Named("customParameterRepository")
public interface CustomParameterRepository extends CrudRepository<CustomParameter, Long> {
	
	/**  
	 * @Description: 根据参数代码查询系统参数   
	 * @param: @param parameterCode   
	 * @return: CustomParameter      
	 * @throws
	 */
	public CustomParameter getParamByParameterCode(String parameterCode);
	
}
	