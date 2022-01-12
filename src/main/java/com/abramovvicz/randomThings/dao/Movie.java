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


    public Movie(String imbd, String title, List<Actor> actors) {
        this.imbd = imbd;
        this.title = title;
        this.actors = actors;
    }

    private String imbd;
    private String title;
    private List<Actor> actors;

}
