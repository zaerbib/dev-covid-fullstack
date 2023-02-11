package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospAdAge;
import com.covid.dev.dto.CovidHospAdAgeDto;

@Component
public class CovidHospAdAgeProcessor implements ItemProcessor<CovidHospAdAgeDto, CovidHospAdAge> {

	@Override
	public CovidHospAdAge process(CovidHospAdAgeDto item) throws Exception {
		CovidHospAdAge dataItem = new CovidHospAdAge();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
