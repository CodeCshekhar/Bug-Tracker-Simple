package com.example.bugTracker.service;


import com.example.bugTracker.model.Priority;
import com.example.bugTracker.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    // Create a new priority
    public Priority createPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    // Get all priorities
    public List<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }

    // Get a priority by ID
    public Priority getPriorityById(Long id) {
        Optional<Priority> priority = priorityRepository.findById(id);
        return priority.orElse(null);
    }

    // Update a priority
    public Priority updatePriority(Long id, Priority priority) {
        if (priorityRepository.existsById(id)) {
            priority.setId(id);
            return priorityRepository.save(priority);
        }
        return null;
    }

    // Delete a priority
    public void deletePriority(Long id) {
        priorityRepository.deleteById(id);
    }
}
