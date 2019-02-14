package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.iWinProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *  <br>
 * 创建日期：2015年7月21日 下午7:14:10 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author 
 * @since 1.0
 * @version 1.0
 */
@Repository(value = "iWinProductRepository")
@EntityClass(entityClass = iWinProduct.class)
@Forbid(forbiddenMethods = { "deleteAll" })
public interface IWinProductRepository extends CrudRepository<iWinProduct, Long> {

	@Query(value = "select f from iWinProduct f "
			+ "where f.QDIAMProductCode = :qdiamProductCode")
	public List<iWinProduct> findByQDIAMProductCode(@Param("qdiamProductCode") String qdiamProductCode);


	/**
	 * 根据产品状态获取产品列表
	 * @param productStatus
	 * @return
	 */
	@Query(value = "select f from iWinProduct f "
			+ "where f.productStatus <>:productStatus")
	public List<iWinProduct> findByProductStatus(@Param("productStatus") String productStatus);

	@Query(value="SELECT                                                "
				+"  id                                                  "
				+"FROM                                                  "
				+"  t_product                                           "
				+"WHERE organization_id IN                              "
				+"  (SELECT                                             "
				+"    organization_id                                   "
				+"  FROM                                                "
				+"    t_user_organization_data_authority                "
				+"  WHERE user_id = :userId                             "
				+"    AND authority LIKE '%4%')                         "
				+"  UNION                                               "
				+"  ALL                                                 "
				+"  SELECT                                              "
				+"    product_id                                        "
				+"  FROM                                                "
				+"    t_organization_product_data_authority             "
				+"  WHERE organization_id IN                            "
				+"    (SELECT                                           "
				+"      organization_id                                 "
				+"    FROM                                              "
				+"      t_user_organization_data_authority              "
				+"    WHERE user_id = :userId                           "
				+"      AND authority LIKE '%4%')                       "
				+"    UNION                                             "
				+"    ALL                                               "
				+"    SELECT                                            "
				+"      id                                              "
				+"    FROM                                              "
				+"      t_product                                       "
				+"    WHERE investment_id IN                            "
				+"      (SELECT                                         "
				+"        item_id                                       "
				+"      FROM                                            "
				+"        t_user_product_data_authority                 "
				+"      WHERE category = '2'                            "
				+"        AND user_id = :userId                         "
				+"        AND authority LIKE '%4%')                     "
				+"      UNION                                           "
				+"      ALL                                             "
				+"      SELECT                                          "
				+"        id                                            "
				+"      FROM                                            "
				+"        t_product                                     "
				+"      WHERE organization_id IN                        "
				+"        (SELECT                                       "
				+"          item_id                                     "
				+"        FROM                                          "
				+"          t_user_product_data_authority               "
				+"        WHERE category = '3'                          "
				+"          AND user_id = :userId                       "
				+"          AND authority LIKE '%4%')                   "
				+"        UNION                                         "
				+"        ALL                                           "
				+"        SELECT                                        "
				+"          product_id                                  "
				+"        FROM                                          "
				+"          t_organization_product_data_authority       "
				+"        WHERE organization_id IN                      "
				+"          (SELECT                                     "
				+"            item_id                                   "
				+"          FROM                                        "
				+"            t_user_product_data_authority             "
				+"          WHERE category = '3'                        "
				+"            AND user_id = :userId                     "
				+"            AND authority LIKE '%4%')                 "
				+"          UNION                                       "
				+"          ALL                                         "
				+"          SELECT                                      "
				+"            item_id                                   "
				+"          FROM                                        "
				+"            t_user_product_data_authority             "
				+"          WHERE category = '4'                        "
				+"            AND user_id = :userId                     "
				+"            AND authority LIKE '%4%'                  " ,nativeQuery = true)
	public List<String> getUser2ProductSelectAuthorityData(@Param("userId") String userId);

	//获取所有产品Id
	@Query(value="select CONCAT(f.id,'') from t_product f where f.product_status <>3 ",nativeQuery =true)
	public List<String> getAllProduct();


