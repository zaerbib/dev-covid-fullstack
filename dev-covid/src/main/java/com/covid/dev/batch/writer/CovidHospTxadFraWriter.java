package com.covid.dev.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.covid.dev.repository.CovidHospTxadFraRepository;
import com.covid.dev.data.CovidHospTxadFra;

@Component
public class CovidHospTxadFraWriter implements ItemWriter<CovidHospTxadFra>{
	@Autowired
	private CovidHospTxadFraRepository covidHospTxadFraRepository;

	@Override
	public void write(List<? extends CovidHospTxadFra> items) throws Exception {
		covidHospTxadFraRepository.saveAllAndFlush(items);
	}
}
