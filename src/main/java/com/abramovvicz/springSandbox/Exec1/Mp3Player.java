package com.abramovvicz.springSandbox.Exec1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class Mp3Player implements MediaPlayer {

    private final Mp3Music mp3Music;

    @Override
    public void play() {
        System.out.println("Play music from CD: " + mp3Music.getArtist() + "  " + mp3Music.getTitle());
    }

    @PostConstruct
    public void init(){
        System.out.println("Initialized MP3Player");
    }
}
