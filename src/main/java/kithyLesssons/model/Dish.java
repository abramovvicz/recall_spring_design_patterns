package kithyLesssons.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dish {

    String name;
    boolean vegetarian;
    int calories;
    Type type;


    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
