package com.abramovvicz.springSandbox.Exec1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class Mp3Music {
    String title = "Mp3 Title";
    String artist = "Mp3 artist";
    List<String> songs = new ArrayList<>();
}
