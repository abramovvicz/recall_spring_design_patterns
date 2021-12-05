package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.Function;

public class ChapterOneFunctionDemo {

    protected static class MyMath {
        public static Integer triple(Integer x){
            return x * 3;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> function = MyMath::triple;
        Integer result = function.apply(5);
        System.out.println(result);

        Function<String, Integer> getLength = myString -> myString.length();
        System.out.println(getLength);
    }
}
