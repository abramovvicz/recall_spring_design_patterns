package functionalProgramming.functionalProgrammingDemos.chapterOne;

public class ClosureDemo {

    public static void main(String[] args) {
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            String name = "Bartek";
            return () -> "Hello, " + name;
        };

        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());
    }
}
