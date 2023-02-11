package com.covid.dev.batch.reader;

import com.covid.dev.batch.mapper.CovidHospitEtabMapper;
import com.covid.dev.dto.CovidHospitEtabDto;
import com.covid.dev.util.SystemUtils;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CovidHospitEtabReader {

    @Autowired
    private SystemUtils systemUtils;

    @Autowired
    private CovidHospitEtabMapper covidHospitEtabMapper;

    public FlatFileItemReader<CovidHospitEtabDto> reader(){
        FlatFileItemReader<CovidHospitEtabDto> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(systemUtils.getEntrepo9()));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    private DelimitedLineTokenizer delimit1() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(";");
        tokenizer.setNames(new String[] {"dep", "jour", "nb"});
        return tokenizer;
    }

    private DefaultLineMapper<CovidHospitEtabDto> lineMapper(){
        DefaultLineMapper<CovidHospitEtabDto> mapper = new DefaultLineMapper<>();
        mapper.setLineTokenizer(delimit1());
        mapper.setFieldSetMapper(covidHospitEtabMapper);
        return mapper;
    }
}
