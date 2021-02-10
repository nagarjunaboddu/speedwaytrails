package com.galvanize.speedwaytrails.services;

import com.galvanize.speedwaytrails.models.RaceCar;
import com.galvanize.speedwaytrails.repositories.RaceCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceCarService {

    private RaceCarRepository raceCarRepository;

    public RaceCarService(RaceCarRepository raceCarRepository) {
        this.raceCarRepository = raceCarRepository;
    }

    public List<RaceCar> listAllRaceCars(){
        return raceCarRepository.findAll();
    }
}
