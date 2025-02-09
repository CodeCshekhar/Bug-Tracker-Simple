package com.example.bugTracker.service;

import com.example.bugTracker.model.Priority;
import com.example.bugTracker.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    // Get a priority by ID
    public Priority getPriorityById(Long id) {
        Optional<Priority> priority = priorityRepository.findById(id);
        return priority.orElse(null);
    }
}
