package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospTxadFra;

@Repository
public interface CovidHospTxadFraRepository extends JpaRepository<CovidHospTxadFra, Long> {

}
