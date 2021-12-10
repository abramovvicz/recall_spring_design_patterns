package functionalProgramming.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Chapter3Video1 {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Function<Integer, Integer> timesTwo = (x) -> x * 2;

        List<Integer> doubled = listOfIntegers
                .stream()
                .map(timesTwo)
                .collect(Collectors.toList());

        System.out.println(doubled);


        String[] wordsArr = {"hello", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Function<Integer, Predicate<String>> checkStringLength = (minLength) -> str -> str.length() > minLength;
        Predicate<String> filterForString = checkStringLength.apply(4);

        System.out.println(words.stream().filter(x -> x.length() > 4).collect(Collectors.toList()));
        System.out.println(words.stream().filter(filterForString).collect(Collectors.toList()));


        BinaryOperator<Integer> getSum = (accumulator, x) -> {
            int sum = accumulator + x;
            System.out.println("acc " + accumulator + " x: " + x + " sum: " + sum);
            return sum;
        };

        System.out.println(listOfIntegers.stream().reduce(0, getSum));

        //groupingBY
        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x.length())));

        //partitioningBY
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 3)));

        //countingCollector can be reduced to count();
        System.out.println(words.stream().collect(Collectors.counting()));
    }


}
