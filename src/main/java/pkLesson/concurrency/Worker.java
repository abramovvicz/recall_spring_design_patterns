package pkLesson.concurrency;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {

    private final CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("do something with countDownLatch: " + countDownLatch.getCount() );
    }
}
