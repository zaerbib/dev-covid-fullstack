package com.covid.dev.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CovidHospitEtabDto {
	private Integer dep;
	private LocalDate jour;
	private Integer nb;
}
