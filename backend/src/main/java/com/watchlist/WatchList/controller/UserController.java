package com.watchlist.WatchList.controller;

import com.watchlist.WatchList.model.User;
import com.watchlist.WatchList.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userService.create(user);
    }

    @GetMapping("/{login}")
    public User getUserInfo(@PathVariable String login) {
        return this.userService.findByLogin(login);
    }

    @PutMapping
    public User editUserInfo(@RequestBody User user) {
        return this.userService.update(user);
    }

    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable String login) {
        this.userService.deleteByLogin(login);
    }
}
