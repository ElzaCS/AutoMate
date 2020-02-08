package com.example.automate.repositories;

import com.example.automate.models.DriverHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverHistoryRepository extends JpaRepository<DriverHistory, Long> {
}