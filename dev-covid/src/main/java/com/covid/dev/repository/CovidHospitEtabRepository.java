package com.covid.dev.repository;

import com.covid.dev.dto.covidhospitetab.ItemHospitEtab;
import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.dev.data.CovidHospitEtab;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidHospitEtabRepository extends JpaRepository<CovidHospitEtab, Long> {

    @Query(value="select che.dep, sum(che.nb) as nb from covid_hosp_etab che " +
            "where date_depart('year', che.jour) =:annee " +
            "and che.dep in (select che2.dep from covid_hosp_etab che2) " +
            "group by che.dep " +
            "order by che.dep", nativeQuery = true)
    List<ItemHospitEtab> findAllHospitByDepByYear(Integer annee);

    @Query(value="select che.dep, sum(che.nb) as nb from covid_hosp_etab che " +
            "where date_depart('year', che.jour) =:annee " +
            "and date_part('month', che.jour) =:month " +
            "and che.dep in (select che2.dep from covid_hosp_etab che2) " +
            "group by che.dep " +
            "order by che.dep", nativeQuery = true)
    List<ItemHospitEtab> findAllHospitByDepByYearByMonth(Integer annee, Integer month);
}
