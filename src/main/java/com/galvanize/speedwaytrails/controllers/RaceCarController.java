package com.galvanize.speedwaytrails.controllers;

import com.galvanize.speedwaytrails.models.RaceCar;
import com.galvanize.speedwaytrails.repositories.RaceCarRepository;
import com.galvanize.speedwaytrails.services.RaceCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/racecars")
public class RaceCarController {

    private RaceCarService raceCarService;

    public RaceCarController(RaceCarService raceCarService) {
        this.raceCarService = raceCarService;
    }

    @GetMapping
    public List<RaceCar> getAllRaceCars(){
           return raceCarService.listAllRaceCars();
    }

}
