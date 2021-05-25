package org.scheduling.demo.controller;

import java.util.Date;
import java.util.List;

import org.scheduling.demo.api.IProcessedTextService;
import org.scheduling.demo.entity.ProcessedTextEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo 'results' controller for the demo TextJob 
 * we can use this to read the results
 * 
 * @author tudor.codrea
 *
 */
@RestController
@RequestMapping("/text/processed")
public class ProcessedTextController {

	@Autowired
	private IProcessedTextService textService;

	@RequestMapping(value = "/allBetweenTextDates", method = RequestMethod.GET)
	public List<ProcessedTextEntity> findAllBetweenTextDates(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

		return textService.findAllBetweenTextDates(startDate, endDate);
	}

}
