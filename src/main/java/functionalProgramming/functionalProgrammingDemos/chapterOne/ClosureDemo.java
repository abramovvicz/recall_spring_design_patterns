package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.Function;

public class ClosureDemo {

    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            String name = "Bartek";
            return () -> "Hello, " + name;
        };

        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());




        Function<Integer, NoArgFunction<String>> returningFunctionMethod = (x) -> {

            String name = "coś tam";

            return ()->  name + " coś tam jezcze " + x;



        };


        NoArgFunction<String> apply = returningFunctionMethod.apply(1);
        System.out.println(apply.apply());
    }



}
