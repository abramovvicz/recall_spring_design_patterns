package szymonLessons.criminalStoriesDoubleCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Case_DoubleCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatchPolice = new CountDownLatch(1);
        CountDownLatch countDownLatchCriminal = new CountDownLatch(1);
        new Thread(new Police("Police", countDownLatchPolice, countDownLatchCriminal)).start();
        new Thread(new Criminal("Criminal", countDownLatchPolice, countDownLatchCriminal)).start();

    }
}
