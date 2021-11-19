package vavrLibrary;

import io.vavr.control.Option;

public class OptionVavrDemo {

    public static void main(String[] args) {
        Option.of("cool").peek(System.out::println).map(String::toUpperCase).getOrElse("");
    }

}
