package com.covid.dev.dto.covidhospitetab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemHospitEtab {
    private Integer dep;
    private Integer nb;
}
