package com.example.automate.repositories;

import com.example.automate.models.AutoStatus;
import com.example.automate.models.DriverHistory;
import com.example.automate.models.Requests;
import com.example.automate.models.Rides;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoStatusRepository extends JpaRepository<AutoStatus, Long> {
}