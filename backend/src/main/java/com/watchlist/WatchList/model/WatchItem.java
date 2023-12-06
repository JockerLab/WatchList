package com.watchlist.WatchList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "watch_items")
public class WatchItem {
    @Id
    @GeneratedValue
    private Long id;
    private String name; // todo: not null
    private boolean isViewed; // todo: default false
    private int nextEpisode; // todo: default 1
    private int season; // todo: default 1
    private LocalDate nextEpisodeDate;

    // todo: type (ex. movie, anime, series...);
    // todo: many-to-one WatchItem - User
}
