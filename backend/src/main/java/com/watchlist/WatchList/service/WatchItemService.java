package com.watchlist.WatchList.service;

import com.watchlist.WatchList.model.WatchItem;

import java.util.List;

public interface WatchItemService {
    WatchItem create(WatchItem watchItem);
    void deleteById(Long id);
    WatchItem update(WatchItem watchItem);
    List<WatchItem> findAllByLogin(String login);
}
