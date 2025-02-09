package com.example.bugTracker.controller;

import com.example.bugTracker.model.Bug;
import com.example.bugTracker.model.User; // Import User model
import com.example.bugTracker.service.UserService; // Import UserService
import com.example.bugTracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

    private final BugService bugService;
    private final UserService userService; // Add UserService

    @Autowired
    public BugController(BugService bugService, UserService userService) { // Inject UserService
        this.bugService = bugService;
        this.userService = userService; // Initialize UserService
    }

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/{id}")
    public Bug getBugById(@PathVariable Long id) {
        return bugService.getBugById(id);
    }

    @PostMapping
public Bug createBug(@RequestBody Bug bug) {
    System.out.println("Creating bug with user name: " + bug.getAssignedUserName()); // Log user name

        User user = userService.findByName(bug.getAssignedUserName()); // Find user by name
        bug.setAssignedUser(user);
        return bugService.createBug(bug);
    }

    @PutMapping("/{id}")
    public Bug updateBug(@PathVariable Long id, @RequestBody Bug bug) {
        return bugService.updateBug(id, bug);
    }

    @DeleteMapping("/{id}")
    public void deleteBug(@PathVariable Long id) {
        bugService.deleteBug(id);
    }

    @PostMapping("/{bugId}/assign/{userId}")
    public Bug assignBugToUser(@PathVariable Long bugId, @PathVariable Long userId) {
        return bugService.assignBugToUser(bugId, userId);
    }
}
