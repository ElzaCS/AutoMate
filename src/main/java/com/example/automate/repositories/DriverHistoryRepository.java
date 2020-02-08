package com.example.automate.repositories;

import com.example.automate.models.DriverHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverHistoryRepository extends JpaRepository<DriverHistory, Long> {
    List<DriverHistory> findAllByDriverId(Long id);
    List<DriverHistory> findAllByPassengerId(Long id);
}