package concurrency.SzymiLessons.criminalStoriesCountDownLatch;


import java.util.concurrent.CountDownLatch;

public class Case_SingleCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new szymonLessons.criminalStoriesCountDownLatch.Police("Police", countDownLatch)).start();
        new Thread(new Criminal("Criminal", countDownLatch)).start();

    }
}
