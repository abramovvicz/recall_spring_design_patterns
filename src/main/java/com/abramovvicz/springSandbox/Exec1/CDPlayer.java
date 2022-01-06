package com.abramovvicz.springSandbox.Exec1;

public class CDPlayer implements MediaPlayer {

    private CompactCD cd;

    CDPlayer(CompactCD cd){
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
