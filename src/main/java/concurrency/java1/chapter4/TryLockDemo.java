package concurrency.java1.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShopperTryLock extends Thread {

    private static int itemsOnNotePad = 0;
    private static Lock pencil = new ReentrantLock();
    private int itemsToAdd = 0;

    public ShopperTryLock(String name) {
        this.setName(name);
    }


    @Override
    public void run() {
        while (itemsOnNotePad <= 20) {
            if (itemsToAdd > 0 && pencil.tryLock()) {
                try {
                    itemsOnNotePad += itemsToAdd;
                    System.out.println(this.getName() + " added " + itemsToAdd + "items to notepad");
                    itemsToAdd = 0;
                    Thread.sleep(300); // time spent writting to notepad
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    pencil.unlock();
                }
            } else { //look for other items to buy when lock is set
                try {
                    Thread.sleep(100); //time spent searching
                    itemsToAdd++; // others items that i searched
                    System.out.println(this.getName() + " found sth to buy");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


public class TryLockDemo {
    public static void main(String[] args) {

        Thread baron = new ShopperTryLock("Baron");
        Thread olivia = new ShopperTryLock("Olivia");
        long start = System.currentTimeMillis();
        baron.start();
        olivia.start();
        try {
            baron.join();
            olivia.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long stop = System.currentTimeMillis();
        System.out.println("Elapsed time " + (float) (stop - start) / 1000 + " seconds");


    }

}
