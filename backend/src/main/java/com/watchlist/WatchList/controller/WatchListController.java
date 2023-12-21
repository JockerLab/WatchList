package com.watchlist.WatchList.controller;

import com.watchlist.WatchList.dto.CreateWatchItemDto;
import com.watchlist.WatchList.model.User;
import com.watchlist.WatchList.model.WatchItem;
import com.watchlist.WatchList.service.WatchItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/watch-list")
@AllArgsConstructor
public class WatchListController {
    private WatchItemService watchItemService;
    @PostMapping
    public WatchItem addWatchItem(@RequestBody CreateWatchItemDto createWatchItem) {
        return this.watchItemService.create(createWatchItem);
    }

    @DeleteMapping("/{id}")
    public void deleteWatchItem(@PathVariable Long id) {
        this.watchItemService.deleteById(id);
    }

    @PutMapping
    public WatchItem editWatchItem(@RequestBody WatchItem watchItem) {
        return this.watchItemService.update(watchItem);
    }

    @GetMapping("/{login}")
    public List<WatchItem> getAllWatchItems(@PathVariable String login) {
        return this.watchItemService.findAllByLogin(login);
    }

}
