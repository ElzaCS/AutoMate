package com.example.automate.repositories;

import com.example.automate.models.PassengerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerHistoryRepository extends JpaRepository<PassengerHistory, Long> {
    List<PassengerHistory> findByPassengerId(Long id);
}