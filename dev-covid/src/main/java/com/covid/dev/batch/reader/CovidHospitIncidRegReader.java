package com.covid.dev.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.covid.dev.batch.mapper.CovidHospitIncidRegMapper;
import com.covid.dev.dto.CovidHospitIncidRegDto;
import com.covid.dev.util.SystemUtils;

@Component
public class CovidHospitIncidRegReader {


	@Autowired
	private SystemUtils systemUtils;
	
	@Autowired
	private CovidHospitIncidRegMapper covidHospitIncidRegMapper;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospitIncidRegDto> reader() {
		FlatFileItemReader<CovidHospitIncidRegDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo5()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setNames(new String[] {"jour", "nomReg", "numReg", "incid_rea"});
		return tokenizer;
	}
	
	private DefaultLineMapper<CovidHospitIncidRegDto> lineMapper(){
		DefaultLineMapper<CovidHospitIncidRegDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(covidHospitIncidRegMapper);
		return mapper;
	}
}
