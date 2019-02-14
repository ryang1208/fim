package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.HolidayCalendar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = HolidayCalendar.class)
public interface HolidayCalendarRepository extends CrudRepository<HolidayCalendar, Long> {

	@Query("select h from HolidayCalendar h where h.date = :date and h.isHoliday = :isHoliday ")
	public List<HolidayCalendar> findByDateAndIsHoliday(@Param("date") String date, @Param("isHoliday") String isHoliday);

	public List<HolidayCalendar> findByIsHoliday(@Param("isHoliday") String isHoliday);
}
