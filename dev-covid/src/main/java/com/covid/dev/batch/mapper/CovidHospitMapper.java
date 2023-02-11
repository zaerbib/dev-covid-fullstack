package com.covid.dev.batch.mapper;

import com.covid.dev.dto.CovidHospitDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Component
@Slf4j
public class CovidHospitMapper implements FieldSetMapper<CovidHospitDto> {
    @Override
    public CovidHospitDto mapFieldSet(FieldSet fieldSet) throws BindException {
        CovidHospitDto covidHospitDto = new CovidHospitDto();
        covidHospitDto.setDep(fieldSet.readString("dep"));
        covidHospitDto.setSex(fieldSet.readChar("sexe"));
        // covidHospitDto.setJour(new SimpleDateFormat("yyyy-MM-dd").parse(fieldSet.readString("jour")));
        covidHospitDto.setJour(LocalDate.parse(fieldSet.readString("jour")));
        covidHospitDto.setHosp(parseStringToInteger(fieldSet.readString("hosp")));
        covidHospitDto.setRea(parseStringToInteger(fieldSet.readString("rea")));
        covidHospitDto.setHospConv(parseStringToInteger(fieldSet.readString("HospConv")));
        covidHospitDto.setSsrUsld(parseStringToInteger(fieldSet.readString("SSR_USLD")));
        covidHospitDto.setAutres(parseStringToInteger(fieldSet.readString("autres")));
        covidHospitDto.setRad(parseStringToInteger(fieldSet.readString("rad")));
        covidHospitDto.setDc(parseStringToInteger(fieldSet.readString("dc")));
        return covidHospitDto;
    }

    private Integer parseStringToInteger(String str) {
        return str.equals("") || str.equals("NA") || str.contains("NA")
                || str.contains("A") || str.contains("B") ? 0 : Integer.parseInt(str);
    }
}
