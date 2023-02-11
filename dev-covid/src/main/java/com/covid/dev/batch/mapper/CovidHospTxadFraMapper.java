package com.covid.dev.batch.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.covid.dev.dto.CovidHospTxadFraDto;

@Component
public class CovidHospTxadFraMapper implements FieldSetMapper<CovidHospTxadFraDto> {

	@Override
	public CovidHospTxadFraDto mapFieldSet(FieldSet fieldSet) throws BindException {
		CovidHospTxadFraDto dataItem = new CovidHospTxadFraDto();
		dataItem.setFra(fieldSet.readString("fra"));
		dataItem.setStrate2(parseStringToInteger(fieldSet.readString("strate2")));

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

	private Date parseStringtoDate(String str) {
		try {
			return new SimpleDateFormat("yyyy-mm-dd").parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
}
