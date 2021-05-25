package org.scheduling.demo.controller;

import java.util.Date;
import java.util.List;

import org.scheduling.demo.api.ITextService;
import org.scheduling.demo.entity.TextEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo controller for input data for TextJob
 * We can use this to add/edit/delete data for the job
 * 
 * @author tudor.codrea
 *
 */
@RestController
@RequestMapping("/text")
public class TextController {

	@Autowired
	private ITextService textService;

	@RequestMapping(value = "/allBetweenTextDates", method = RequestMethod.GET)
	public List<TextEntity> findAllBetweenTextDates(
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

		return textService.findAllBetweenTextDates(startDate, endDate);
	}

}
