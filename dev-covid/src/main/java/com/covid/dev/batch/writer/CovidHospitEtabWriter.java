package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospitEtabRepository;
import com.covid.dev.data.CovidHospitEtab;

@Component
public class CovidHospitEtabWriter implements ItemWriter<CovidHospitEtab> {
	@Autowired
	private CovidHospitEtabRepository covidHospitEtabRepository;

	@Override
	public void write(List<? extends CovidHospitEtab> items) throws Exception {
		covidHospitEtabRepository.saveAllAndFlush(items);
	}
}
