package functionalProgramming.functionalProgrammingDemos.chapterOne;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {


    public static void main(String[] args) {

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> checkSecondArgument = (mainFunc) -> (x, y) -> {
            //check if second argument is equals 0
            if (y == 0f) {
                System.out.println("Error, don`t divide by zero");
                return 0f;
            }
            //executing mainFunction exactly this -> (Function<BiFunction<...>, BiFunction<...>)
            return mainFunc.apply(x, y);
        };

        BiFunction<Float, Float, Float> divideSafe = checkSecondArgument.apply(divide);
        System.out.println(divideSafe.apply(10f, 0f));


        BiFunction<Person, Car, String> concatPersonWithCar = ((person, car) -> person.name + car.name);

        //assumption that car.name cannot be null only for exercise
        Function<BiFunction<Person, Car, String>, BiFunction<Person, Car, String>> concatWhenCarNameIsNotNull = (func) -> (person, car) -> {
            if (car.name == null) {
                System.out.println("Car name cannot be null");
                return new Person("Person without car", 30) + " has no car";
            }
            return func.apply(person, car);
        };

        BiFunction<Person, Car, String> concatSafe = concatWhenCarNameIsNotNull.apply(concatPersonWithCar);
        System.out.println(concatSafe.apply(new Person("Person name", 30), new Car(" Car name")));
        System.out.println(concatSafe.apply(new Person("Person name", 30), new Car(null)));

    }


    public static class Person {
        protected String name;
        protected Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }

    public static class Car {
        protected String name;

        public Car(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" + "name='" + name + '\'' + '}';
        }
    }
}