	@Query(value="SELECT                                                      "
			+"  CONCAT(id, '')                                            "
			+"FROM                                                        "
			+"  t_product                                                 "
			+"WHERE (                                                     "
			+"    service_manager_id = :userId                            "
			+"    OR channel_user_id = :userId                            "
			+"    OR investment_user_id = :userId                         "
			+"  )                                                         "
			+"  AND organization_id IN                                    "
			+"  (SELECT                                                   "
			+"    organization_id                                         "
			+"  FROM                                                      "
			+"    t_user_organization_data_authority                      "
			+"  WHERE user_id = :userId)                                  "
			+"  UNION                                                     "
			+"  ALL                                                       "
			+"  SELECT                                                    "
			+"    a.product_id                                            "
			+"  FROM                                                      "
			+"    t_organization_product_data_authority a                 "
			+"    LEFT JOIN t_product b                                   "
			+"      ON a.product_id = b.id                                "
			+"  WHERE a.organization_id IN                                "
			+"    (SELECT                                                 "
			+"      organization_id                                       "
			+"    FROM                                                    "
			+"      t_user_organization_data_authority                    "
			+"    WHERE user_id = :userId                                 "
			+"      AND authority LIKE '%4%')                             "
			+"    AND (                                                   "
			+"      b.service_manager_id = :userId                        "
			+"      OR b.channel_user_id = :userId                        "
			+"      OR b.investment_user_id = :userId                     "
			+"    )                                                       "
			+"    UNION                                                   "
			+"    ALL                                                     "
			+"    SELECT                                                  "
			+"      id                                                    "
			+"    FROM                                                    "
			+"      t_product                                             "
			+"    WHERE investment_id IN                                  "
			+"      (SELECT                                               "
			+"        item_id                                             "
			+"      FROM                                                  "
			+"        t_user_product_data_authority                       "
			+"      WHERE category = '2'                                  "
			+"        AND user_id = :userId                               "
			+"        AND authority LIKE '%4%')                           "
			+"      UNION                                                 "
			+"      ALL                                                   "
			+"      SELECT                                                "
			+"        id                                                  "
			+"      FROM                                                  "
			+"        t_product                                           "
			+"      WHERE organization_id IN                              "
			+"        (SELECT                                             "
			+"          item_id                                           "
			+"        FROM                                                "
			+"          t_user_product_data_authority                     "
			+"        WHERE category = '3'                                "
			+"          AND user_id = :userId                             "
			+"          AND authority LIKE '%4%')                         "
			+"        UNION                                               "
			+"        ALL                                                 "
			+"        SELECT                                              "
			+"          product_id                                        "
			+"        FROM                                                "
			+"          t_organization_product_data_authority             "
			+"        WHERE organization_id IN                            "
			+"          (SELECT                                           "
			+"            item_id                                         "
			+"          FROM                                              "
			+"            t_user_product_data_authority                   "
			+"          WHERE category = '3'                              "
			+"            AND user_id = :userId                           "
			+"            AND authority LIKE '%4%')                       "
			+"          UNION                                             "
			+"          ALL                                               "
			+"          SELECT                                            "
			+"            item_id                                         "
			+"          FROM                                              "
			+"            t_user_product_data_authority                   "
			+"          WHERE category = '4'                              "
			+"            AND user_id = :userId                           "
			+"            AND authority LIKE '%4%'                        ",nativeQuery = true)
	public List<String> getUser2ProductSelectAuthorityDataNotAdmin(@Param("userId") String userId);

	/**
	 * 根据产品状态获取产品列表
	 * @return
	 */
	@Query(value = "select f from iWinProduct f "
			+ "where f.id = :productId "
			+ "and f.isCalculateNetValue = :IsCalculateNetValue ")
	public iWinProduct findByProductIdAndIsCalculateNetValue(@Param("productId") long productId, @Param("IsCalculateNetValue") String IsCalculateNetValue);

	public List<iWinProduct> findByProductNameIn(List<String> productName);
}
