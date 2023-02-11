package com.covid.dev.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CovidHospitIncidRegDto {
	private LocalDate jour;
	private String nomReg;
	private Integer numReg;
	private Integer incidRea;
}
