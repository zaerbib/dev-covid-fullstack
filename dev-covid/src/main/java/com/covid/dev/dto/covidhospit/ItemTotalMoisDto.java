package com.covid.dev.dto.covidhospit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemTotalMoisDto {
    private Integer annee;
    private Integer mois;
    private Integer total;
}
