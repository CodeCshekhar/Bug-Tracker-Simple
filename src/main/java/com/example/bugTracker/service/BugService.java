package com.example.bugTracker.service;

import com.example.bugTracker.model.Bug;
import com.example.bugTracker.model.User;
import com.example.bugTracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService {

    private final BugRepository bugRepository;
    private final UserService userService;  // to lookup a user for assignment

    @Autowired
    public BugService(BugRepository bugRepository, UserService userService) {
        this.bugRepository = bugRepository;
        this.userService = userService;
    }

    // Create a new bug
    public Bug createBug(Bug bug) {
        return bugRepository.save(bug);
    }

    // Get all bugs
    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    // Get a bug by ID
    public Bug getBugById(Long id) {
        Optional<Bug> bug = bugRepository.findById(id);
        return bug.orElse(null);
    }

    // Update a bug
    public Bug updateBug(Long id, Bug bug) {
        if (bugRepository.existsById(id)) {
            bug.setId(id);
            return bugRepository.save(bug);
        }
        return null;
    }

    // Delete a bug
    public void deleteBug(Long id) {
        bugRepository.deleteById(id);
    }

    // Assign a bug to a user
    public Bug assignBugToUser(Long bugId, Long userId) {
        Bug bug = getBugById(bugId);
        if (bug == null) {
            return null;
        }
        User user = userService.getUserById(userId);
        if (user == null) {
            return null;
        }
        bug.setAssignedUser(user);
        return bugRepository.save(bug);
    }
}
