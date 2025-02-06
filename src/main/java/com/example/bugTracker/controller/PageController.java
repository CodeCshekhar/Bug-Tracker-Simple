package com.example.bugTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Home page that links to the features
    @GetMapping("/")
    public String home() {
        return "index"; // returns index.html
    }

    @GetMapping("/add-bug")
    public String addBugPage() {
        return "add-bug"; // returns add-bug.html
    }

    @GetMapping("/retrieve-bugs")
    public String retrieveBugsPage() {
        return "retrieve-bugs"; // returns retrieve-bugs.html
    }

    @GetMapping("/assign-bug")
    public String assignBugPage() {
        return "assign-bug"; // returns assign-bug.html
    }
}
