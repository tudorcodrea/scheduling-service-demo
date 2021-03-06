package org.scheduling.demo.api.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.scheduling.demo.api.ITextService;
import org.scheduling.demo.entity.TextEntity;
import org.scheduling.demo.repository.ITextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

/**
 * @author tudor.codrea
 *
 */
@Service
@Log4j2
public class TextService implements ITextService {

	@Autowired
	private ITextRepository textRepository;

	public List<TextEntity> findAllBetweenTextDates(String startDate, String endDate) {

		List<TextEntity> retList = new ArrayList<>();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date startingDate = df.parse(startDate);
			Date endingDate = df.parse(startDate);

			retList = textRepository.findAllBetweenTextDates(startingDate, endingDate);

		} catch (Exception e) {
			log.error("Failed to findAllBetweenTextDates:" + e);
		}

		return retList;
	}

	public List<TextEntity> findAllBetweenTextDates(Date startDate, Date endDate) {
		return textRepository.findAllBetweenTextDates(startDate, endDate);
	}

	@Override
	public TextEntity insert(TextEntity te) {
		return textRepository.save(te);
	}
	
	@Override
	public List<TextEntity> insertList(List<TextEntity> tes) {
		return textRepository.saveAll(tes);
	}

}
