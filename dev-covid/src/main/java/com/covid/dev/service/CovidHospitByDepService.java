package com.covid.dev.service;

import com.covid.dev.annotation.TrackTime;
import com.covid.dev.data.CovidHospitEtab;
import com.covid.dev.dto.CovidHospitEtabDto;
import com.covid.dev.dto.covidhospitetab.ItemHospitEtabByDepByYear;
import com.covid.dev.dto.covidhospitetab.ItemHospitEtabByDepByYearByMonth;
import com.covid.dev.dto.request.hospitAgeEtab.RequestHospitByYearWithMonth;
import com.covid.dev.dto.request.hospitAgeEtab.RequestHospitDepByYear;
import com.covid.dev.repository.CovidHospitEtabRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CovidHospitByDepService {

    private final CovidHospitEtabRepository covidHospitEtabRepository;

    public CovidHospitByDepService(CovidHospitEtabRepository covidHospitEtabRepository) {
        this.covidHospitEtabRepository = covidHospitEtabRepository;
    }

    @TrackTime
    public Mono<List<ItemHospitEtabByDepByYear>> listHospitEtabByYear(RequestHospitDepByYear requestHospitDepByYear){
        return Mono.justOrEmpty(covidHospitEtabRepository.findAllHospitByDepByYear(requestHospitDepByYear.getAnnee()))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> log.info("begin compute hospit etab by year !!!"))
                .map(item -> fromCovidHopsitEtabToDto(item))
                .map(item -> item.stream().collect(Collectors.groupingBy(CovidHospitEtabDto::getDep, Collectors.summingInt(CovidHospitEtabDto::getNb))))
                .map(item -> item.entrySet().stream()
                        .map(item2 -> ItemHospitEtabByDepByYear.builder()
                                .dep(item2.getKey())
                                .nb(item2.getValue())
                                .annee(requestHospitDepByYear.getAnnee()).build())
                        .collect(Collectors.toList()))
                .doOnSuccess(item -> log.info("Compute succeed"))
                .doOnError(item -> log.info("Compute failed !!!"));
    }

    @TrackTime
    public Mono<List<ItemHospitEtabByDepByYearByMonth>> listHospitByYearByMonth(RequestHospitByYearWithMonth requestHospitByYearWithMonth) {
        return Mono.justOrEmpty(covidHospitEtabRepository.findAllHospitByDepByYearByMonth(requestHospitByYearWithMonth.getAnnee(), requestHospitByYearWithMonth.getMonth()))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> log.info("begin compute hospit etab by year !!!"))
                .map(item -> fromCovidHopsitEtabToDto(item))
                .map(item -> item.stream().collect(Collectors.groupingBy(CovidHospitEtabDto::getDep, Collectors.summingInt(CovidHospitEtabDto::getNb))))
                .map(item -> item.entrySet().stream()
                        .map(item2 -> ItemHospitEtabByDepByYearByMonth.builder()
                                .dep(item2.getKey())
                                .month(requestHospitByYearWithMonth.getMonth())
                                .nb(item2.getValue())
                                .annee(requestHospitByYearWithMonth.getAnnee()).build())
                        .collect(Collectors.toList()))
                .doOnSuccess(item -> log.info("Compute succeed"))
                .doOnError(item -> log.info("Compute failed !!!"));
    }

    private List<CovidHospitEtabDto> fromCovidHopsitEtabToDto(List<CovidHospitEtab> covidHospitEtabs) {
        return covidHospitEtabs.stream()
                .map(item -> CovidHospitEtabDto.builder()
                        .dep(item.getDep())
                        .nb(item.getNb())
                        .jour(item.getJour()).build())
                .collect(Collectors.toList());
    }
}
