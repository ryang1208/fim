package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.ProductsRelationship;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = ProductsRelationship.class)
public interface ProductsRelationshipRepository extends CrudRepository<ProductsRelationship, Long> {

	@Query("select count(*) from ProductsRelationship")
	public int findProductsRelationshipTotal();
	
	public List<ProductsRelationship> findByProductID(int productID);
	
	//删除母基金
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ProductsRelationship where productID=:productID ")
	public void deleteProductID(@Param("productID") int productID);


	@Query("select p from ProductsRelationship p where p.parent_ProductID=:parent_ProductID")
	public List<ProductsRelationship> findParentID(@Param("parent_ProductID") int parent_ProductID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "delete from ProductsRelationship t "
			+ "where t.id=:id")
	public void deleteProductsRelationShip(@Param("id") Long id);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "DELETE FROM t_products_relationship WHERE id IN( "
			+ "SELECT tmp.id FROM (SELECT r.id FROM t_products_relationship r "
			+ "INNER JOIN t_product p WHERE r.parent_product_id = p.id "
			+ "AND p.is_parent_product = '1' AND p.qdiam_product_code IS NOT NULL) tmp)",nativeQuery = true)
	public void deleteQdiamDatas();

	/**
	 * 找关系表里指定子产品且结束日期为空的(即最新生效)子母关系数据
	 */
	@Query("select p from ProductsRelationship p where p.productID = :productID and p.parent_ProductID = :parentProductID  and type = '1'")
	public List<ProductsRelationship> findByProductIDAndEndDateIsNull(@Param("productID") int productID, @Param("parentProductID") int parentProductID);

	//
	@Query("select p from ProductsRelationship p "
			+ "where p.parent_ProductID=:parent_ProductID "
			+ "and ((p.startDate <= :beginDate and p.endDate  > :beginDate )  OR (p.startDate <= :beginDate and p.endDate IS NULL)) "
			+ "and type = :type "
			+ "order by p.startDate")
	public List<ProductsRelationship> findByParentIdAndDate(@Param("parent_ProductID") int parent_ProductID, @Param("beginDate") String beginDate, @Param("type") String type);

	// 基金注销,删除该基金所有关系数据
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="delete from ProductsRelationship where productID = :productID or parent_ProductID = :productID")
	public void deleteAllByProductID(@Param("productID") int productID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" DELETE                                         "
				+" FROM                                           "
				+"   t_products_relationship                      "
				+" WHERE parent_product_id IN                     "
				+"   (SELECT                                      "
				+"     temp.parentId                              "
				+"   FROM                                         "
				+"     (SELECT                                    "
				+"       client_product_id parentId               "
				+"     FROM                                       "
				+"       t_share_import                  "
				+"     WHERE product_id = :productID                    "
				+"       AND confirm_date >= :beginDate) temp)        "
				+"   AND TYPE <> '0'                               "
				+"   AND start_date >= :beginDate                   ",nativeQuery = true)
	public void delByProductIdAndTypeAndDate(@Param("productID") int productID, @Param("beginDate") String beginDate);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value=" DELETE                              "
				+" FROM                                "
				+"   t_products_relationship           "
				+" WHERE parent_product_id IN          "
				+"   (SELECT                           "
				+"     temp.parentId                   "
				+"   FROM                              "
				+"     (SELECT                         "
				+"       parent_product_id parentId    "
				+"     FROM                            "
				+"       t_products_relationship       "
				+"     WHERE product_id = :productID ) temp)         "
				+"  AND TYPE = '0'  ",nativeQuery = true)
	public void delByProductIdAndType(@Param("productID") int productID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="DELETE FROM  t_products_relationship WHERE product_id = :productID   AND start_date >= :beginDate ",nativeQuery = true)
	public void delByProductIdAndDate(@Param("productID") int productID, @Param("beginDate") String beginDate);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="DELETE FROM  t_products_relationship WHERE product_id = :productID  and type='0' ",nativeQuery = true)
	public void delByProductId(@Param("productID") int productID);

	/**
	 * 查询最新的记录
	 * @param productID
	 * @param parentProductID
	 * @param beginDate
	 * @param type
	 * @return
	 */
	@Query("select p from ProductsRelationship p where p.productID = :productID and p.parent_ProductID=:parentProductID and  p.startDate <:beginDate and p.type=:type order by startDate desc")
	public List<ProductsRelationship> queryByDateAndProductIdAndType(@Param("productID") int productID, @Param("parentProductID") int parentProductID,
                                                                     @Param("beginDate") String beginDate, @Param("type") String type);

	public List<ProductsRelationship> findByType(@Param("type") String type);

	@Query("select p from ProductsRelationship p where p.parent_ProductID=:parent_ProductID and (p.endDate >= :date or p.endDate is null) AND type = :type")
	public List<ProductsRelationship> findParentIDAndDateAndType(@Param("parent_ProductID") int parent_ProductID, @Param("date") String date, @Param("type") String type);

	/**
	 * 找关系表里指定子产品且结束日期为空的(即最新生效)子母关系数据
	 */
	@Query("select p from ProductsRelationship p where p.productID = :productID and p.parent_ProductID = :parentProductID  and type = '0'")
	public List<ProductsRelationship> getRelationShip(@Param("productID") int productID, @Param("parentProductID") int parentProductID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="DELETE FROM  t_products_relationship WHERE product_id = :productID",nativeQuery = true)
	public void deleteRelationshipByProductId(@Param("productID") int productID);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value="DELETE FROM  t_products_relationship WHERE parent_product_id = :parentProductId",nativeQuery = true)
	public void deleteRelationshipByParentProductId(@Param("parentProductId") int parentProductId);

	@Query(value= "SELECT * FROM ( "
			+ "SELECT p.id,p.parent_product_id, p.product_id ,p.start_date,(SELECT is_calculate_netValue FROM t_product WHERE id = p.product_id) is_calculate_netValue,"
			+ "NULL product_ratio,NULL end_date,NULL insert_date,p.type,p.is_manual "
			+ "FROM t_products_relationship p "
			+ "WHERE p.parent_product_id=:parent_ProductID "
			+ "AND TYPE = :type "
			+ "GROUP BY p.parent_product_id, p.product_id,p.start_date DESC)X "
			+ "WHERE X.is_calculate_netValue = '1' "
			+ "GROUP BY X.parent_product_id, X.product_id",nativeQuery = true)
	public List<ProductsRelationship> findByParentIDAndType(@Param("parent_ProductID") int parent_ProductID, @Param("type") String type);

	@Query(value="select a  FROM  ProductsRelationship a WHERE a.type <>'0' ")
	public List<ProductsRelationship> findAllByType();

	/**
	 * 根据productId查询生效的数据
	 * @param productIds
	 * @return
	 */
	public List<ProductsRelationship> findByProductIDInAndEndDateIsNull(List<Integer> productIds);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "update t_products_relationship set end_date = :endDate where id = :id",nativeQuery = true)
	public void updateOriginEndDate(@Param("endDate") String endDate, @Param("id") int id);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "insert into t_products_relationship(parent_product_id,product_id,product_ratio,start_date,end_date," +
			"insert_date,type,is_manual) values(:parentProductId,:productId," +
			":productRatio,:startDate,:endDate,:insertDate,:type,:isManual)",nativeQuery = true)
	public void  insert(@Param("parentProductId") int patentProductId, @Param("productId") int productId,
                        @Param("productRatio") BigDecimal productRatio, @Param("startDate") String startDate,
                        @Param("endDate") String endDate, @Param("insertDate") String insertDate,
                        @Param("type") String type, @Param("isManual") String isManual);

}
