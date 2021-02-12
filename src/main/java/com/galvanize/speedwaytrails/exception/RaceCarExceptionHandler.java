package com.galvanize.speedwaytrails.exception;

import com.galvanize.speedwaytrails.models.SpeedwayResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RaceCarExceptionHandler {

    @ExceptionHandler(RaceCarException.class)
    @ResponseBody
    public SpeedwayResponse handleRaceCarExceptions(RaceCarException ex){
        SpeedwayResponse response=null;
        List<String> errors = new ArrayList<>(1);
        errors.add(ex.getMessage());
            response = SpeedwayResponse.builder()
                    .status_text("Bad request.")
                    .status_code(400)
                    .data(errors)
                    .build();

        return response;
    }
}
