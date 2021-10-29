package szymonLessons.criminalStoriesCountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Police implements Runnable {

    private String name;
    CountDownLatch countDownLatch;

    public Police(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
            System.out.println("Police is waiting for hostage");
            countDownLatch.countDown();
            sentMoney();
    }


    private void sentMoney() {
        System.out.println("Police sent money");
    }
}
