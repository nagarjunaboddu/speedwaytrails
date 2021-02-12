package com.galvanize.speedwaytrails.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpeedwayResponse {

    private String status_text;
    private int status_code;
    private Object data;

}
