package kithyLesssons.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Kitchen {

    String name;
    List<Dish> dishes;
    Dish dish;

    public Kitchen(String name, Dish dish, List<Dish> dishes) {
        this.name = name;
        this.dish = dish;
        this.dishes = dishes;
    }
}
