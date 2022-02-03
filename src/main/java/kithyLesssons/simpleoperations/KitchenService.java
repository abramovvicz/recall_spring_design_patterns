package kithyLesssons.simpleoperations;


import kithyLesssons.model.Dish;
import kithyLesssons.model.Kitchen;
import kithyLesssons.model.Type;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

@Slf4j
public record KitchenService(KitchenRepository repository) {

    public List<String> getNamesOfLowCaloriesDishes() {
        return repository.getAllDishes()
                         .stream()
                         .filter(calories -> calories.getCalories() < 400)
                         .sorted(Comparator.comparing(Dish::getCalories))
                         .map(Dish::getName)
                         .collect(toList());
    }

    public Map<Type, List<Dish>> getDishesByType() {
        return repository.getAllDishes()
                         .stream()
                         .collect(groupingBy(Dish::getType));
    }

    // Operacje filter i map zostaną scalone do postaci tego samego przejścia - jest to "loop fusion" - fuzja pętli
    public List<String> getNameOfThreeHighCaloricDishes() {
        return repository.getAllDishes()
                         .stream()
                         .filter(calories -> calories.getCalories() > 400)
                         .map(Dish::getName)
                         .limit(3)
                         .collect(toList());
    }

    public List<String> getNamesOfThreeTheMostCaloricDishes() {
        return repository.getAllDishes()
                         .stream()
                         .filter(calories -> calories.getCalories() > 500)
                         .map(Dish::getName)
                         .limit(3)
                         .collect(toList());
    }

    public long getNumberOfHighCaloricDishes() {
        return repository.getAllDishes()
                         .stream()
                         .filter(calories -> calories.getCalories() > 500)
                         .count();
    }

    public List<Dish> getVegetarianDishes() {
        return repository.getAllDishes()
                         .stream()
                         .filter(Dish::isVegetarian)
                         .collect(toList());
    }

    // jeśli kolekcja wejściowa jest posortowana w wiadomy nam sposób możemy zastosować operację takeWhile - metoda ta zatrzymuje się po znalezieniu elementu, który nie pasuje do podanego predykatu
    public List<Dish> getLowCaloricDishes() {
        return repository.getAllDishes()
                         .stream()
                         .sorted(Comparator.comparing(Dish::getCalories))
                         .takeWhile(calories -> calories.getCalories() < 320)
                         .collect(toList());
    }

    public List<Dish> getHighCaloricDishes() {
        return repository.getAllDishes()
                         .stream()
                         .sorted(Comparator.comparing(Dish::getCalories))
                         .dropWhile(calories -> calories.getCalories() < 320)
                         .collect(toList());
    }

    public List<Dish> skipMeat() {
        return repository.getAllDishes()
                         .stream()
                         .dropWhile(dishType -> dishType.getType() == Type.MEAT)
                         .collect(toList());
    }

    public String getTheLongestgetNameOfDish() {
        return repository.getAllDishes()
                         .stream()
                         .sorted(Comparator.comparing(Dish::getName))
                         .map(Dish::getName)
                         .sorted((getName1, getName2) -> getName2.length() - getName1.length())
                         .limit(1)
                         .collect(joining());
    }

    public int getTheLengthOfTheLongestgetNameOfDish() {
        //longer
        int length = repository.getAllDishes()
                               .stream()
                               .sorted(Comparator.comparing(Dish::getName))
                               .map(Dish::getName)
                               .sorted((getName1, getName2) -> getName2.length() - getName1.length())
                               .limit(1)
                               .collect(joining())
                               .length();

        //shorter
        int i = repository.getAllDishes()
                          .stream()
                          .mapToInt(getName -> getName.getName()
                                                      .length())
                          .max()
                          .orElse(0);

        return i;
    }

    public List<String> getDistinctAllLettersInDishesgetNames() {
        return repository.getAllDishes()
                         .stream()
                         .map(Dish::getName)
                         .map(word -> word.split(""))
                         .flatMap(Arrays::stream)
                         .filter(s -> !s.isBlank())
                         .distinct()
                         .collect(toList());
    }

    public List<Integer[]> mapTwoArraysListTwoOne() {
        List<Integer> listOne = Arrays.asList(1, 2, 3);
        List<Integer> listTwo = Arrays.asList(3, 4);

        List<Integer[]> collect = listOne.stream()
                                         .flatMap(n -> listTwo.stream()
                                                              .map(j -> new Integer[]{n, j}))
                                         .collect(toList());
        return collect;
    }

