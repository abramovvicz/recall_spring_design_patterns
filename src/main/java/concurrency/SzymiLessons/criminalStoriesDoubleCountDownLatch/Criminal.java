package szymonLessons.criminalStoriesDoubleCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Criminal implements Runnable {

    String name;
    CountDownLatch countDownLatchPolice;
    CountDownLatch countDownLatchCriminal;

    public Criminal(String name, CountDownLatch countDownLatchPolice, CountDownLatch countDownLatchCriminal) {
        this.name = name;
        this.countDownLatchPolice = countDownLatchPolice;
        this.countDownLatchCriminal = countDownLatchCriminal;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is waiting for money");
        try {
            countDownLatchCriminal.countDown();
            countDownLatchPolice.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        releaseHostage();
    }

    private void releaseHostage() {
        System.out.println(this.name + " released hostage");
    }
}
