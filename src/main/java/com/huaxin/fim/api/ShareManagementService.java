package com.huaxin.fim.api;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.FileGateway;
import com.dev.framework.core.bean.FrameworkPage;
import com.dev.framework.core.bean.FrameworkPageable;
import com.huaxin.fim.entity.entity.ProductsRelationship;
import com.huaxin.fim.entity.entity.RowCDSShareSummary;
import com.huaxin.fim.entity.entity.ShareImport;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.request.ShareImportQueryRequest;
import com.huaxin.fim.entity.response.ShareImportQueryResponse;

/**
 * 基金份额管理业务处理接口
 * @author liumd
 *
 */
@FileGateway
public interface ShareManagementService {

	/**
	 * 上传基金份额文件上传（.zip或者.exls）
	 * @param files
	 * @return
	 */
	public Map<String, Object> uploadShareFile(List<File> files);
	
	/**
	 * 保存份额导入表
	 * @param si
	 * @return
	 */
	public Map<String,Object> saveShare(ShareImport si);
	
	/**
	 * 删除份额导入信息
	 * @param id
	 * @return
	 */
	public Map<String,Object> deleteShare(String id);
	
	/**
	 * 分页查询导入数据
	 * @param request
	 * @param frameworkPageable
	 * @param orderType
	 * @param orderWay
	 * @return
	 */
	public FrameworkPage<ShareImportQueryResponse> getShareList(ShareImportQueryRequest request,
																FrameworkPageable frameworkPageable, Integer orderType, Integer orderWay);

	/**
	 * 计算母子基金占比关系
	 * @param childProductId
	 * @param startDate
	 * @return
	 */
	public Map<String,Object> calculateProportion(String childProductId, String startDate);
	
	/**
	 * 根据母基金更新份额表
	 * @param parentProductList
	 * @param relationshipList
	 * @return
	 */
	
	@DisabledLog
	public Map<String,Object> updateShareList(List<iWinProduct> parentProductList, List<ProductsRelationship> relationshipList);

	/**
	 * 根据持有人份额源数据表计算母子基金占比
	 * @param rowCDSShareSummaries
	 */
	public void calculateProportion(List<RowCDSShareSummary> rowCDSShareSummaries);

}
