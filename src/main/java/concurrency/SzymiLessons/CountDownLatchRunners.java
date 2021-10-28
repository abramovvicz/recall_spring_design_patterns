package concurrency.SzymiLessons;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchRunners {

    static class Runners implements Runnable {

        private CountDownLatch countDownLatchFirst;
        private CountDownLatch countDownLatchLast;
        private String name;

        public Runners(CountDownLatch countDownLatchFirst, CountDownLatch countDownLatchLast , String name) {
            this.name = name;
            this.countDownLatchFirst = countDownLatchFirst;
            this.countDownLatchLast = countDownLatchLast;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
                countDownLatch.await();
                System.out.println(this.name + " biegnie");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " dobiegł");

        }
    }

    public static void main(String[] args) throws InterruptedException {

//        CountDownLatch countDownLatch;
//        for (int i = 0; i < 4; i++) {
//            countDownLatch = new CountDownLatch(i);
//            new Thread(new Runners(countDownLatch, "Runner: " + i)).start();
//            System.out.println("Runner " + i + " bienie");
//            countDownLatch.countDown();
//        }

        CountDownLatch countDownLatchRunner1 = new CountDownLatch(1);
        CountDownLatch countDownLatchRunner2 = new CountDownLatch(1);
        CountDownLatch countDownLatchRunner3 = new CountDownLatch(1);
        CountDownLatch countDownLatchRunner4 = new CountDownLatch(1);
//
        new Thread(new Runners(countDownLatchRunner1, "Runner: " + 1)).start();
        new Thread(new Runners(countDownLatchRunner2, "Runner: " + 2)).start();
        new Thread(new Runners(countDownLatchRunner3, "Runner: " + 3)).start();
        new Thread(new Runners(countDownLatchRunner4, "Runner: " + 4)).start();







    }
}
