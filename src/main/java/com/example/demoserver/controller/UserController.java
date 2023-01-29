package com.example.demoserver.controller;


import com.example.demoserver.model.User;
import com.example.demoserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/users")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return null;
    }

    @GetMapping("{user_id}")
    public User getUser(@PathVariable Integer user_id) {
        return userService.getById(user_id);
    }

    @PostMapping
    public User addUser(
            @RequestBody User user
    ){
        return userService.addUser(user);
    }

    @PutMapping("{user_id}")
    public User editUser(
            @PathVariable Integer user_id,
            @RequestBody User user
    ) {
        return userService.editUser(user);
    }

    @DeleteMapping("{user_id}")
    public String deleteUser(@PathVariable Integer user_id) {
        return userService.deleteUser(user_id);
    }

}
