package kithyLesssons.simpleoperations;

import kithyLesssons.model.Dish;
import kithyLesssons.model.Kitchen;

import java.util.List;

public sealed interface KitchenRepository permits KitcheDAO { //TODO: poczytać o sealed and permits

    List<Dish> getAllDishes();

    List<Kitchen> getAllKitchen();

}