    public List<int[]> mapTwoArraysListTwoOneDivisibleBy3() {
        List<Integer> listOne = Arrays.asList(1, 2, 3);
        List<Integer> listTwo = Arrays.asList(3, 4);


        List<int[]> collect = listOne.stream()
                                     .flatMap(n -> listTwo.stream()
                                                          .filter((k) -> (k + n) % 3 == 0)
                                                          .map(j -> new int[]{n, j}))
                                     .collect(toList());
        return collect;
    }


    public void checkIfVegetarianMenuIsAvailable() {
        if (repository.getAllDishes()
                      .stream()
                      .anyMatch(Dish::isVegetarian)) {
            log.info("There are meals which are vegetarian");
        }
    }

    //functions terminal: anyMatch, allMatch, findFirst, findAny

    //ex:
    public Optional<Integer> checkFindFirstAndFindAny() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream()
                                             .map(n -> n * n)
                                             .filter(number -> number % 3 == 0)
                                             .findFirst();
        log.info("findFirst: " + first);
        Optional<Integer> any = someNumbers.stream()
                                           .map(n -> n * n)
                                           .filter(number -> number % 3 == 0)
                                           .findAny();
        log.info("findAny: " + any);
        return any;
    }


    //reduce
    public long differentApproachToCountDishes() {

        return 1l;

    }

    public Map<String, Map<Dish, List<Type>>> returnMapWithMapWithList() {
        Map<String, List<Kitchen>> collect = repository.getAllKitchen()
                                                       .stream()
                                                       .collect(groupingBy(Kitchen::getName));
        repository.getAllKitchen()
                  .stream()
                  .collect(groupingBy(Kitchen::getName, groupingBy(Kitchen::getDish, mapping(kitchen -> kitchen.getDishes()
                          , toList()))));


        Map<Type, Map<Type, List<String>>> collect6 = repository.getAllKitchen()
                                                                .stream()
                                                                .collect(groupingBy(k -> k.getDish()
                                                                                          .getType(), groupingBy(k -> k.getDish()
                                                                                                                       .getType(), mapping(kitchen -> kitchen.getDish()
                                                                                                                                                             .getName(), toList()))));


        Map<String, Long> collect1 = repository.getAllDishes()
                                               .stream()
                                               .collect(groupingBy(Dish::getName, counting()));
        log.info("counting by name: " + collect1);


        Map<Boolean, Long> collect2 = repository.getAllDishes()
                                                .stream()
                                                .collect(groupingBy(Dish::isVegetarian, counting()));

        log.info("counting who many vegefood: " + collect2);


        countingByDishIsVegeOrNot();

        Map<Type, Long> collect4 = repository.getAllDishes()
                                             .stream()
                                             .collect(groupingBy(Dish::getType, counting()));

        log.info("counting by type: " + collect4);


        Map<Dish, Long> collect5 = repository.getAllDishes()
                                             .stream()
                                             .collect(groupingBy(dish -> dish, filtering(type -> type.getType() == Type.FISH, counting())));

        log.info("filter type and count by MEAT TYPE: " + collect5);


        return repository.getAllKitchen()
                         .stream()
                         .collect(groupingBy(Kitchen::getName, groupingBy(Kitchen::getDish, mapping(kitchen -> kitchen.getDish()
                                                                                                                      .getType(), toList()))));
    }

    private Map<Dish, Long> countingByDishIsVegeOrNot() {
        return repository.getAllDishes()
                         .stream()
                         .collect(groupingBy(dish -> dish, filtering(Dish::isVegetarian, counting())));
    }

    public Map<Integer, Long> getIntegerLongMap() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        Map<Integer, Long> result = numbers.stream()
                                           .filter(val -> val > 3)
                                           .collect(groupingBy(i -> i, counting()));
        return result;
    }

    public Map<Integer, Long> numbersExample() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 5);

        return numbers.stream()
                      .collect(groupingBy(i -> i,
                                          filtering(val -> val > 3, counting())));
    }

    public Map<String, List<Dish>> flatMappingKitchenNameToDish() {
        return repository.getAllKitchen()
                         .stream()
                         .collect(groupingBy(Kitchen::getName, flatMapping(k -> k.getDishes()
                                                                                 .stream(), toList())));

    }
}
