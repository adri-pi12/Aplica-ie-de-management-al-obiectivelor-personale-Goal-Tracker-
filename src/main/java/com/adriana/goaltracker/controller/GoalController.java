package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.Goal;
import com.adriana.goaltracker.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Goal>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Goals works!");
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Goal> create(@RequestBody Goal goal, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(goal, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}