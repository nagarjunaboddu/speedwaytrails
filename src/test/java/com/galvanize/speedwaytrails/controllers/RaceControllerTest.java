package com.galvanize.speedwaytrails.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RaceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void listAllRaceCars() throws Exception {

        mockMvc.perform(get("/api/v1/racecars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.status_code").value(200))
                .andExpect(jsonPath("$.data.length()").value(3))
                .andExpect(jsonPath("$.data.[0].nickname").value("The Condor"))
                .andExpect(jsonPath("$.data.[1].nickname").value("Blue Fire"))
                .andExpect(jsonPath("$.data.[2].nickname").value("Red Fire"))


        ;

    }


}
