package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospit;

import java.util.List;

@Repository
public interface CovidHospitRepository extends JpaRepository<CovidHospit, Long> {
    @Query(value = "select * from covid_hospit che where date_part('Year', che.jour) =:annee", nativeQuery = true)
    public List<CovidHospit> findCovidHospitByAnne(Integer annee);

    @Query(value = "select * from covid_hospit " +
            "che where date_part('Year', che.jour)=:annee and date_part('month', che.jour) =:mois", nativeQuery = true)
    public List<CovidHospit> findCovidHospitByAnneAndMois(Integer annee, Integer mois);

    @Query(value = "select * from covid_hospit che " +
            "where date_part('Year', che.jour)=:annee  and date_part('month', che.jour)=:mois " +
            "and che.dep=:dep", nativeQuery = true)
    public List<CovidHospit> findCovidHospitByAnneeAndMoisAndDep(Integer annee, Integer mois, String dep);

    @Query(value = "select sum(ch.hosp) from covid_hospit ch " +
            "where date_part('Year', ch.jour)=:annee", nativeQuery = true)
    public Integer totalHospitSurUnAn(Integer annee);

    @Query(value = "select sum(ch.hosp) from covid_hospit ch " +
            "where date_part('Year', ch.jour)=:annee and date_part('month', ch.jour)=:mois", nativeQuery = true)
    public Integer totalHospitSurUnMois(Integer annee, Integer mois);

}
