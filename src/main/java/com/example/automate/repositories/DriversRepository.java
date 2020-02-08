package com.example.automate.repositories;

import com.example.automate.models.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepository extends JpaRepository<Drivers, Long> {
    Drivers findByDriverId(Long id);
    Drivers findByDrivername(String name);
}