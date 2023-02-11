package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospTxadAgeFra;
import com.covid.dev.dto.CovidHospTxadAgeFraDto;

@Component
public class CovidHospTxadAgeFraProcessor implements ItemProcessor<CovidHospTxadAgeFraDto, CovidHospTxadAgeFra>{

	@Override
	public CovidHospTxadAgeFra process(CovidHospTxadAgeFraDto item) throws Exception {
		CovidHospTxadAgeFra dataItem = new CovidHospTxadAgeFra();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}

}
