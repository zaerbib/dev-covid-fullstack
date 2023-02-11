package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospTxadReg;

@Repository
public interface CovidHospTxadRegRepository extends JpaRepository<CovidHospTxadReg, Long> {}
