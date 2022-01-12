package com.abramovvicz.springSandbox.Exec1;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class CDPlayer implements MediaPlayer {

    private final CdMusic cd;

    @Override
    public void play() {
        System.out.println("Play music from CD: " +  cd.getArtist() + "  " + cd.getTitle());
    }


    @PostConstruct
    public void init(){
        System.out.println("Initialized CDPlayer");
    }
}
