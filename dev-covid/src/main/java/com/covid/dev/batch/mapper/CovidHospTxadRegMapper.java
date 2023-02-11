package com.covid.dev.batch.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.covid.dev.dto.CovidHospTxadRegDto;

@Component
public class CovidHospTxadRegMapper implements FieldSetMapper<CovidHospTxadRegDto>{

	@Override
	public CovidHospTxadRegDto mapFieldSet(FieldSet fieldSet) throws BindException {
		CovidHospTxadRegDto dataItem = new CovidHospTxadRegDto();
		dataItem.setReg(fieldSet.readString("reg"));

		//dataItem.setJour(new SimpleDateFormat("yyyy-mm-dd").parse(fieldSet.readString("jour")));
		dataItem.setJour(LocalDate.parse(fieldSet.readString("jour")));

		dataItem.setPourAvec(parseStringToInteger(fieldSet.readString("PourAvec")));
		dataItem.setTxIndic7JDc(parseStringToDouble(fieldSet.readString("tx_indic_7J_DC")));
		dataItem.setTxIndic7JHosp(parseStringToDouble(fieldSet.readString("tx_indic_7J_hosp")));
		dataItem.setTxIndic7JSc(parseStringToDouble(fieldSet.readString("tx_indic_7J_SC")));
		dataItem.setTxPrevHosp(parseStringToDouble(fieldSet.readString("tx_prev_hosp")));
		dataItem.setTxPrevSc(parseStringToDouble(fieldSet.readString("tx_prev_SC")));
		
		return dataItem;
	}
	
	private Double parseStringToDouble(String str) {
		return str.equals("") ? 0.0 : Double.parseDouble(str);
	}
	
	private Integer parseStringToInteger(String str) {
		return str.equals("") ? 0 : Integer.parseInt(str);
	}

}
