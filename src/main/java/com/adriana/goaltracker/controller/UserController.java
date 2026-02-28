package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.User;
import com.adriana.goaltracker.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
