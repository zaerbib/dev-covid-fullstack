package com.covid.dev.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CovidHospTxadRegDto {
	private String reg;
	private LocalDate jour;
	private Integer pourAvec;
	private Double txIndic7JDc;
	private Double txIndic7JHosp;
	private Double txIndic7JSc;
	private Double txPrevHosp;
	private Double txPrevSc;
}
