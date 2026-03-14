package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.Habit;
import com.adriana.goaltracker.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService service;

    public HabitController(HabitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Habit> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Habit one(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/user/{userId}")
    public Habit create(@RequestBody Habit habit, @PathVariable Long userId) {
        return service.create(habit, userId);
    }

    @PutMapping("/{id}")
    public Habit update(@PathVariable Long id, @RequestBody Habit habit) {
        return service.update(id, habit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}