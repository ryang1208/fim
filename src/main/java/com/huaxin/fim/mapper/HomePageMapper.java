package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.response.FocusFundResponse;
import com.huaxin.fim.entity.response.InvestedCombinationFundResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomePageMapper {

	public List<FocusFundResponse> getFocusFundList(@Param("loginID") String loginID);
	
	public List<InvestedCombinationFundResponse> getInvestedCombineFundList();
	
	public List<InvestedCombinationFundResponse> getInvestedCombineFundListByAdmin(@Param("loginID") String loginID,
                                                                                   FrameworkPageable frameworkPageable, @Param("orderType") Integer orderType,
                                                                                   @Param("orderWay") Integer orderWay);

	public int  getInvestedfundCombineCount(@Param("loginID") String loginID);

	public int  getInvestedfundCombineCountByAdmin(@Param("loginID") String loginID);
	
	public List<iWinProduct> getParentProductList();
	
}
