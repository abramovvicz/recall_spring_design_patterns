package kithyLesssons.simpleoperations;

import kithyLesssons.model.Dish;

import java.util.List;

public sealed interface DishRepository permits DishDAO{ //TODO: poczytać o sealed and permits

    List<Dish> getAllDishes();
}
