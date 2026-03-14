package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.Goal;
import com.adriana.goaltracker.service.GoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goals")
public class GoalController {

    private final GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Goal> all() {
        return service.getAll();
    }

    @GetMapping("/test")
    public String test() {
        return "Goals  works!";
    }
}