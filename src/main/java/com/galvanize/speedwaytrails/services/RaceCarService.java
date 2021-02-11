package com.galvanize.speedwaytrails.services;

import com.galvanize.speedwaytrails.models.RaceCar;
import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import com.galvanize.speedwaytrails.repositories.RaceCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceCarService {

    private final RaceCarRepository raceCarRepository;

    public RaceCarService(RaceCarRepository raceCarRepository) {
        this.raceCarRepository = raceCarRepository;
    }

    public SpeedwayResponse listAllRaceCars() {
        List<RaceCar> cars = raceCarRepository.findAll();
        SpeedwayResponse response=null;
        if (cars != null) {
            response = SpeedwayResponse.builder()
                    .status("OK")
                    .status_code(200)
                    .data(cars)
                    .build();
        }
        return response;
    }
}
