package com.covid.dev.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.covid.dev.batch.mapper.CovidHospTxadAgeFraMapper;
import com.covid.dev.dto.CovidHospTxadAgeFraDto;
import com.covid.dev.util.SystemUtils;

@Component
public class CovidHospTxadAgeFraReader {
	
	@Autowired
	private SystemUtils systemUtils;
	
	@Autowired
	private CovidHospTxadAgeFraMapper covidHospTxadAgeFraMapper;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospTxadAgeFraDto> reader() {
		FlatFileItemReader<CovidHospTxadAgeFraDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo1()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setNames(new String[] {"fra", "jour", "clage_90", "PourAvec", "tx_indic_7J_DC", "tx_indic_7J_hosp", "tx_indic_7J_SC", "tx_prev_hosp", "tx_prev_SC"});
		return tokenizer;
	}
		
	private DefaultLineMapper<CovidHospTxadAgeFraDto> lineMapper(){
		DefaultLineMapper<CovidHospTxadAgeFraDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(covidHospTxadAgeFraMapper);
		return mapper;
	}
	
}
