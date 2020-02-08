package com.example.automate.repositories;

import com.example.automate.models.PassengerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerHistoryRepository extends JpaRepository<PassengerHistory, Long> {
}