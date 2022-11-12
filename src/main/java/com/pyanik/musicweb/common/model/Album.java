package com.pyanik.musicweb.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public
class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String artistName;

    private String review;

    private String youtubeSingleId;

    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    private boolean promoted;

    private String cover;
}
