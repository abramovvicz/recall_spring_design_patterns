package com.abramovvicz.springSandbox.designPatternsInSpring.decorator;

import org.junit.jupiter.api.Test;

public class DecoratorTest {


    @Test
    public void TestDecorator(){

        Pizza pizza = new ThickCrustPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());


        Pizza pepperoni = new Pepperoni(pizza);
        System.out.println(pepperoni.getDescription());
        System.out.println(pepperoni.getCost());

        Pizza doublePepperoni = new Pepperoni(pepperoni);
        System.out.println(doublePepperoni.getDescription());
        System.out.println(doublePepperoni.getCost());


    }
}
