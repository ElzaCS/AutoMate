package com.example.automate.repositories;

import com.example.automate.models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
    List<Friends> findAllByUserId(Long id);
}