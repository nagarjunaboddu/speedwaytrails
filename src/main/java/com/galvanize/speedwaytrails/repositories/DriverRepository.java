package com.galvanize.speedwaytrails.repositories;


import com.galvanize.speedwaytrails.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
