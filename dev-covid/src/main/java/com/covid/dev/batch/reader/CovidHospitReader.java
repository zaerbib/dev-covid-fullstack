package com.covid.dev.batch.reader;

import com.covid.dev.batch.mapper.CovidHospitMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.covid.dev.dto.CovidHospitDto;
import com.covid.dev.util.SystemUtils;

@Component
public class CovidHospitReader {

	@Autowired
	private SystemUtils systemUtils;

	@Autowired
	private CovidHospitMapper covidHospitMapper;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospitDto> reader() {
		FlatFileItemReader<CovidHospitDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo6()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setNames(new String[] {"dep", "sexe", "jour", "hosp", "rea", "HospConv", "SSR_USLD", "autres", "rad", "dc"});
		return tokenizer;
	}
	
	private BeanWrapperFieldSetMapper<CovidHospitDto> fieldMapper1(){
		BeanWrapperFieldSetMapper<CovidHospitDto> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(CovidHospitDto.class);
		return beanMapper;
	}
	
	private DefaultLineMapper<CovidHospitDto> lineMapper(){
		DefaultLineMapper<CovidHospitDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(covidHospitMapper);
		return mapper;
	}

}
