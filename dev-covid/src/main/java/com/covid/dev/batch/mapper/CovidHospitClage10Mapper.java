package com.covid.dev.batch.mapper;

import com.covid.dev.dto.CovidHospitClage10Dto;
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
public class CovidHospitClage10Mapper implements FieldSetMapper<CovidHospitClage10Dto> {
    @Override
    public CovidHospitClage10Dto mapFieldSet(FieldSet fieldSet) throws BindException {
        CovidHospitClage10Dto covidHospitClage10Dto = new CovidHospitClage10Dto();

        covidHospitClage10Dto.setReg(parseStringToInteger(fieldSet.readString("reg")));
        covidHospitClage10Dto.setClage90(parseStringToInteger(fieldSet.readString("cl_age90")));
        covidHospitClage10Dto.setJour(LocalDate.parse(fieldSet.readString("jour")));
        covidHospitClage10Dto.setHosp(parseStringToInteger(fieldSet.readString("hosp")));
        covidHospitClage10Dto.setRea(parseStringToInteger(fieldSet.readString("rea")));
        covidHospitClage10Dto.setHospConv(parseStringToInteger(fieldSet.readString("HospConv")));
        covidHospitClage10Dto.setSsrUsld(parseStringToInteger(fieldSet.readString("SSR_USLD")));
        covidHospitClage10Dto.setAutres(parseStringToInteger(fieldSet.readRawString("autres")));
        covidHospitClage10Dto.setRad(parseStringToInteger(fieldSet.readString("rad")));
        covidHospitClage10Dto.setDc(parseStringToInteger(fieldSet.readString("dc")));

        return covidHospitClage10Dto;
    }

    private Integer parseStringToInteger(String str) {
        return str.equals("") || str.equals("NA") ? 0 : Integer.parseInt(str);
    }

}
