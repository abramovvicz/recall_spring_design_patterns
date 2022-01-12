package quickKata;

import java.util.stream.IntStream;

public class DivisorsNumber {
    public static long numberOfDivisors(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).boxed().count();
    }
}
