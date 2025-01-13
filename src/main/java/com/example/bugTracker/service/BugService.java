package com.example.bugTracker.service;

import com.example.bugTracker.model.Bug;
import com.example.bugTracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    public Bug createBug(Bug bug) {
        return bugRepository.save(bug);
    }

    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    public void deleteBug(Long id) {
        bugRepository.deleteById(id);
    }
}
