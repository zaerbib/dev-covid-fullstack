package com.covid.dev.dto.covidhospit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemMoyenneMoisDto {
    private Integer annee, mois;
    private Double moyenne;
}
