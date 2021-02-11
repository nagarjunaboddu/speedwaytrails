package com.galvanize.speedwaytrails.controllers;

import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import com.galvanize.speedwaytrails.services.RaceCarService;
import com.galvanize.speedwaytrails.exception.RaceCarException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/racecars")
public class RaceCarController {

    private RaceCarService raceCarService;

    public RaceCarController(RaceCarService raceCarService) {
        this.raceCarService = raceCarService;
    }

    @GetMapping
    @ResponseBody
    public SpeedwayResponse getAllRaceCars() throws RaceCarException {
           return raceCarService.listAllRaceCars();
    }

}
