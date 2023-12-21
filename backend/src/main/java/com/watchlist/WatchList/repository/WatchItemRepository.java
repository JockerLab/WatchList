package com.watchlist.WatchList.repository;

import com.watchlist.WatchList.model.User;
import com.watchlist.WatchList.model.WatchItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchItemRepository extends JpaRepository<WatchItem, Long> {
    List<WatchItem> findAllByUser(User user);
}
