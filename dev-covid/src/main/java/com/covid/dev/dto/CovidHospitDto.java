package com.covid.dev.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitDto {
	private String dep;
	private Character sex;
	private LocalDate jour;
	private Integer hosp;
	private Integer rea;
	private Integer hospConv;
	private Integer ssrUsld;
	private Integer autres;
	private Integer rad;
	private Integer dc;
}
