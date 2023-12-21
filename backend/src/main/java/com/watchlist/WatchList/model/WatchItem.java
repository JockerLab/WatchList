package com.watchlist.WatchList.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private int episode; // todo: default 1
    private int season; // todo: default 1
    private LocalDate nextEpisodeDate;
    @ManyToOne
    @JsonIgnore
    private User user;
}
// todo: Now only series. Add type (ex. movie, series, ...);
