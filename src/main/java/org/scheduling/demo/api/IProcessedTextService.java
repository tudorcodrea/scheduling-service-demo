package org.scheduling.demo.api;

import java.util.Date;
import java.util.List;

import org.scheduling.demo.entity.ProcessedTextEntity;

/**
 * @author tudor.codrea
 *
 */
public interface IProcessedTextService {

	List<ProcessedTextEntity> findAllBetweenTextDates(Date startDate, Date endDate);

	ProcessedTextEntity insert(ProcessedTextEntity sjh);

	List<ProcessedTextEntity> insertList(List<ProcessedTextEntity> tes);
	
}
