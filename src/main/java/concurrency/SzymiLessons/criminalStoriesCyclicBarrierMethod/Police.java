package szymonLessons.criminalStoriesCyclicBarrierMethod;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Police implements Runnable {

    private String name;
    CyclicBarrier cyclicBarrier;

    public Police(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Police is waiting for hostage");
            cyclicBarrier.await();
            sentMoney();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    private void sentMoney() {
        System.out.println("Police sent money");
    }
}
