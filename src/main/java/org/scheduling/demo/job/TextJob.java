package org.scheduling.demo.job;

import java.util.List;

import org.community.scheduler.util.Util;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.scheduling.demo.api.IProcessedTextService;
import org.scheduling.demo.api.ITextService;
import org.scheduling.demo.entity.ProcessedTextEntity;
import org.scheduling.demo.entity.TextEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Component
@Log4j2
public class TextJob implements Job {

	@Autowired
	private ITextService textService;

	@Autowired
	private IProcessedTextService processedTextService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap data = context.getTrigger().getJobDataMap();
		String invokeParam = (String) data.get("invokeParam");

		List<TextEntity> textEntitiesBetweenTextDatesDates = textService
				.findAllBetweenTextDates(Util.getNowDateMinuteOffset(1), Util.getNowDateMinuteOffset(0));

		textEntitiesBetweenTextDatesDates.forEach(i -> {
			processedTextService.insert(fromTextEntity((TextEntity) i, invokeParam));
		});

		log.info("Running job name: " + data.getString("jobName") + "Job param: " + data.getString("invokeParam")
				+ " --- RESULT: " + textEntitiesBetweenTextDatesDates.size());
	}

	private ProcessedTextEntity fromTextEntity(TextEntity te, String param) {
		return ProcessedTextEntity.builder().textDate(te.getTextDate()).textValue(te.getTextValue() + param).build();
	}

}
