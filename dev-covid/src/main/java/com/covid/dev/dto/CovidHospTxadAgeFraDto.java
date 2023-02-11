package com.covid.dev.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class CovidHospTxadAgeFraDto {
	private String fra;	
	private LocalDate jour;
	private Integer clage90;
	private Integer pourAvec;
	private Double txIndic7JDc;
	private Double txIndic7JHosp;
	private Double txIndic7JSc;
	private Double txPrevHosp;
	private Double txPrevSc;
}
