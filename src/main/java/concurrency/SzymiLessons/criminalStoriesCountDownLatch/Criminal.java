package szymonLessons.criminalStoriesCountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Criminal implements Runnable {

    String name;
    CountDownLatch countDownLatch;

    public Criminal(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Criminal is waiting for money");
        countDownLatch.countDown();
        releaseHostage();
    }

    private void releaseHostage() {
        System.out.println("Criminal released hostage");
    }
}
