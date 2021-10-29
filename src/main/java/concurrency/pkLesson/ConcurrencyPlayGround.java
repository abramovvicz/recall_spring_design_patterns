package pkConcurrencyLesson1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ConcurrencyPlayGround {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(50);

        Stream.generate(() -> new Thread(new Task(countDownLatch))).limit(6).forEach(Thread::start);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 50; i++) {
            executorService.submit(new Task(countDownLatch));
        }

        countDownLatch.await(3, TimeUnit.SECONDS);

        executorService.shutdown();
        System.out.println("I reached end " + Thread.currentThread().getName());
    }

}
