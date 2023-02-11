package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospTxadAgeFra;

@Repository
public interface CovidHospTxadAgeFraRepository extends  JpaRepository<CovidHospTxadAgeFra, Long> {}
