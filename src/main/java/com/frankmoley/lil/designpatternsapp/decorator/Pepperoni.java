package com.frankmoley.lil.designpatternsapp.decorator;

import java.math.BigDecimal;

public class Pepperoni extends PizzaIngredient{
    private  Pizza pizza;
    public Pepperoni(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(1.50).add(this.pizza.getCost());
    }

    @Override
    public String getDescription() {
        return this.pizza.getDescription() + " + pepperoni";
    }
}
