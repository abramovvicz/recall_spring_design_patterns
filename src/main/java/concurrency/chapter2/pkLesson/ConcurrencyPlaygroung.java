package concurrency.chapter2.pkLesson;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ConcurrencyPlaygroung {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Stream.generate(()-> new Thread(new Worker(countDownLatch))).limit(5).forEach(thread -> thread.start());

        countDownLatch.await(3, TimeUnit.SECONDS);
    }
}
