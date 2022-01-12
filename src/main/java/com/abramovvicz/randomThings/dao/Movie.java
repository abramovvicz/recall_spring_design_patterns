package com.abramovvicz.randomThings.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Movie {


    public Movie(String imdbId, String title, List<Actor> actors) {
        this.imdbId = imdbId;
        this.title = title;
        this.actors = actors;
    }

    private String imdbId;
    private String title;
    private List<Actor> actors;

}
