package szymonLessons.criminalStoriesCyclicBarrierMethod;

import java.util.concurrent.CyclicBarrier;

public class Case_CyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, ()-> System.out.println("0"));
        new Thread(new Police("Police", cyclicBarrier)).start();
        new Thread(new Criminal("Criminal", cyclicBarrier)).start();

    }
}
