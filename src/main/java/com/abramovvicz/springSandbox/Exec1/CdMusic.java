package com.abramovvicz.springSandbox.Exec1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class CdMusic {
    String title = "Some Title";
    String artist = "Some artist";
    List<String> songs = new ArrayList<>();
}
