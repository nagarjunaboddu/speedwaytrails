package com.galvanize.speedwaytrails.services;

import com.galvanize.speedwaytrails.models.Driver;
import com.galvanize.speedwaytrails.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}
