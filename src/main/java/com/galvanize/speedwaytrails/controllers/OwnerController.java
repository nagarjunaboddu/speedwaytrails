package com.galvanize.speedwaytrails.controllers;

import com.galvanize.speedwaytrails.models.Owner;
import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import com.galvanize.speedwaytrails.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping("/add")
    public SpeedwayResponse addNewPlaylist(@RequestBody Owner ownerReq) {

        return ownerService.addNewOwner(ownerReq);
    }

    @GetMapping("/{id}")
    public Owner addNewPlaylist(@RequestParam Long ownerId)  {

        return ownerService.findOwner(ownerId);
    }
}
