package com.covid.dev.batch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.covid.dev.dto.CovidHospAdAgeDto;

@Component
public class CovidHospAdAgeMapper implements FieldSetMapper<CovidHospAdAgeDto>{

	@Override
	public CovidHospAdAgeDto mapFieldSet(FieldSet fieldSet) throws BindException {
		CovidHospAdAgeDto dataItem = new CovidHospAdAgeDto();
		
		dataItem.setReg(parseStringToInteger(fieldSet.readString("reg")));
		dataItem.setSemaine(fieldSet.readString("Semaine"));
		dataItem.setClage90(parseStringToInteger(fieldSet.readString("cl_age90")));
		dataItem.setNewAdmHospit(fieldSet.readString("NewAdmHospit"));	
		
		return dataItem;
	}
	
	private Integer parseStringToInteger(String str) {
		return str.equals("") ? 0 : Integer.parseInt(str);
	}
}
