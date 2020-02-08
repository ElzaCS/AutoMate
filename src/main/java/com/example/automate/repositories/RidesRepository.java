package com.example.automate.repositories;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Rides;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RidesRepository extends JpaRepository<Rides, Long> {
}