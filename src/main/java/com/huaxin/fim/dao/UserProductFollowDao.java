package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.UserProductFollow;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("userProductFollowDao")
public class UserProductFollowDao {
	
	@Inject
	private EntityManager em;
	
	
	@Changeable
	public boolean saveUserProductFollowList(List<UserProductFollow> list) {
		synchronized(this){
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (UserProductFollow userProductFollow : list) {
					em.persist(userProductFollow);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				throw e;
			}
			return success;
		}
	}
}
