package com.covid.dev.batch.reader;

import com.covid.dev.batch.mapper.CovidHospitClage10Mapper;
import com.covid.dev.dto.CovidHospitClage10Dto;
import com.covid.dev.util.SystemUtils;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class CovidHospitClage10Reader {

    @Autowired
    private SystemUtils systemUtils;

    @Autowired
    private CovidHospitClage10Mapper covidHospitClage10Mapper;

    public FlatFileItemReader<CovidHospitClage10Dto> reader(){
        FlatFileItemReader<CovidHospitClage10Dto> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(systemUtils.getEntrepo8()));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    private DelimitedLineTokenizer delimit1() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(";");
        tokenizer.setNames(new String[] {"reg", "cl_age90", "jour", "hosp", "rea", "HospConv", "SSR_USLD", "autres", "rad", "dc"});
        return tokenizer;
    }

    private DefaultLineMapper<CovidHospitClage10Dto> lineMapper(){
        DefaultLineMapper<CovidHospitClage10Dto> mapper = new DefaultLineMapper<>();
        mapper.setLineTokenizer(delimit1());
        mapper.setFieldSetMapper(covidHospitClage10Mapper);
        return mapper;
    }
}
