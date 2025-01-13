package com.example.bugTracker.repository;


import com.example.bugTracker.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<Bug, Long> {
}
