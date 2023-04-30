package com.covid.dev.dto.request.hospitAgeEtab;

import com.covid.dev.dto.request.RequestAge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@Builder
public class RequestHospitDepByYear implements RequestAge {

    private Integer annee;
    private Integer dep;
}
