package com.covid.dev.dto.covidhospitetab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemHospitEtabByDepByYearByMonth {
    private Integer dep;
    private Integer nb;
    private Integer annee;
    private Integer month;
}
