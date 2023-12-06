package com.watchlist.WatchList.service.impl;

import com.watchlist.WatchList.model.WatchItem;
import com.watchlist.WatchList.repository.WatchItemRepository;
import com.watchlist.WatchList.service.WatchItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class WatchItemServiceImpl implements WatchItemService {
    private WatchItemRepository watchItems;
    @Override
    public WatchItem create(WatchItem watchItem) {
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
        currentWatchItem.setNextEpisode(watchItem.getNextEpisode());
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
        // todo: login
        return this.watchItems.findAll();
    }
}
