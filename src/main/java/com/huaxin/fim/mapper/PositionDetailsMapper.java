package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.PositionDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author wangdl
 *
 */
public interface PositionDetailsMapper {

	
	public List<PositionDetails> getPositionDetails();
	
	public List<PositionDetails> getPositionDetailsNotINSummary(@Param("productIdList") List<String> productIdList);
	
	public List<PositionDetails> getPositionDetailsByType(@Param("positionDetails") PositionDetails positionDetails);

}
