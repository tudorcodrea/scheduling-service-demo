package org.scheduling.demo.api;

import java.util.Date;
import java.util.List;

import org.scheduling.demo.entity.TextEntity;

/**
 * @author tudor.codrea
 *
 */
public interface ITextService {

	List<TextEntity> findAllBetweenTextDates(Date startDate, Date endDate);

	TextEntity insert(TextEntity te);

	List<TextEntity> insertList(List<TextEntity> tes);
	
}
