package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.DataAuthority;
import com.huaxin.fim.entity.entity.iWinProduct;
import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentManager;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("dataAuthorityRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = DataAuthority.class)
public interface DataAuthorityRepository extends CrudRepository<DataAuthority, Long> {
	
	@Query(value = "SELECT u.login_id,u.user_name "
			+ "FROM sso.t_ref_role_user ru INNER JOIN sso.t_user u ON ru.role_id IN (1,3,8) AND ru.user_id = u.id "
			+ "AND u.user_state = '1' "
			+ "AND (u.login_id <> :userID or :userID is null)",nativeQuery = true)
	public List<Object []> queryNotSelfUser(@Param("userID") String userID);
	
	@Query(value = "select u.login_id,u.user_name "
			+ "from sso.t_user u inner join sso.t_ref_role_user ru ON ru.role_id IN (1,3,8) AND ru.user_id = u.id "
			+ "where u.user_state = '1'",nativeQuery = true)
	public List<Object[]> queryAllManager();
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query("delete from DataAuthority d where d.managerID = :managerID")
	public void DeleteByManagerID(@Param("managerID") String managerID);

	@Query(value = "SELECT d.id,u1.login_id as managerID,u2.login_id as userID,"
			+ "u1.user_name as managerName,u2.user_name as userName "
			+ "FROM t_data_authority d, sso.t_user u1, sso.t_user u2 "
			+ "WHERE d.manager_id = u1.login_id AND d.user_id = u2.login_id "
			+ "AND u1.user_state= '1' AND u2.user_state = '1' "
			+ "AND (d.manager_id = :managerID OR :managerID IS NULL) "
			+ "AND (d.user_id = :userID OR :userID IS NULL)",nativeQuery = true)
	public List<Object []> findByCondition(@Param("managerID") String managerID,
                                           @Param("userID") String userID);

	@Query(value = "select p from iWinProduct p, InvestmentManager m "
			+ "where p.investmentID = m.id "
			+ "and (m.serviceManagerID in (select d.userID from DataAuthority d where d.managerID = :managerID) or m.serviceManagerID = :managerID "
			+ "or m.channelUserID in (select d.userID from DataAuthority d where d.managerID = :managerID) or m.channelUserID = :managerID "
			+ "or m.investmentUserID in (select d.userID from DataAuthority d where d.managerID = :managerID) or m.investmentUserID = :managerID)")
	public List<iWinProduct> findFundByDataAuthority(@Param("managerID") String managerID);

	@Query(value = "select m from InvestmentManager m "
			+ "where m.serviceManagerID in (select d.userID from DataAuthority d where d.managerID = :managerID) or m.serviceManagerID = :managerID "
			+ "or m.channelUserID in (select d.userID from DataAuthority d where d.managerID = :managerID) or m.channelUserID = :managerID "
			+ "or m.investmentUserID in (select d.userID from DataAuthority d where d.managerID = :managerID) or m.investmentUserID = :managerID ")
	public List<InvestmentManager> findInvestmentByDataAuthority(@Param("managerID") String managerID);

	@Query(value = "select m from InvestmentManager m "
			+ "where m.status in :status")
	public List<InvestmentManager> findInvestmentByStatus(@Param("status") List<String> status);

	@Query(value="select d.userID from DataAuthority d where d.managerID =:mangerId ")
	public List<String> findUserIdListByMangerId(@Param("mangerId") String mangerId);
	
}	

