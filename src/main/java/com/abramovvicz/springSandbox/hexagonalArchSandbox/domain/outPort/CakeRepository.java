package com.abramovvicz.springSandbox.hexagonalArchSandbox.domain.outPort;

import com.abramovvicz.springSandbox.hexagonalArchSandbox.domain.Cake;

import java.util.List;

public interface CakeRepository {

    void createCake(Cake cake);

    Cake getCake(String cakeName);

    List<Cake> getAllCake();

}
