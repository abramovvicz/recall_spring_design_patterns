package com.abramovvicz.springSandbox.designPatternsInSpring.singleton;

public class SingA {

    private static SingA instance;

    private SingA() {
        super();
    }


    public static SingA getInstance() {
        if (instance == null) {
            synchronized (SingA.class) {
                if (instance == null) {
                    instance = new SingA();
                }
            }
        }
        return instance;
    }

}
