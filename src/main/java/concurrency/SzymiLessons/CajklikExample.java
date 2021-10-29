package szymonLessons;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CajklikExample {

    static class Worker implements Runnable {

        private CyclicBarrier barrier;
        private String name;

        public Worker(CyclicBarrier barrier, String name) {
            super();
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("worker " + name + " wnosi paczke");
                barrier.await();
                System.out.println("Worker " + name + " rozpakowuje paczke");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            //TODO work
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, () -> {
            System.out.println("Wszyscy ochotnicy wniesli swoja paczke");
        });

        Thread t1 = new Thread(new Worker(barrier, "Worker 1"));
        Thread t2 = new Thread(new Worker(barrier, "Worker 2"));
        Thread t3 = new Thread(new Worker(barrier, "Worker 3"));
        Thread t4 = new Thread(new Worker(barrier, "Worker 4"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }
}
