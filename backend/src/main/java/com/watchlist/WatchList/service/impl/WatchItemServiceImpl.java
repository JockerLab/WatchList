package com.watchlist.WatchList.service.impl;

import com.watchlist.WatchList.dto.CreateWatchItemDto;
import com.watchlist.WatchList.model.User;
import com.watchlist.WatchList.model.WatchItem;
import com.watchlist.WatchList.repository.UserRepository;
import com.watchlist.WatchList.repository.WatchItemRepository;
import com.watchlist.WatchList.service.WatchItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WatchItemServiceImpl implements WatchItemService {
    private UserRepository users;
    private WatchItemRepository watchItems;
    @Override
    public WatchItem create(CreateWatchItemDto createWatchItem) {
        User user = this.users.findByLogin(createWatchItem.getUserLogin());
        WatchItem watchItem = new WatchItem();
        // todo: refactor?
        watchItem.setSeason(createWatchItem.getSeason());
        watchItem.setViewed(createWatchItem.isViewed());
        watchItem.setNextEpisodeDate(createWatchItem.getNextEpisodeDate());
        watchItem.setEpisode(createWatchItem.getEpisode());
        watchItem.setName(createWatchItem.getName());
        watchItem.setUser(user);
        return this.watchItems.save(watchItem);
    }

    @Override
    public WatchItem update(WatchItem watchItem) {
        WatchItem currentWatchItem = this.watchItems.findById(watchItem.getId())
            .orElse(new WatchItem());

        // todo: refactor?
        // todo: check null
        currentWatchItem.setName(watchItem.getName());
        currentWatchItem.setSeason(watchItem.getSeason());
        currentWatchItem.setViewed(watchItem.isViewed());
        currentWatchItem.setEpisode(watchItem.getEpisode());
        currentWatchItem.setNextEpisodeDate(watchItem.getNextEpisodeDate());

        return this.watchItems.save(currentWatchItem);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.watchItems.deleteById(id);
    }

    @Override
    public List<WatchItem> findAllByLogin(String login) {
        User user = this.users.findByLogin(login);
        return this.watchItems.findAllByUser(user);
    }
}
