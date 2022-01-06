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
    private CompactCD compactCD;

    @Autowired
    private CDPlayer player;

    @Test
    void shouldNotBeNull(){
        Assertions.assertNotNull(compactCD);
    }

    @Test
    public void play() {
        player.play();
    }

}

