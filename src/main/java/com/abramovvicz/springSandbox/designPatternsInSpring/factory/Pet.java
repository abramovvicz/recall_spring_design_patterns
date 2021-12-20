package com.abramovvicz.springSandbox.designPatternsInSpring.factory;

public interface Pet {
    void setName(String name);
    String getName();
    String getType();
    boolean isHungry();
    void feed();
}
