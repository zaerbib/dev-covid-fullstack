package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospTxadFra;
import com.covid.dev.dto.CovidHospTxadFraDto;

@Component
public class CovidHospTxadFraProcessor implements ItemProcessor<CovidHospTxadFraDto, CovidHospTxadFra>{

	@Override
	public CovidHospTxadFra process(CovidHospTxadFraDto item) throws Exception {
		CovidHospTxadFra dataItem = new CovidHospTxadFra();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
