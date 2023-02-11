package com.covid.dev.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class CovidHospitClage10Dto {
	private Integer reg;
	private Integer clage90;
	private LocalDate jour;
	private Integer hosp;
	private Integer rea;
	private Integer hospConv;
	private Integer ssrUsld;
	private Integer autres;
	private Integer rad;
	private Integer dc;
}
