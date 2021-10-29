package pkConcurrencyLesson1;


import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private final CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("do something with countDownLatch: " + countDownLatch.getCount() );
    }
}
