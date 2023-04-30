package com.covid.dev.service;

import com.covid.dev.dto.covidhospitetab.ItemHospitEtab;
import com.covid.dev.dto.covidhospitetab.ItemHospitEtabByDepByYear;
import com.covid.dev.dto.covidhospitetab.ItemHospitEtabByDepByYearByMonth;
import com.covid.dev.repository.CovidHospitEtabRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
@Slf4j
public class CovidHospitByDepService {

    private final CovidHospitEtabRepository covidHospitEtabRepository;

    public CovidHospitByDepService(CovidHospitEtabRepository covidHospitEtabRepository) {
        this.covidHospitEtabRepository = covidHospitEtabRepository;
    }

    public Flux<ItemHospitEtabByDepByYear> listOfItemHospitEtabToItemHospitEtabByDepByYear(Integer annee){
        return Flux.fromIterable(covidHospitEtabRepository.findAllHospitByDepByYear(annee))
                .publishOn(Schedulers.boundedElastic())
                .map(item -> fromItemHospitEtabToItemHospitEtabByDepByYear(item, annee))
                .doOnError(item -> log.info("Error on {}", CovidHospitByDepService.class.getName()))
                .doOnComplete(() -> log.info("Process Succefull !!!"));
    }

    public Flux<ItemHospitEtabByDepByYearByMonth> listItemHospitEtabToItemHospitEtabByDepByYearByMonth(Integer annee, Integer month){
        return Flux.fromIterable(covidHospitEtabRepository.findAllHospitByDepByYearByMonth(annee, month))
                .publishOn(Schedulers.boundedElastic())
                .map(item -> fromItemHospitEtabToItemHospitEtabByDepByYearByMonth(item, annee, month))
                .doOnError(item -> log.info("Error on {}", CovidHospitByDepService.class.getName()))
                .doOnComplete(() -> log.info("Process Success !!!"));
    }

    private ItemHospitEtabByDepByYear fromItemHospitEtabToItemHospitEtabByDepByYear(ItemHospitEtab itemHospitEtab, Integer annee) {
        return ItemHospitEtabByDepByYear.builder()
                .dep(itemHospitEtab.getDep())
                .nb(itemHospitEtab.getNb())
                .annee(annee)
                .build();
    }

    private ItemHospitEtabByDepByYearByMonth fromItemHospitEtabToItemHospitEtabByDepByYearByMonth(ItemHospitEtab itemHospitEtab, Integer annee, Integer month) {
        return ItemHospitEtabByDepByYearByMonth.builder()
                .dep(itemHospitEtab.getDep())
                .nb(itemHospitEtab.getNb())
                .annee(annee)
                .month(month).build();
    }
}
