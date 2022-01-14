package kithyLesssons;

import kithyLesssons.simpleoperations.DishDAO;
import kithyLesssons.simpleoperations.DishRepository;
import kithyLesssons.simpleoperations.DishService;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws ChangeSetPersister.NotFoundException {
        DishRepository repository = new DishDAO();
        DishService service = new DishService(repository);

        service.getDishesByType().forEach((type, dishes) -> System.out.println("dish type: " + type + " dishes: " + dishes));

        System.out.println("Names of low calories: " + service.getNamesOfLowCaloriesDishes());

        System.out.println(service.getNamesOfThreeTheMostCaloricDishes());

        System.out.println(service.getNameOfThreeHighCaloricDishes());

        System.out.println(service.getNumberOfHighCaloricDishes());

        System.out.println(service.getVegetarianDishes());

        System.out.println("Get low calories with takeWhile method: " + service.getLowCaloricDishes());

        System.out.println("Get HIGH calories with dropWhile method: " + service.getHighCaloricDishes());

        System.out.println("List with out meat: " + service.skipMeat());

        System.out.println(service.getTheLongestgetNameOfDish());

        System.out.println(service.getTheLengthOfTheLongestgetNameOfDish());

        System.out.println(service.getDistinctAllLettersInDishesgetNames());

        System.out.println("Combine two lists: " + service.mapTwoArraysListTwoOne());

        System.out.println("FindFirstFindAny: " + service.checkFindFirstAndFindAny());

        service.checkIfVegetarianMenuIsAvailable();

        final List<String> strings = List.of("Null", "abc", "Cba21", "35", "null");

        strings.stream().map(c -> c.charAt(0)).filter(Character::isUpperCase).limit(1).forEach(System.out::println);

        System.out.println(strings.stream().map(String::toLowerCase).collect(Collectors.joining(",")));

        strings.stream().map(c->c.chars().mapToObj(x->(char)x)).flatMap(p->p.filter(Character::isDigit)).forEach(System.out::println);

        strings.stream().flatMap(p-> Arrays.stream(p.split("")).filter(x->Character.isDigit(x.charAt(0)))).forEach(System.out::println);

        System.out.println(strings.stream().flatMap(x->Arrays.stream(x.split(""))).distinct().collect(Collectors.joining(",")));
    }
}
