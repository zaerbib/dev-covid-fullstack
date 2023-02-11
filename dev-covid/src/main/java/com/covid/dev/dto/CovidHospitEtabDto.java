package com.covid.dev.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitEtabDto {
	private Integer dep;
	private LocalDate jour;
	private Integer nb;
}
