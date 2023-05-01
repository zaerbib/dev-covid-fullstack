package com.covid.dev.dto.request.hospitAgeEtab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestHospitByYearWithMonth implements Serializable {
    private Integer annee;
    private Integer dep;
    private Integer month;
}
