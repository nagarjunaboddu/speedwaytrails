package com.galvanize.speedwaytrails.controllers;

import com.galvanize.speedwaytrails.models.Owner;
import com.galvanize.speedwaytrails.models.RaceCar;
import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import com.galvanize.speedwaytrails.services.RaceCarService;
import com.galvanize.speedwaytrails.exception.RaceCarException;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public SpeedwayResponse addNewPlaylist(@RequestBody RaceCar raceCarReq) {
        return raceCarService.addNewRaceCar(raceCarReq);
    }

}
