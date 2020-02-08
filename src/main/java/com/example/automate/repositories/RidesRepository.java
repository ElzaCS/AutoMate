package com.example.automate.repositories;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Rides;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RidesRepository extends JpaRepository<Rides, Long> {
    List<Rides> findAllByDriverId(Long id);
    void deleteAllByDriverId(Long id);
}