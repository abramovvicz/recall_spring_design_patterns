package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplicationDemo {

    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial = (x) -> (y, z) -> add.apply(x, y, z);

        BiFunction<Integer, Integer, Integer> apply = addPartial.apply(5);

        System.out.println(apply.apply(5, 6));

        TriFunction<String, String, String, Integer> concat = (s1, s2, s3) -> Integer.valueOf(s1 + s2 + s3);

        Function<String, BiFunction<String, String, Integer>> concatPartial = (x) -> (y, z) -> concat.apply(x, y, z);
        //function ->

        BiFunction<String, String, Integer> apply1 = concatPartial.apply("10000");
        System.out.println(apply1.apply("10", "20"));


        TriFunction<Integer, Integer, Integer, String> fromIntegerToString = (x, y, z) -> x + y + z + "";
        Function<Integer, BiFunction<String, Integer, String>> fromIntegerToStringPartial =
                (f) -> (i1, i2) -> fromIntegerToString.apply(f, Integer.valueOf(i1), i2);


        TriFunction<Integer, Integer, Integer, Integer> anotherSumOfIntegers = (t, u, v) -> t + u + v;
        BiFunction<Integer, Integer, Function<Integer, Integer>> partial =
                (t, u) -> (v) -> anotherSumOfIntegers.apply(t, u, v);
        Function<Integer, Integer> apply2 = partial.apply(2, 4);
        apply2.apply(44);


    }
}
