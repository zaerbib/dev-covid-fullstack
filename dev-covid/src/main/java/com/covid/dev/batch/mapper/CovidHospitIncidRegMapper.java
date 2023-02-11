package com.covid.dev.batch.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.covid.dev.dto.CovidHospitIncidRegDto;

@Component
public class CovidHospitIncidRegMapper implements FieldSetMapper<CovidHospitIncidRegDto>{

	@Override
	public CovidHospitIncidRegDto mapFieldSet(FieldSet fieldSet) throws BindException {
		CovidHospitIncidRegDto dataItem = new CovidHospitIncidRegDto();
		
		dataItem.setJour(LocalDate.parse(fieldSet.readString("jour")));
		dataItem.setNomReg(fieldSet.readString("nomReg"));
		dataItem.setNumReg(parseStringToInteger(fieldSet.readString("numReg")));
		dataItem.setIncidRea(parseStringToInteger(fieldSet.readString("incid_rea")));
		
		return dataItem;
	}
	
	private Integer parseStringToInteger(String str) {
		return str.equals("") || str.equals("NA") ? 0 : Integer.parseInt(str);
	}

}
