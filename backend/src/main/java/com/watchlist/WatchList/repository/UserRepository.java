package com.watchlist.WatchList.repository;

import com.watchlist.WatchList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    void deleteByLogin(String login);
}
