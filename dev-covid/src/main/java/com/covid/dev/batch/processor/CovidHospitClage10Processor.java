package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospitClage10;
import com.covid.dev.dto.CovidHospitClage10Dto;

@Component
public class CovidHospitClage10Processor implements ItemProcessor<CovidHospitClage10Dto, CovidHospitClage10>{

	@Override
	public CovidHospitClage10 process(CovidHospitClage10Dto item) throws Exception {
		CovidHospitClage10 dataItem = new CovidHospitClage10();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
