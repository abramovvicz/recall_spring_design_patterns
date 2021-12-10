package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.BiFunction;

public class PassingFunctionAsArguments {

    public static void main(String[] args) {
        System.out.println(MyMath.combine2And3(MyMath::add));
        System.out.println(MyMath.combine2And3(MyMath::subtract));
        System.out.println(MyMath.combine2And3((x, y) -> x * 3 + y * 4 ));
        MyMath.someMethod((x,y)-> 2+3+"");
    }

    public static class MyMath {

        public static Integer add(Integer x, Integer y) {
            return x + y;
        }

        public static Integer subtract(Integer x, Integer y) {
            return x - y;
        }

        public static Integer combine2And3(BiFunction<Integer, Integer, Integer> biFunction) {
            return biFunction.apply(2, 3);
        }

        public static String someMethod(BiFunction<Integer,Integer, String> someFunction){

            return someFunction.apply(2,3);


        }

    }
}
