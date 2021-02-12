package com.galvanize.speedwaytrails.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.speedwaytrails.models.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class OwnerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    //Mocking the sequence as we have 2 entries from the data.sql value is 3 by default
    int count = 3;

    @Test
    void postNewDriver_returnsCreated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/owner/add")
                .content(getOwnerRequestAsString("Subhrajit", "Banerjee")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status_text").value("Owner Successfully Added"))
                .andExpect(jsonPath("$.status_code").value(201));
    }

    //Utility Method to get Request Owner as a String
    private String getOwnerRequestAsString(String firstName, String lastName) throws JsonProcessingException {
        Owner request = Owner.builder()
                .id(this.count)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        this.count++;
        return mapper.writeValueAsString(request);
    }
}
