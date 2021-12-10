package kithyLesssons.simpleoperations;


import kithyLesssons.model.Dish;
import kithyLesssons.model.Type;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public List<String> getNamesOfLowCaloriesDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(calories -> calories.calories() < 400)
                .sorted(Comparator.comparing(Dish::calories))
                .map(Dish::name)
                .collect(Collectors.toList());
    }

    public Map<Type, List<Dish>> getDishesByType() {
        return repository.getAllDishes().stream().collect(Collectors.groupingBy(Dish::type));
    }

    // Operacje filter i map zostaną scalone do postaci tego samego przejścia - jest to "loop fusion" - fuzja pętli
    public List<String> getNameOfThreeHighCaloricDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(calories -> calories.calories() > 400)
                .map(Dish::name)
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<String> getNamesOfThreeTheMostCaloricDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(calories -> calories.calories() > 500)
                .map(Dish::name)
                .limit(3)
                .collect(Collectors.toList());
    }

    public long getNumberOfHighCaloricDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(calories -> calories.calories() > 500)
                .count();
    }

    public List<Dish> getVegetarianDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(Dish::vegetarian)
                .collect(Collectors.toList());
    }

    // jeśli kolekcja wejściowa jest posortowana w wiadomy nam sposób możemy zastosować operację takeWhile - metoda ta zatrzymuje się po znalezieniu elementu, który nie pasuje do podanego predykatu
    public List<Dish> getLowCaloricDishes() {
        return repository.getAllDishes()
                .stream()
                .sorted(Comparator.comparing(Dish::calories))
                .takeWhile(calories -> calories.calories() < 320)
                .collect(Collectors.toList());
    }

    public List<Dish> getHighCaloricDishes() {
        return repository.getAllDishes()
                .stream()
                .sorted(Comparator.comparing(Dish::calories))
                .dropWhile(calories -> calories.calories() < 320)
                .collect(Collectors.toList());
    }

    public List<Dish> skipMeat() {
        return repository.getAllDishes()
                .stream()
                .dropWhile(dishType -> dishType.type() == Type.MEAT)
                .collect(Collectors.toList());
    }

    public String getTheLongestNameOfDish() {
        return repository.getAllDishes()
                .stream()
                .sorted(Comparator.comparing(Dish::name))
                .map(Dish::name)
                .sorted((name1, name2) -> name2.length() - name1.length())
                .limit(1)
                .collect(Collectors.joining());
    }

    public int getTheLengthOfTheLongestNameOfDish() {
        //longer
        int length = repository.getAllDishes()
                .stream()
                .sorted(Comparator.comparing(Dish::name))
                .map(Dish::name)
                .sorted((name1, name2) -> name2.length() - name1.length())
                .limit(1)
                .collect(Collectors.joining()).length();

        //shorter
        int i = repository.getAllDishes()
                .stream()
                .mapToInt(name -> name.name().length())
                .max().orElse(0);

        return i;
    }

    public List<String> getDistinctAllLettersInDishesNames() {
        return repository.getAllDishes().stream().map(Dish::name).map(word -> word.split(""))
                .flatMap(Arrays::stream).filter(s -> !s.isBlank()).distinct().collect(Collectors.toList());
    }

    public List<Integer[]> mapTwoArraysListTwoOne() {
        List<Integer> listOne = Arrays.asList(1, 2, 3);
        List<Integer> listTwo = Arrays.asList(3, 4);

        List<Integer[]> collect = listOne.stream().flatMap(n -> listTwo.stream().map(j -> new Integer[]{n, j}))
                .collect(Collectors.toList());
        return collect;
    }

    public List<int[]> mapTwoArraysListTwoOneDivisibleBy3() {
        List<Integer> listOne = Arrays.asList(1, 2, 3);
        List<Integer> listTwo = Arrays.asList(3, 4);


        List<int[]> collect = listOne.stream().flatMap(n -> listTwo.stream()
                        .filter((k) -> (k + n) % 3 == 0)
                        .map(j -> new int[]{n, j}))
                .collect(Collectors.toList());
        return collect;
    }


    public void checkIfVegetarianMenuIsAvailable() {
        if (repository.getAllDishes().stream().anyMatch(Dish::vegetarian)) {
            System.out.println("There are meals which are vegetarian");
        }
    }

    //functions terminal: anyMatch, allMatch, findFirst, findAny

    //ex:
    public Optional<Integer> checkFindFirstAndFindAny() {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream().map(n->n*n).filter(number -> number % 3 == 0).findFirst();
        System.out.println(first);
        Optional<Integer> any = someNumbers.stream().map(n->n*n).filter(number -> number % 3 == 0).findAny();
        System.out.println(any);
        return any;
    }


}
