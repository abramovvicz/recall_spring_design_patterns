package concurrency.SzymiLessons.criminalStoriesDoubleCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Case_DoubleCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatchPolice = new CountDownLatch(1);
        CountDownLatch countDownLatchCriminal = new CountDownLatch(1);
        new Thread(new szymonLessons.criminalStoriesDoubleCountDownLatch.Police("Police", countDownLatchPolice, countDownLatchCriminal)).start();
        new Thread(new szymonLessons.criminalStoriesDoubleCountDownLatch.Criminal("Criminal", countDownLatchPolice, countDownLatchCriminal)).start();

    }
}
