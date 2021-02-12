package com.galvanize.speedwaytrails.controllers;

import com.galvanize.speedwaytrails.repositories.RaceCarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RaceControllerErrorTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RaceCarRepository raceCarRepository;

    @Test
    public void listAllRaceCars_error_noCars() throws Exception {
        when(raceCarRepository.findAll()).thenReturn(null);
        mockMvc.perform(get("/api/v1/racecars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status_text").value("Bad request."))
                .andExpect(jsonPath("$.status_code").value(400))
                .andExpect(jsonPath("$.data.[0]").value("No Cars found in Garage"))
        ;

    }

    @Test
    public void listAllRaceCars_error_noCarsEmpty() throws Exception {
        when(raceCarRepository.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/api/v1/racecars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status_text").value("Bad request."))
                .andExpect(jsonPath("$.status_code").value(400))
                .andExpect(jsonPath("$.data.[0]").value("No Cars found in Garage"))
        ;

    }


}
