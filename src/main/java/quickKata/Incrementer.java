package quickKata;

import java.util.stream.IntStream;

public class Incrementer {


    public static void main(String[] args) {
        incrementer(new int[]{3, 6, 9, 8, 9});
    }

    public static int[] incrementer(int[] numbers) {
        return IntStream.range(0, numbers.length).map(i -> (numbers[i] + i + 1) % 10).toArray();
    }
}
