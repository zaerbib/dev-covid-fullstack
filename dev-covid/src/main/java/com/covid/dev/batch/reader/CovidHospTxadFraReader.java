package com.covid.dev.batch.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.covid.dev.batch.mapper.CovidHospTxadFraMapper;
import com.covid.dev.dto.CovidHospTxadFraDto;
import com.covid.dev.util.SystemUtils;

@Component
public class CovidHospTxadFraReader {

	@Autowired
	private SystemUtils systemUtils;
	
	@Autowired
	private CovidHospTxadFraMapper covidHospTxadFraMapper;
	
	/**
	 * read line from file 
	 * @return
	 */
	public FlatFileItemReader<CovidHospTxadFraDto> reader() {
		FlatFileItemReader<CovidHospTxadFraDto> reader = new FlatFileItemReader<>();
		
		reader.setResource(new FileSystemResource(systemUtils.getEntrepo3()));
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	private DelimitedLineTokenizer delimit1() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(";");
		tokenizer.setNames(new String[] {"fra", "strate2", "jour", "PourAvec", "tx_indic_7J_DC", "tx_indic_7J_hosp", "tx_indic_7J_SC", "tx_prev_hosp", "tx_prev_SC"});
		return tokenizer;
	}
	
	private DefaultLineMapper<CovidHospTxadFraDto> lineMapper(){
		DefaultLineMapper<CovidHospTxadFraDto> mapper = new DefaultLineMapper<>();
		mapper.setLineTokenizer(delimit1());
		mapper.setFieldSetMapper(covidHospTxadFraMapper);
		return mapper;
	}

}
