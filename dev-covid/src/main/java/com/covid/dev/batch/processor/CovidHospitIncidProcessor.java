package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospitIncid;
import com.covid.dev.dto.CovidHospitIncidDto;

@Component
public class CovidHospitIncidProcessor implements ItemProcessor<CovidHospitIncidDto, CovidHospitIncid> {

	@Override
	public CovidHospitIncid process(CovidHospitIncidDto item) throws Exception {
		CovidHospitIncid dataItem = new CovidHospitIncid();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
