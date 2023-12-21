package com.watchlist.WatchList.service;

import com.watchlist.WatchList.dto.CreateWatchItemDto;
import com.watchlist.WatchList.model.WatchItem;

import java.util.List;

public interface WatchItemService {
    WatchItem create(CreateWatchItemDto createWatchItem);
    void deleteById(Long id);
    WatchItem update(WatchItem watchItem);
    List<WatchItem> findAllByLogin(String login);
}
