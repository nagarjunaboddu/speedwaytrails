package com.galvanize.speedwaytrails.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RaceCar {
    @Id
    private long id;

    private String nickname;

    private String model;

    private String year;

    private long owner;

    private String status;

    private int topSpeed;

}
