package com.galvanize.speedwaytrails.controllers;


import com.galvanize.speedwaytrails.models.Driver;
import com.galvanize.speedwaytrails.services.DriverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

}
