package com.abramovvicz.springSandbox.hexagonalArchSandbox.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Cake implements Serializable {

    private final long uuid = 100000L;

    private String name;

}
