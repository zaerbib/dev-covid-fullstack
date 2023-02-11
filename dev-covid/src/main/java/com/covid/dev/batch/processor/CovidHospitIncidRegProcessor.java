package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospitIncidReg;
import com.covid.dev.dto.CovidHospitIncidRegDto;

@Component
public class CovidHospitIncidRegProcessor implements ItemProcessor<CovidHospitIncidRegDto, CovidHospitIncidReg> {

	@Override
	public CovidHospitIncidReg process(CovidHospitIncidRegDto item) throws Exception {
		CovidHospitIncidReg dataItem = new CovidHospitIncidReg();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
