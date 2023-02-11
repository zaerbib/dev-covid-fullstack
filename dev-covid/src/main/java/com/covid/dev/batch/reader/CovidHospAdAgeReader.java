package com.covid.dev.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.covid.dev.batch.mapper.CovidHospAdAgeMapper;
import com.covid.dev.dto.CovidHospAdAgeDto;
import com.covid.dev.util.SystemUtils;

@Component
public class CovidHospAdAgeReader {

	@Autowired
	private SystemUtils systemUtils;
	
	@Autowired
	private CovidHospAdAgeMapper covidHospAdAgeMapper;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospAdAgeDto> reader() {
		FlatFileItemReader<CovidHospAdAgeDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo4()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setNames(new String[] {"reg", "Semaine", "cl_age90", "NewAdmHospit"});
		return tokenizer;
	}
	
	private DefaultLineMapper<CovidHospAdAgeDto> lineMapper(){
		DefaultLineMapper<CovidHospAdAgeDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(covidHospAdAgeMapper);
		return mapper;
	}
}
