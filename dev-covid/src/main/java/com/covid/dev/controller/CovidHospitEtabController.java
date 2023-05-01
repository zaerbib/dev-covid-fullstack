package com.covid.dev.controller;

import com.covid.dev.dto.covidhospitetab.ItemHospitEtabByDepByYear;
import com.covid.dev.dto.covidhospitetab.ItemHospitEtabByDepByYearByMonth;
import com.covid.dev.dto.request.hospitAgeEtab.RequestHospitByYearWithMonth;
import com.covid.dev.dto.request.hospitAgeEtab.RequestHospitDepByYear;
import com.covid.dev.service.CovidHospitByDepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/covidhospitetab")
public class CovidHospitEtabController {

    private final CovidHospitByDepService covidHospitByDepService;

    public CovidHospitEtabController(CovidHospitByDepService covidHospitByDepService) {
        this.covidHospitByDepService = covidHospitByDepService;
    }

    @GetMapping("byYear")
    public Mono<List<ItemHospitEtabByDepByYear>> listItemHospitEtabByDepByYear(@RequestBody RequestHospitDepByYear requestHospitDepByYear) {
        return covidHospitByDepService.listHospitEtabByYear(requestHospitDepByYear);
    }

    @GetMapping("byYear/byMonth")
    public Mono<List<ItemHospitEtabByDepByYearByMonth>> listItemHospitEtabByDepByYearByMonth(@RequestBody RequestHospitByYearWithMonth requestHospitByYearWithMonth){
        return covidHospitByDepService.listHospitByYearByMonth(requestHospitByYearWithMonth);
    }
}
