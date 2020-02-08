package com.example.automate.repositories;

import com.example.automate.models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
}