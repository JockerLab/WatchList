package com.watchlist.WatchList.dto;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class CreateWatchItemDto {
    @NonNull
    private String name;
    private boolean isViewed;
    private int episode;
    private int season;
    private LocalDate nextEpisodeDate;
    @NonNull
    private String userLogin;
}
