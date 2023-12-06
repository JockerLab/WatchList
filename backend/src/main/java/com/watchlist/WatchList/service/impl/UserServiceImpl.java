package com.watchlist.WatchList.service.impl;

import com.watchlist.WatchList.model.User;
import com.watchlist.WatchList.repository.UserRepository;
import com.watchlist.WatchList.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository users;

    @Override
    public User findByLogin(String login) {
        return this.users.findByLogin(login);
    }

    @Override
    public User update(User user) {
        User currentUser = this.users.findByLogin(user.getLogin());
        // todo: refactor?
        if (user.getFirstName() != null && !user.getFirstName().isBlank()) {
            currentUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null && !user.getLastName().isBlank()) {
            currentUser.setLastName(user.getLastName());
        }
        return this.users.save(currentUser);
    }

    @Override
    @Transactional
    public void deleteByLogin(String login) {
        this.users.deleteByLogin(login);
    }

    @Override
    public User create(User user) {
        return this.users.save(user);
    }
}
