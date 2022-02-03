package kithyLesssons.simpleoperations;

import kithyLesssons.model.Dish;
import kithyLesssons.model.Kitchen;
import kithyLesssons.model.Type;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class KitcheDAO implements KitchenRepository {

    @Override
    public List<Dish> getAllDishes() {
        return List.of(new Dish("pork", false, 800, Type.MEAT),
                       new Dish("beef", false, 700, Type.MEAT),
                       new Dish("chicken", false, 400, Type.MEAT),
                       new Dish("french fries", true, 530, Type.OTHER),
                       new Dish("rice", true, 350, Type.OTHER),
                       new Dish("season fruit", true, 120, Type.OTHER),
                       new Dish("pizza", true, 550, Type.OTHER),
                       new Dish("prawns", false, 300, Type.FISH),
                       new Dish("salmon", false, 450, Type.FISH));
    }

    @Override
    public List<Kitchen> getAllKitchen() {
        return IntStream
                .range(0, getAllDishes().size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> new Kitchen("kitchen " + i, getAllDishes().get(i), getAllDishes()))
                .collect(Collectors.toList());
    }
}
