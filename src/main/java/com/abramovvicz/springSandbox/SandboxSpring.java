package com.abramovvicz.springSandbox;

import com.abramovvicz.springSandbox.Exec1.CDPlayer;
import com.abramovvicz.springSandbox.Exec1.Mp3Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan
public class SandboxSpring {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SandboxSpring.class, args);
        CDPlayer bean = run.getBean(CDPlayer.class);
        bean.play();
        Mp3Player bean1 = run.getBean(Mp3Player.class);
        bean1.play();
    }
}
