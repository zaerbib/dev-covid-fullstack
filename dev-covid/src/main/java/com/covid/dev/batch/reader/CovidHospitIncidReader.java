package com.covid.dev.batch.reader;

import com.covid.dev.batch.mapper.CovidHospitIncidMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.covid.dev.dto.CovidHospitIncidDto;
import com.covid.dev.util.SystemUtils;

@Component
public class CovidHospitIncidReader {

	@Autowired
	private SystemUtils systemUtils;

	@Autowired
	private CovidHospitIncidMapper covidHospitIncidMapper;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospitIncidDto> reader() {
		FlatFileItemReader<CovidHospitIncidDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo7()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setNames(new String[] {"dep", "jour", "incid_hosp", "incid_rea", "incid_dc", "incid_rad"});
		return tokenizer;
	}
	
	private BeanWrapperFieldSetMapper<CovidHospitIncidDto> fieldMapper1(){
		BeanWrapperFieldSetMapper<CovidHospitIncidDto> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(CovidHospitIncidDto.class);
		return beanMapper;
	}
	
	private DefaultLineMapper<CovidHospitIncidDto> lineMapper(){
		DefaultLineMapper<CovidHospitIncidDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(covidHospitIncidMapper);
		return mapper;
	}

}
