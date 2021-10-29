package szymonLessons.criminalStoriesCyclicBarrierMethod;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Criminal implements Runnable {

    String name;
    CyclicBarrier cyclicBarrier;

    public Criminal(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Criminal is waiting for money");
            cyclicBarrier.await();
            releaseHostage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private void releaseHostage() {
        System.out.println("Criminal released hostage");
    }
}
