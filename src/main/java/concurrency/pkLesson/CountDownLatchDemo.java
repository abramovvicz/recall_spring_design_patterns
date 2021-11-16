package concurrency.pkLesson;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        Stream.generate(() -> new Thread(new Worker(countDownLatch))).limit(5).forEach(thread -> thread.start());

        countDownLatch.countDown();
        System.out.println(countDownLatch.await(5, TimeUnit.SECONDS));
    }
}
