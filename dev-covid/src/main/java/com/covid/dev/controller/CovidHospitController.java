package com.covid.dev.controller;

import com.covid.dev.dto.covidhospit.ItemMoyenneMoisDto;
import com.covid.dev.dto.covidhospit.ItemTotalMoisDto;
import com.covid.dev.service.CovidHospitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/covidhospit")
public class CovidHospitController {

    private final CovidHospitService covidHospitService;

    public CovidHospitController(CovidHospitService covidHospitService) {
        this.covidHospitService = covidHospitService;
    }

    @GetMapping("total/unan")
    public Mono<Integer> totalHospitSurUnAn(@RequestParam("annee") Integer annee){
        return covidHospitService.calculHospitGlobalSurUnAnTotal(annee);
    }

    @GetMapping("total/dc/unan")
    public Mono<Integer> totalDcSurUnAn(@RequestParam("annee") Integer annee) {
        return covidHospitService.calculDcGlobalSurUnAnTotal(annee);
    }

    @GetMapping("total/mois")
    public Mono<Integer> totalHospitSuUnMois(@RequestParam("annee") Integer annee,
                                             @RequestParam("mois") Integer mois){
        return covidHospitService.calculHospitGlobalSurUnMoisTotal(annee, mois);
    }

    @GetMapping("total/dc/mois")
    public Mono<Integer> totalDcSurUnMois(@RequestParam("annee") Integer annee,
                                          @RequestParam("mois") Integer mois) {
        return covidHospitService.calculDcGlobalSurUnMoisTotal(annee, mois);
    }

    @GetMapping("moyenne/unan")
    public Mono<Double> moyennSurUnAn(@RequestParam("annee") Integer annee){
        return covidHospitService.moyenneHospitSurUnAn(annee);
    }

    @GetMapping("moyenne/mois")
    public Mono<Double> moyenneSurUnMois(@RequestParam("annee") Integer annee,
                                         @RequestParam("mois") Integer mois) {
        return covidHospitService.moyenneHospitSurUnmois(annee, mois);
    }

    @GetMapping("total/mois/unan")
    public Flux<ItemTotalMoisDto> listTotalMoisSurUnan(@RequestParam("annee") Integer annee){
        return covidHospitService.listTotalHospitMoisSurUnAn(annee);
    }

    @GetMapping("moyenne/mois/unan")
    public Flux<ItemMoyenneMoisDto> listMoyenneSurUnAn(@RequestParam("annee") Integer annee) {
        return covidHospitService.listMoyenneHospitMoisSurUnAn(annee);
    }
}
