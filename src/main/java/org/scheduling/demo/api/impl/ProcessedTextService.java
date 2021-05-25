package org.scheduling.demo.api.impl;

import java.util.Date;
import java.util.List;

import org.scheduling.demo.api.IProcessedTextService;
import org.scheduling.demo.entity.ProcessedTextEntity;
import org.scheduling.demo.repository.IProcessedTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tudor.codrea
 *
 */
@Service
public class ProcessedTextService implements IProcessedTextService {

	@Autowired
	private IProcessedTextRepository textRepository;

	@Override
	public List<ProcessedTextEntity> findAllBetweenTextDates(Date startDate, Date endDate) {
		return textRepository.findAllBetweenTextDates(startDate, endDate);
	}
	
	@Override
	public ProcessedTextEntity insert(ProcessedTextEntity sjh) {
		return textRepository.save(sjh);
	}
	
	@Override
	public List<ProcessedTextEntity> insertList(List<ProcessedTextEntity> tes) {
		return textRepository.saveAll(tes);
	}

}
