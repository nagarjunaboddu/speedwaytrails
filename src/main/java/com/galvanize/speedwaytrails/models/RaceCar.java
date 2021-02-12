package com.galvanize.speedwaytrails.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "race_car")
public class RaceCar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private String year;

    @Column(name = "status")
    private String status;

    @Column(name = "topSpeed")
    private int topSpeed;

    @ManyToOne(fetch= FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name="owner_id",nullable = true)
    private Owner owner;

}
