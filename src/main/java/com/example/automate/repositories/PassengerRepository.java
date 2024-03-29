package com.example.automate.repositories;

import com.example.automate.models.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passengers, Long> {
    Passengers findByName(String name);
    Passengers findByPassengerId(Long id);
    Passengers findByRollNo(Long rollNo);
}

