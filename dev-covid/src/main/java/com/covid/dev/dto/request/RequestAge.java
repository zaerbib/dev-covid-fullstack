package com.covid.dev.dto.request;

import com.covid.dev.dto.request.hospitAgeEtab.RequestHospitByYearWithMonth;
import com.covid.dev.dto.request.hospitAgeEtab.RequestHospitDepByYear;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(RequestHospitDepByYear.class),
        @JsonSubTypes.Type(RequestHospitByYearWithMonth.class)
})
public interface RequestAge {
}
