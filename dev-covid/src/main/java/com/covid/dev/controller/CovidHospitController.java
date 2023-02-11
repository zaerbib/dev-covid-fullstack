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
        return covidHospitService.calculGlobalSurUnAnTotal(annee);
    }

    @GetMapping("total/mois")
    public Mono<Integer> totalHospitSuUnMois(@RequestParam("annee") Integer annee,
                                             @RequestParam("mois") Integer mois){
        return covidHospitService.calculGlobalSurUnMoisTotal(annee, mois);
    }

    @GetMapping("moyenne/unan")
    public Mono<Double> moyennSurUnAn(@RequestParam("annee") Integer annee){
        return covidHospitService.moyenneSurUnAn(annee);
    }

    @GetMapping("moyenne/mois")
    public Mono<Double> moyenneSurUnMois(@RequestParam("annee") Integer annee,
                                         @RequestParam("mois") Integer mois) {
        return covidHospitService.moyenneSurUnmois(annee, mois);
    }

    @GetMapping("total/mois/unan")
    public Flux<ItemTotalMoisDto> listTotalMoisSurUnan(@RequestParam("annee") Integer annee){
        return covidHospitService.listTotalMoisSurUnAn(annee);
    }

    @GetMapping("moyenne/mois/unan")
    public Flux<ItemMoyenneMoisDto> listMoyenneSurUnAn(@RequestParam("annee") Integer annee) {
        return covidHospitService.listMoyenneMoisSurUnAn(annee);
    }
}
