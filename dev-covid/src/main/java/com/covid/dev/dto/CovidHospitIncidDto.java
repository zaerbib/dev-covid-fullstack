package com.covid.dev.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitIncidDto {
	private Integer dep;
	private LocalDate jour;
	private Integer incidHosp;
	private Integer incidRea;
	private Integer incidDc;
	private Integer incidRad;
}
