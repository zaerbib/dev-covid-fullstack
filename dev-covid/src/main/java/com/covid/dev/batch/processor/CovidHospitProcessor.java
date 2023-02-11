package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospit;
import com.covid.dev.dto.CovidHospitDto;

@Component
public class CovidHospitProcessor implements ItemProcessor<CovidHospitDto, CovidHospit> {

	@Override
	public CovidHospit process(CovidHospitDto item) throws Exception {
		CovidHospit dataItem = new CovidHospit();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}
}
