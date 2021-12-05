package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static Integer sumUp(Integer one, Integer two) {
        return one + two;
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sumUp = BiFunctionDemo::sumUp;
        Integer result = sumUp.apply(1, 1);
        System.out.println(result);

        TriFunction<Integer, Integer, Integer, Integer> triFunction = (x, y, z) -> x + y + z;
        System.out.println(triFunction.apply(123, 234, 234));

        NoArgFunction<String> saySth = () -> "Say Hello World!";
        System.out.println(saySth.apply());
    }

}
