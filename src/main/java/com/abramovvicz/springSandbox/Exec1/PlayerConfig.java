package com.abramovvicz.springSandbox.Exec1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPLayerConfig {

    @Bean
    CompactCD createCompactCD(){
        return new CdMusic();
    }

    @Bean
    CDPlayer cdPlayer(CompactCD compactCD) {
        return new CDPlayer(compactCD);
    }

    @Bean
    Mp3Player mp3Player(){
        return new Mp3Player();
    }
}
