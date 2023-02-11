package com.covid.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.dev.data.CovidHospAdAge;

@Repository
public interface CovidHospAdAgeRepository extends JpaRepository<CovidHospAdAge, Long> {

}
