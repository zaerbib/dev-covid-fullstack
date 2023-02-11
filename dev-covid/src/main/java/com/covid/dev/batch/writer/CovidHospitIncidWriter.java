package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospitIncidRepository;
import com.covid.dev.data.CovidHospitIncid;

@Component
public class CovidHospitIncidWriter implements ItemWriter<CovidHospitIncid> {
	@Autowired
	private CovidHospitIncidRepository covidHospitIncidRepository;

	@Override
	public void write(List<? extends CovidHospitIncid> items) throws Exception {
		covidHospitIncidRepository.saveAllAndFlush(items);
	}
}
