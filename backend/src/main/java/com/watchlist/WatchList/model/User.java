package com.watchlist.WatchList.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String login;
    private String password;

    // todo: icon picture;
    // todo: one-to-many User - WatchItem
}

// todo: Suggested features:
//          -- Share user's WatchList with other users. Also mb generate QR / URL;
//          -- Change visual app style.