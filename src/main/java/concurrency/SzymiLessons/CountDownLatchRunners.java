package concurrency.SzymiLessons;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunners {

    static class Runners implements Runnable {

        private CountDownLatch countDownLatchWaiting;
        private CountDownLatch countDownLatchRunning;
        private String name;

        public Runners(CountDownLatch countDownLatchWaiting, CountDownLatch countDownLatchRunning, String name) {
            this.name = name;
            this.countDownLatchWaiting = countDownLatchWaiting;
            this.countDownLatchRunning = countDownLatchRunning;
        }

        @Override
        public void run() {
            try {
                if (countDownLatchWaiting != null) {
                    System.out.println(this.name + " czeka na start");
                    countDownLatchWaiting.await();
                }
                System.out.println(this.name + " biegnie");
                if (countDownLatchRunning != null) {
                    countDownLatchRunning.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " dobiegł");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatchRunner1 = new CountDownLatch(1);
        CountDownLatch countDownLatchRunner2 = new CountDownLatch(1);
        CountDownLatch countDownLatchRunner3 = new CountDownLatch(1);
//
        new Thread(new Runners(null, countDownLatchRunner1, "Runner: " + 1)).start();
        new Thread(new Runners(countDownLatchRunner1, countDownLatchRunner2, "Runner: " + 2)).start();
        new Thread(new Runners(countDownLatchRunner2, countDownLatchRunner3, "Runner: " + 3)).start();
        new Thread(new Runners(countDownLatchRunner3, null, "Runner: " + 4)).start();


    }
}
