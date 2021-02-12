package com.galvanize.speedwaytrails.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.speedwaytrails.models.Owner;
import com.galvanize.speedwaytrails.models.RaceCar;
import com.galvanize.speedwaytrails.repositories.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RaceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    OwnerRepository ownerRepository;

    @Test
    public void listAllRaceCars() throws Exception {

        mockMvc.perform(get("/api/v1/racecars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status_text").value("OK"))
                .andExpect(jsonPath("$.status_code").value(200))
                .andExpect(jsonPath("$.data.length()").value(3))
                .andExpect(jsonPath("$.data.[0].nickname").value("The Condor"))
                .andExpect(jsonPath("$.data.[1].nickname").value("Blue Fire"))
                .andExpect(jsonPath("$.data.[2].nickname").value("Red Fire"))

        ;

    }

    //Mocking the sequence as we have 2 entries from the data.sql value is 4 by default
    int count = 4;

    @Test
    void postNewCar_returnsCreated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/racecars/add")
                .content(getCarRequestAsString("Elenor", "Chevy Camaro")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status_text").value("Car Successfully Added"))
                .andExpect(jsonPath("$.status_code").value(201))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.nickname").value("Elenor"));
    }

    //Utility Method to get Request Owner as a String
    private String getCarRequestAsString(String nickname, String model) throws JsonProcessingException {
        Owner owner = ownerRepository.findById(1L).get();
        RaceCar request = RaceCar.builder()
                .id(this.count)
                .nickname(nickname)
                .owner(owner)
                .model(model)
                .build();
        this.count++;
        return mapper.writeValueAsString(request);
    }


}
