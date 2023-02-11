package com.covid.dev.dto.covidhospit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Les données rélatives aux hospitalisations uniquement
 */
@Data
@AllArgsConstructor
@Builder
public class ItemHospitDto {
    private Integer nombreHospit;
    private Integer mois;
    private Integer annee;
    private String dep;
}
