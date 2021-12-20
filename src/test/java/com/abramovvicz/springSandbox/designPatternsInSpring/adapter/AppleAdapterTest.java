package com.abramovvicz.springSandbox.designPatternsInSpring.adapter;

import org.junit.jupiter.api.Test;

public class AppleAdapterTest {


    @Test
    public void testAdapter(){
        Orange orange = new MoroOrange();
        Apple apple = new AppleAdapter(orange);
        System.out.println(apple.getVariety());
        apple.eat();
    }
}
