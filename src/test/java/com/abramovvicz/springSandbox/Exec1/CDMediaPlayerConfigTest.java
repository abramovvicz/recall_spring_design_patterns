package com.abramovvicz.springSandbox.Exec1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CDMediaPlayerConfigTest {

    @Autowired
    private CdMusic cdMusic;

    @Autowired
    private Mp3Music mp3Music;

    @Autowired
    private CDPlayer player;

    @Test
    void shouldCdNotBeNull() {
        Assertions.assertNotNull(cdMusic);
    }

    @Test
    void shouldMp3NotBeNull(){
        Assertions.assertNotNull(mp3Music);
    }

    @Test
    public void play() {
        player.play();
    }

}

