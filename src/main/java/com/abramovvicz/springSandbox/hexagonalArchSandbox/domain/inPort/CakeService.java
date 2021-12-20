package com.abramovvicz.springSandbox.hexagonalArchSandbox.domain.inPort;

import com.abramovvicz.springSandbox.hexagonalArchSandbox.domain.Cake;

import java.util.List;

public interface CakeService {
    void createCake(Cake cake);

    Cake getCake(String name);

    List<Cake> listOfCakes();
}
