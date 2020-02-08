package com.example.automate.repositories;

import com.example.automate.models.DriverHistory;
import com.example.automate.models.Requests;
import com.example.automate.models.Rides;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Requests, Long> {
    Requests findFirstByOrderByRequestIdDesc();
}