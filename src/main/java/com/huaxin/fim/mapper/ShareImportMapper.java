package com.huaxin.fim.mapper;

import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.PendingJob;
import com.huaxin.fim.entity.entity.ShareImport;
import com.huaxin.fim.entity.entity.Variety;
import com.huaxin.fim.entity.request.ShareImportQueryRequest;
import com.huaxin.fim.entity.response.ShareImportQueryResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShareImportMapper {
	
	/**
	 * 资产基金的估值表的市值
	 * @return
	 */	
	public List<PendingJob> getPendingJobList(@Param("productName") String productName, @Param("beginDate") String beginDate, @Param("endDate") String endDate);

	/**
	 * 条件查询基金份额列表
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @param productList
	 * @return
	 */
	public List<ShareImportQueryResponse> getShareList(
            @Param("request") ShareImportQueryRequest request,
            FrameworkPageable frameworkPageable,
            @Param("orderType") Integer orderType,
            @Param("orderWay") Integer orderWay,
            @Param("productList") List<String> productList);

	/**
	 * 查询所有基金份额情况
	 * @return
	 */
	public List<ShareImport> getAllShareList();

	public void delProductsRelationship(@Param("request") ShareImport request);


	public List<PendingJob> getParentPendingJobList(@Param("productId") String productId, @Param("beginDate") String beginDate, @Param("type") int type);
	
	public List<Variety> getAllVariety();

}
