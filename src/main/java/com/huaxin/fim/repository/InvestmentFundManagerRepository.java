package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.InvestmentFundManager;
import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentManager;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("investmentFundManagerRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = InvestmentFundManager.class)
public interface InvestmentFundManagerRepository extends CrudRepository<InvestmentFundManager, Long> {
	
	@Query("select m from InvestmentFundManager m "
			+ "where (m.investmentID = :investmentID or :investmentID is null) "
			+ "and (m.name = :name or :name is null)")
	public List<InvestmentFundManager> findByinvestmentIDAndManagerName(
            @Param("investmentID") String investmentID, @Param("name") String name);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from InvestmentFundManager where investmentID = :investmentID")
	public void deleteByInvestmentID(@Param("investmentID") String investmentID);

	@Query("select m from InvestmentFundManager m ,iWinProduct p "
			+ "WHERE p.id = :ProductID "
			+ "and m.investmentID = p.investmentID "
			+ "and m.name = p.fundManager")
	public List<InvestmentFundManager> findByProductID(@Param("ProductID") Long ProductID);

	@Query(value = "SELECT i FROM InvestmentManager i where i.status!=:status")
	public List<InvestmentManager>  findByServiceManagerStutes(@Param("status") String status);

	@Query(value="SELECT                                                    "
				+"  id                                                      "
				+"FROM                                                      "
				+"  t_investment_manager                                    "
				+"WHERE organization_id IN                                  "
				+"  (SELECT                                                 "
				+"    organization_id                                       "
				+"  FROM                                                    "
				+"    t_user_organization_data_authority                    "
				+"  WHERE user_id = :userId                                 "
				+"    AND authority LIKE '%4%')                             "
				+"  UNION                                                   "
				+"  ALL                                                     "
				+"  SELECT                                                  "
				+"    investment_id                                         "
				+"  FROM                                                    "
				+"    t_organization_investment_data_authority              "
				+"  WHERE organization_id IN                                "
				+"    (SELECT                                               "
				+"      organization_id                                     "
				+"    FROM                                                  "
				+"      t_user_organization_data_authority                  "
				+"    WHERE user_id = :userId                               "
				+"      AND authority LIKE '%4%')                           "
				+"    UNION                                                 "
				+"    ALL                                                   "
				+"    SELECT                                                "
				+"      id                                                  "
				+"    FROM                                                  "
				+"      t_investment_manager                                "
				+"    WHERE organization_id IN                              "
				+"      (SELECT                                             "
				+"        item_id                                           "
				+"      FROM                                                "
				+"        t_user_investment_data_authority                  "
				+"      WHERE category = '2'                                "
				+"        AND user_id = :userId                             "
				+"        AND authority LIKE '%4%')                         "
				+"      UNION                                               "
				+"      ALL                                                 "
				+"      SELECT                                              "
				+"        investment_id                                     "
				+"      FROM                                                "
				+"        t_organization_investment_data_authority          "
				+"      WHERE organization_id IN                            "
				+"        (SELECT                                           "
				+"          item_id                                         "
				+"        FROM                                              "
				+"          t_user_investment_data_authority                "
				+"        WHERE category = '2'                              "
				+"          AND user_id = :userId                           "
				+"          AND authority LIKE '%4%')                       "
				+"        UNION                                             "
				+"        ALL                                               "
				+"        SELECT                                            "
				+"          item_id                                         "
				+"        FROM                                              "
				+"          t_user_investment_data_authority                "
				+"        WHERE category = '1'                              "
				+"          AND user_id = :userId                           "
				+"          AND authority LIKE '%4%'                        ",nativeQuery = true)
	public List<String> getUser2InvestmentSelectAuthorityData(@Param("userId") String userId);

	//获取所有投顾Id
	@Query(value="select CONCAT(f.id,'') from t_investment_manager f ",nativeQuery =true)
	public List<String> getAllInvestmentManager();

	@Query(value="SELECT 											"
				+"  id                                              "
				+"FROM                                              "
				+"  t_investment_manager                            "
				+"WHERE organization_id IN                          "
				+"  (SELECT                                         "
				+"    organization_id                               "
				+"  FROM                                            "
				+"    t_user_organization_data_authority            "
				+"  WHERE user_id = :userId                         "
				+"    AND authority LIKE '%4%')                     "
				+"  AND (service_manager_id = :userId               "
				+"  OR channel_user_id = :userId                    "
				+"  OR investment_user_id = :userId)                "
				+"UNION                                             "
				+"ALL 												"
				+"SELECT                                            "
				+"  investment_id                                   "
				+"FROM                                              "
				+"    t_organization_investment_data_authority  t   "
				+"  LEFT JOIN t_investment_manager ti               "
				+"  ON ti.id = t.investment_id                      "
				+"WHERE t.organization_id IN                        "
				+"  (SELECT                                         "
				+"    organization_id                               "
				+"  FROM                                            "
				+"    t_user_organization_data_authority            "
				+"  WHERE user_id = :userId                         "
				+"    AND authority LIKE '%4%')                     "
				+"    AND (ti.service_manager_id = :userId          "
				+"  OR ti.channel_user_id = :userId                 "
				+"  OR ti.investment_user_id = :userId)             "
				+"  UNION                                           "
				+"  ALL                                             "
				+"  SELECT                                          "
				+"    id                                            "
				+"  FROM                                            "
				+"    t_investment_manager                          "
				+"  WHERE organization_id IN                        "
				+"    (SELECT                                       "
				+"      item_id                                     "
				+"    FROM                                          "
				+"      t_user_investment_data_authority            "
				+"    WHERE category = '2'                          "
				+"      AND user_id = :userId                       "
				+"      AND authority LIKE '%4%')                   "
				+"    AND (service_manager_id = :userId             "
				+"  OR channel_user_id = :userId                    "
				+"  OR investment_user_id = :userId)                "
				+"  UNION                                           "
				+"  ALL                                             "
				+"  SELECT                                          "
				+"    investment_id                                 "
				+"  FROM                                            "
				+"    t_organization_investment_data_authority      "
				+"  WHERE organization_id IN                        "
				+"    (SELECT                                       "
				+"      item_id                                     "
				+"    FROM                                          "
				+"      t_user_investment_data_authority            "
				+"    WHERE category = '2'                          "
				+"      AND user_id = :userId                       "
				+"      AND authority LIKE '%4%')                   "
				+"    UNION                                         "
				+"    ALL                                           "
				+"    SELECT                                        "
				+"      item_id                                     "
				+"    FROM                                          "
				+"      t_user_investment_data_authority            "
				+"    WHERE category = '1'                          "
				+"      AND user_id = :userId                       "
				+"      AND authority LIKE '%4%'                    " ,nativeQuery = true)
	public List<String> getUser2InvestmentSelectAuthorityDataNotAdmin(@Param("userId") String userId);
}	
