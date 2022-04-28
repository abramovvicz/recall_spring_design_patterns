package concurrency.countDownLatchReminder;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchReminder implements Runnable {

    private CountDownLatch countDownLatch;


    public CountDownLatchReminder(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        countDownLatch.countDown();
        System.out.println(countDownLatch.getCount());
    }


    static class CountDownLatchImpl {


        public static void main(String[] args) {
            CountDownLatch countDownLatch = new CountDownLatch(3);
            for (int i = 0; i < 3; i++) {
                CountDownLatchReminder dupa = new CountDownLatchReminder(countDownLatch);
                new Thread(dupa).start();
            }
        }

    }


}
