package com.abramovvicz.springSandbox.Exec1;

public class Mp3Player implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Play song from mp3 player");
    }
}
