package com.galvanize.speedwaytrails.services;

import com.galvanize.speedwaytrails.models.Owner;
import com.galvanize.speedwaytrails.models.RaceCar;
import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import com.galvanize.speedwaytrails.repositories.RaceCarRepository;
import com.galvanize.speedwaytrails.exception.RaceCarException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceCarService {

    private final RaceCarRepository raceCarRepository;

    public RaceCarService(RaceCarRepository raceCarRepository) {
        this.raceCarRepository = raceCarRepository;
    }

    public SpeedwayResponse listAllRaceCars() throws RaceCarException {
        List<RaceCar> cars = raceCarRepository.findAll();
        SpeedwayResponse response=null;
        if (cars == null || cars.isEmpty()) {
            throw new RaceCarException("No Cars found in Garage");
        }else{
            response = SpeedwayResponse.builder()
                    .status_text("OK")
                    .status_code(200)
                    .data(cars)
                    .build();
        }
        return response;
    }

    public SpeedwayResponse addNewRaceCar(RaceCar raceCarReq) {
        RaceCar response = raceCarRepository.save(raceCarReq);
        SpeedwayResponse speedwayResponse = new SpeedwayResponse();
        speedwayResponse.setStatus_text("Car Successfully Added");
        speedwayResponse.setStatus_code(201);
        speedwayResponse.setData(response);
        return speedwayResponse;
    }
}
