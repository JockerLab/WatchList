package com.watchlist.WatchList.service;

import com.watchlist.WatchList.model.User;

public interface UserService {
    User findByLogin(String login);
    User update(User user);
    void deleteByLogin(String login);
    User create(User user);
}
