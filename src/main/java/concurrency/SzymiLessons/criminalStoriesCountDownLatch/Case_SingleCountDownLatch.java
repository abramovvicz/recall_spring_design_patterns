package szymonLessons.criminalStoriesCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Case_SingleCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Police("Police", countDownLatch)).start();
        new Thread(new Criminal("Criminal", countDownLatch)).start();

    }
}
