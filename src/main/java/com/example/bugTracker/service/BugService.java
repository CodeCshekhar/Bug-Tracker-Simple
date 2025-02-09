package com.example.bugTracker.service;

import com.example.bugTracker.model.Bug;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.bugTracker.model.User;
import com.example.bugTracker.model.Priority; // Import Priority model

import com.example.bugTracker.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService {

    private final BugRepository bugRepository;
    private static final Logger logger = LoggerFactory.getLogger(BugService.class);

    private final UserService userService;  // to lookup a user for assignment
    private final PriorityService priorityService;  // to lookup a priority

    @Autowired
    public BugService(BugRepository bugRepository, UserService userService, PriorityService priorityService) {
        this.bugRepository = bugRepository;
        this.userService = userService;
        this.priorityService = priorityService; // Initialize priorityService
    }

    // Create a new bug
    public Bug createBug(Bug bug) {
        User user = userService.findByName(bug.getAssignedUserName()); // Find user by name
        logger.info("Creating bug with assigned user: {}", bug.getAssignedUserName());

        if (user != null) {
            bug.setAssignedUserName(user.getName()); // Set the assigned user's name
        } else {
            bug.setAssignedUserName("None"); // Set to "None" if user not found
        }

        return bugRepository.save(bug);
    }

    // Get all bugs
    public List<Bug> getAllBugs() {
        List<Bug> bugs = bugRepository.findAll();
        for (Bug bug : bugs) {
            User assignedUser = bug.getAssignedUser();
            Priority priority = bug.getPriority(); // Get the priority for the bug

            bug.setAssignedUserName(assignedUser != null ? assignedUser.getName() : "None"); // Set assignedUserName
            bug.setPriority(priority); // Set the priority for the bug
        }
        return bugs;
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
        Priority priority = priorityService.getPriorityById(bug.getPriority().getId()); // Logic to get priority based on user input

        bug.setPriority(priority); // Set the priority for the bug

        logger.info("Assigning bug ID {} to user ID {}", bugId, userId);

        if (user == null) {
            return null;
        }
        bug.setAssignedUser(user);
        return bugRepository.save(bug);
    }
}
