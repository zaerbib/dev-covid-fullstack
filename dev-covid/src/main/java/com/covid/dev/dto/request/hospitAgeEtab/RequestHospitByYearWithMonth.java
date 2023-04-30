package com.covid.dev.dto.request.hospitAgeEtab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@Builder
public class RequestHospitByYearWithMonth {
    private Integer annee;
    private Integer dep;
    private Integer month;
}
