package com.covid.dev.batch;

import com.covid.dev.batch.processor.*;
import com.covid.dev.batch.reader.*;
import com.covid.dev.batch.writer.*;
import com.covid.dev.data.*;
import com.covid.dev.dto.*;
import com.covid.dev.util.BatchUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private CovidHospTxadAgeFraReader covidHospTxadAgeFraReader;
	
	@Autowired
	private CovidHospTxadAgeFraWriter covidHospTxadAgeFraWriter;
	
	@Autowired
	private CovidHospTxadAgeFraProcessor covidHospTxadAgeFraProcessor;
	
	@Autowired
	private CovidHospTxadRegReader covidHospTxadRegReader;
	
	@Autowired
	private CovidHospTxadRegWriter covidHospTxadRegWriter;
	
	@Autowired
	private CovidHospTxadRegProcessor covidHospTxadRegProcessor;
	
	@Autowired
	private CovidHospTxadFraReader covidHospTxadFraReader;
	
	@Autowired
	private CovidHospTxadFraProcessor covidHospTxadFraProcessor;
	
	@Autowired
	private CovidHospTxadFraWriter covidHospTxadFraWriter; 
	
	@Autowired
	private CovidHospAdAgeReader covidHospAdAgeReader;
	
	@Autowired
	private CovidHospAdAgeProcessor covidHospAdAgeProcessor;
	
	@Autowired
	private CovidHospAdAgeWriter covidHospAdAgeWriter;
	
	@Autowired
	private CovidHospitIncidRegReader covidHospitIncidRegReader;
	
	@Autowired
	private CovidHospitIncidRegProcessor covidHospitIncidRegProcessor;
	
	@Autowired
	private CovidHospitIncidRegWriter covidHospitIncidRegWriter;

	@Autowired
	private CovidHospitReader covidHospitReader;

	@Autowired
	private CovidHospitProcessor covidHospitProcessor;

	@Autowired
	private CovidHospitWriter covidHospitWriter;

	@Autowired
	private CovidHospitClage10Reader covidHospitClage10Reader;
	@Autowired
	private CovidHospitClage10Processor covidHospitClage10Processor;
	@Autowired
	private CovidHospitClage10Writer covidHospitClage10Writer;

	@Autowired
	private CovidHospitEtabReader covidHospitEtabReader;
	@Autowired
	private CovidHospitEtabProcessor covidHospitEtabProcessor;
	@Autowired
	private CovidHospitEtabWriter covidHospitEtabWriter;

	@Autowired
	private CovidHospitIncidReader covidHospitIncidReader;
	@Autowired
	private CovidHospitIncidProcessor covidHospitIncidProcessor;
	@Autowired
	private CovidHospitIncidWriter covidHospitIncidWriter;

	
	@Bean(name = "job1")
	public Job job1() {
		return jobBuilderFactory.get(BatchUtils.job1)
				.start(step1())
				.next(step2())
				.next(step3())
				.next(step4())
				.next(step5())
				.next(step6())
				.next(step7())
				.next(step8())
				.next(step9())
				.build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get(BatchUtils.step1)
				.<CovidHospTxadAgeFraDto, CovidHospTxadAgeFra> chunk(500)
				.reader(covidHospTxadAgeFraReader.reader())
				.processor(covidHospTxadAgeFraProcessor)
				.writer(covidHospTxadAgeFraWriter)
				.allowStartIfComplete(true)
				.build();
	}	
	
	@Bean
	public Step step2() {
		return stepBuilderFactory.get(BatchUtils.step2)
				.<CovidHospTxadRegDto, CovidHospTxadReg> chunk(500)
				.reader(covidHospTxadRegReader.reader())
				.processor(covidHospTxadRegProcessor)
				.writer(covidHospTxadRegWriter)
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public Step step3() {
		return stepBuilderFactory.get(BatchUtils.step3)
				.<CovidHospTxadFraDto, CovidHospTxadFra> chunk(500)
				.reader(covidHospTxadFraReader.reader())
				.processor(covidHospTxadFraProcessor)
				.writer(covidHospTxadFraWriter)
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public Step step4() {
		return stepBuilderFactory.get(BatchUtils.step4)
				.<CovidHospAdAgeDto, CovidHospAdAge> chunk(500)
				.reader(covidHospAdAgeReader.reader())
				.processor(covidHospAdAgeProcessor)
				.writer(covidHospAdAgeWriter)
				.allowStartIfComplete(true)
				.build();
	}
	
	@Bean
	public Step step5() {
		return stepBuilderFactory.get(BatchUtils.step5)
				.<CovidHospitIncidRegDto, CovidHospitIncidReg>chunk(500)
				.reader(covidHospitIncidRegReader.reader())
				.processor(covidHospitIncidRegProcessor)
				.writer(covidHospitIncidRegWriter)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Step step6() {
		return stepBuilderFactory.get(BatchUtils.step6)
				.<CovidHospitDto, CovidHospit>chunk(1000)
				.reader(covidHospitReader.reader())
				.processor(covidHospitProcessor)
				.writer(covidHospitWriter)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Step step7(){
		return stepBuilderFactory.get(BatchUtils.step7)
				.<CovidHospitClage10Dto, CovidHospitClage10>chunk(1000)
				.reader(covidHospitClage10Reader.reader())
				.processor(covidHospitClage10Processor)
				.writer(covidHospitClage10Writer)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Step step8(){
		return stepBuilderFactory.get(BatchUtils.step8)
				.<CovidHospitEtabDto, CovidHospitEtab>chunk(500)
				.reader(covidHospitEtabReader.reader())
				.processor(covidHospitEtabProcessor)
				.writer(covidHospitEtabWriter)
				.allowStartIfComplete(true)
				.build();
	}

	@Bean
	public Step step9(){
		return stepBuilderFactory.get(BatchUtils.step9)
				.<CovidHospitIncidDto, CovidHospitIncid>chunk(500)
				.reader(covidHospitIncidReader.reader())
				.processor(covidHospitIncidProcessor)
				.writer(covidHospitIncidWriter)
				.allowStartIfComplete(true)
				.build();
	}
}
