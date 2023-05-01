package com.covid.dev.repository;

import com.covid.dev.dto.covidhospitetab.ItemHospitEtab;
import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.dev.data.CovidHospitEtab;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidHospitEtabRepository extends JpaRepository<CovidHospitEtab, Long> {

    @Query(value="select * from covid_hosp_etab che " +
            "where date_part('year', che.jour) =:annee " +
            "and che.dep in (select che2.dep from covid_hosp_etab che2) ", nativeQuery = true)
    List<CovidHospitEtab> findAllHospitByDepByYear(Integer annee);

    @Query(value="select * from covid_hosp_etab che " +
            "where date_part('year', che.jour) =:annee " +
            "and date_part('month', che.jour) =:month " +
            "and che.dep in (select che2.dep from covid_hosp_etab che2) ", nativeQuery = true)
    List<CovidHospitEtab> findAllHospitByDepByYearByMonth(Integer annee, Integer month);
}
