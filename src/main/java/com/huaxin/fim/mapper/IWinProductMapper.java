package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.ProductsRelationship;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.request.ProductQueryRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品查询
 * @author xieky
 *
 */
public interface IWinProductMapper {

	public List<iWinProduct> findiwinProductByRule(@Param("productQueryRequest") ProductQueryRequest productQueryRequest, @Param("loginID") String loginID);

	public List<iWinProduct> findByPortfolioFund(@Param("portfolioFund") String portfolioFund);

	public List<iWinProduct> findBySubProductID(@Param("productsRelationshipList") List<ProductsRelationship> productsRelationshipList);
}
