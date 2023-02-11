package com.covid.dev.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.covid.dev.data.CovidHospTxadReg;
import com.covid.dev.dto.CovidHospTxadRegDto;

@Component
public class CovidHospTxadRegProcessor implements ItemProcessor<CovidHospTxadRegDto, CovidHospTxadReg>{

	@Override
	public CovidHospTxadReg process(CovidHospTxadRegDto item) throws Exception {
		CovidHospTxadReg dataItem = new CovidHospTxadReg();
		BeanUtils.copyProperties(item, dataItem);
		return dataItem;
	}
	
}
