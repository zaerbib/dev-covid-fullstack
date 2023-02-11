package com.covid.dev.util.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.covid.dev.util.event.AfterReadyEvent;

@Component
public class BatchRunner {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	@Qualifier("job1")
	private Job job1;
	
	@EventListener(AfterReadyEvent.class)
	public void lauchBatch() throws JobExecutionAlreadyRunningException, 
									JobRestartException, JobInstanceAlreadyCompleteException, 
									JobParametersInvalidException {
		jobLauncher.run(job1, new JobParameters());
	}
}
