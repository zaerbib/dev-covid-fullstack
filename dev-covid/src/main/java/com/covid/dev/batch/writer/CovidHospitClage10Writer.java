package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospitClage10Repository;
import com.covid.dev.data.CovidHospitClage10;

@Component
public class CovidHospitClage10Writer implements ItemWriter<CovidHospitClage10> {
	@Autowired
	private CovidHospitClage10Repository covidHospitClage10Repository;
	
	@Override
	public void write(List<? extends CovidHospitClage10> items) throws Exception {
		covidHospitClage10Repository.saveAllAndFlush(items);
	}
}
