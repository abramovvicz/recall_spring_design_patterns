package com.abramovvicz.springSandbox.Exec1;

public class CdMusic implements CompactCD {

    String title = "Some Title";
    String artist = "Some artist";

    @Override
    public void play() {
        System.out.println("Play : " + title + " sing by: " + artist);
    }
}
