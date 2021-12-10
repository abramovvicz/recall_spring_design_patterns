package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class ReturningFunctions {

    public static void main(String[] args) {

        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello functional";
        NoArgFunction<String> greeter = createGreeter.apply();
        String result = greeter.apply();
        System.out.println(result);

        Function<Integer, Integer> timesTwo = MyMath.createMultiplayer(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplayer(3);
        Function<Integer, Integer> timesFour = MyMath.createMultiplayer(4);
        System.out.println(timesTwo.apply(6));
        System.out.println(timesThree.apply(6));
        System.out.println(timesFour.apply(6));

        Function<String, String> someWord = MyMath.returningFunctionMethod("someWord");
        System.out.println(someWord.apply("SOME WORD"));

    }

    public static class MyMath {
        public static Function<Integer, Integer> createMultiplayer(Integer y) {
            return x -> x * y;
        }

        public static Function<String, String> returningFunctionMethod (String word){
            return x->x.toLowerCase() + word;
        }

    }
}
