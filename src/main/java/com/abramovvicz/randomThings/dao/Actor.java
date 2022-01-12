package com.abramovvicz.randomThings.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Actor {


    public Actor(Integer imdbId, Date dateOfBirth, List<String> filmography) {
        this.imdbId = imdbId;
        this.dateOfBirth = dateOfBirth;
        this.filmography = filmography;
    }

    private Integer imdbId;
    private Date dateOfBirth;
    private List<String> filmography;

}
