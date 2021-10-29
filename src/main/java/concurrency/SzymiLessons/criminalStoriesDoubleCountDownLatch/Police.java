package szymonLessons.criminalStoriesDoubleCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Police implements Runnable {

    private String name;
    CountDownLatch countDownPolice;
    CountDownLatch countDownCriminal;

    public Police(String name, CountDownLatch countDownPolice, CountDownLatch countDownCriminal) {
        this.name = name;
        this.countDownPolice = countDownPolice;
        this.countDownCriminal = countDownCriminal;
    }

    @Override
    public void run() {
        System.out.println(this.name + " is waiting for hostage");
        try {
            countDownCriminal.await();
            countDownPolice.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sentMoney();
    }


    private void sentMoney() {
        System.out.println(this.name + " sent money");
    }
}
