package com.huaxin.fim.api;

import java.util.List;
import java.util.Map;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.Datadictionary;
import com.huaxin.fim.entity.entity.ProductInvesterRelationship;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.request.ProductQueryRequest;

/**
 * 基金产品service
 * @author xieky
 *
 */
@Gateway
public interface ProductService {
	
	/**
	 * 下拉框基金选项
	 * @return Map key:id,productName
	 */
	public List<Map<String, Object>> findAllProductName();

	/**
	 * 保存产品信息
	 * @param productList
	 */
	public void saveProductList(List<iWinProduct> productList) throws Exception;

	public int saveOrUpdateProduct(iWinProduct iWinProduct, List<iWinProduct> productList, List<ProductInvesterRelationship> tpList);

	/**
	 * 根据productID来删除或者productName来删除0成功1产品ID或者产品名称不能为空2删除遇到错误
	 * @param productID
	 * @param productName
	 * @return
	 */
	public int delProduct(String productID, String productName);

	public List<iWinProduct> findByCondition(ProductQueryRequest productQueryRequest);

	public void save(iWinProduct iWinProduct);

	public iWinProduct findByProductName(String productName);

	public int cancelProduct(Long productID);

	public List<iWinProduct> findByPortfolioFund(String portfolioFund);
	//查询所有母产品
	public List<Map<String, Object>> findAllFOF();

	public List<Map<String, Object>> findFundParent(String id);


	@Deprecated
	public int saveProduct(iWinProduct iWinProduct);

	//根据子基金查找母基金
	public List<iWinProduct> findFundproduct(iWinProduct iWinProduct);
	//删除母基金
	public int deleteProduct(iWinProduct iWinProduct);

	/**
	 * 获取产品的资金账户列表
	 * @param productId
	 * @return
	 */
	public List<ProductInvesterRelationship> getProductInvesterList(String productId);

	/**
	 * 多资金账户重复账户验证
	 * @param p
	 * @return
	 */
	public int validInvesterRelationship(ProductInvesterRelationship p);

	//根据母基金查找子基金
	public List<iWinProduct> findSonProduct(String parentId);

	//查询所有子产品
	public List<Map<String, Object>> findAllProductExceptParent();

	// 获取所有专态不为3的产品
	public List<iWinProduct> findAllProduct();

	public Map<String,List<Datadictionary>> findIwinDataByDataTypes(List<String> dataTypes);

	/**
	 * 判断子基金是否存在需要计算净值的母基金
	 * @param productId
	 * @param parentProductName
	 * @return
	 */
	public String getCalNetValueParent(String productId, String parentProductName);
	
}
