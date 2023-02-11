package com.covid.dev.service;

import com.covid.dev.annotation.TrackTime;
import com.covid.dev.data.CovidHospit;
import com.covid.dev.dto.covidhospit.ItemHospitDto;
import com.covid.dev.dto.covidhospit.ItemMoyenneMoisDto;
import com.covid.dev.dto.covidhospit.ItemTotalMoisDto;
import com.covid.dev.repository.CovidHospitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.stream.Collectors;

@Service
@Slf4j
public class CovidHospitService {

    private final CovidHospitRepository covidHospitRepository;

    public CovidHospitService(CovidHospitRepository covidHospitRepository) {
        this.covidHospitRepository = covidHospitRepository;
    }

    @TrackTime
    public Mono<Integer> calculGlobalSurUnAnTotal(Integer annee) {
        return Mono.justOrEmpty(covidHospitRepository.totalHospitSurUnAn(annee))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> log.info("Processing ..."))
                .doOnSuccess(item -> log.info("Processing end with : {}", item));
    }

    @TrackTime
    public Mono<Integer> calculGlobalSurUnMoisTotal(Integer annee, Integer mois) {
        return Mono.justOrEmpty(covidHospitRepository.totalHospitSurUnMois(annee, mois))
                .doOnNext(item -> log.info("Processing ..."))
                .doOnSuccess(item -> log.info("Procesing end with : {}", item ));
    }

    @TrackTime
    public Mono<Double> moyenneSurUnAn(Integer annee) {
        return Mono.justOrEmpty(covidHospitRepository.findCovidHospitByAnne(annee))
                .doOnNext(item -> log.info("Processing ... size {}", item.size()))
                .map(item -> item.stream().mapToInt(CovidHospit::getHosp)
                        .mapToDouble(a -> a).average().orElse(0))
                .doOnSuccess(item -> log.info("PRocess end average : {}", item));
    }

    @TrackTime
    public Mono<Double> moyenneSurUnmois(Integer annee, Integer mois){
        return Mono.justOrEmpty(covidHospitRepository.findCovidHospitByAnneAndMois(annee, mois))
                .doOnNext(item -> log.info("Process ... size : {}", item.size()))
                .map(item -> item.stream().map(CovidHospit::getHosp)
                        .mapToInt(a -> a).average().orElse(0))
                .doOnSuccess(item -> log.info("Process end ... "))
                .doOnError(item -> log.info("Process failde !!!"));

    }

    @TrackTime
    public Flux<ItemTotalMoisDto> listTotalMoisSurUnAn(Integer annee){
        return Flux.fromIterable(covidHospitRepository.findCovidHospitByAnne(annee))
                .publishOn(Schedulers.boundedElastic())
                .map(item -> ItemHospitDto.builder()
                        .annee(item.getJour().getYear())
                        .mois(item.getJour().getMonthValue())
                        .nombreHospit(item.getHosp())
                        .dep(item.getDep()).build())
                .collectList()
                .map(item -> item.stream().collect(Collectors.groupingBy(ItemHospitDto::getMois)))
                .map(item -> item.entrySet().stream()
                                 .map(key -> ItemTotalMoisDto.builder()
                                         .annee(annee)
                                         .mois(key.getKey())
                                         .total(key.getValue().stream()
                                                 .map(ItemHospitDto::getNombreHospit)
                                                 .reduce(0, (subtotal, elt) -> subtotal+elt)).build()).collect(Collectors.toList()))
                .flatMapIterable(item -> item)
                .doOnSubscribe(item -> log.info("Precessing ...."))
                .doOnComplete(() -> log.info("Process end !!!"));
    }

    @TrackTime
    public Flux<ItemMoyenneMoisDto> listMoyenneMoisSurUnAn(Integer annee) {
        return Flux.fromIterable(covidHospitRepository.findCovidHospitByAnne(annee))
                .publishOn(Schedulers.boundedElastic())
                .map(item -> ItemHospitDto.builder()
                        .annee(item.getJour().getYear())
                        .mois(item.getJour().getMonthValue())
                        .nombreHospit(item.getHosp())
                        .dep(item.getDep())
                        .build())
                .collectList()
                .map(item -> item.stream().collect(Collectors.groupingBy(ItemHospitDto::getMois)))
                .map(item -> item.entrySet().stream()
                        .map(entry -> ItemMoyenneMoisDto.builder()
                                .annee(annee)
                                .mois(entry.getKey())
                                .moyenne(entry.getValue().stream().map(ItemHospitDto::getNombreHospit)
                                        .mapToInt(a -> a).average().orElse(0))
                                .build()).collect(Collectors.toList()))
                .flatMapIterable(item -> item)
                .doOnSubscribe(item -> log.info("Precessing ...."))
                .doOnComplete(() -> log.info("Process end !!!"));
    }
}
