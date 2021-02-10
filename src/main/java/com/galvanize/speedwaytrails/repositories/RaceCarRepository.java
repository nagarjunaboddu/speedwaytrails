package com.galvanize.speedwaytrails.repositories;

import com.galvanize.speedwaytrails.models.RaceCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceCarRepository extends JpaRepository<RaceCar,Long> {
}
