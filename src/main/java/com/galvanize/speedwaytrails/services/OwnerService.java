package com.galvanize.speedwaytrails.services;

import com.galvanize.speedwaytrails.models.Owner;
import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import com.galvanize.speedwaytrails.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public SpeedwayResponse addNewOwner(Owner ownerReq) {
        Owner response = ownerRepository.save(ownerReq);
        SpeedwayResponse speedwayResponse = new SpeedwayResponse();
        speedwayResponse.setStatus_text("Owner Successfully Added");
        speedwayResponse.setStatus_code(201);
        speedwayResponse.setData(response);
        return speedwayResponse;
    }

    public Owner findOwner(Long ownerId) {
        return ownerRepository.findById(ownerId).get();
    }
}
