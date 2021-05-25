package org.scheduling.demo.repository;

import java.util.Date;
import java.util.List;

import org.scheduling.demo.entity.TextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author tudor.codrea
 *
 */
public interface ITextRepository extends JpaRepository<TextEntity, Integer> {

	@Query("select te from TextEntity te where te.textDate between :start and :end")
	List<TextEntity> findAllBetweenTextDates(@Param("start")Date startDate, @Param("end")Date endDate); 
	
}
