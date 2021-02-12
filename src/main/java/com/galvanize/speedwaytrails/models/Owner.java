package com.galvanize.speedwaytrails.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "wins")
    private int wins;

    @Column(name = "losses")
    private int losses;

    @OneToMany(mappedBy = "owner",fetch=FetchType.EAGER)
    @Singular //to return empty list when null
    private List<RaceCar> cars;

}
