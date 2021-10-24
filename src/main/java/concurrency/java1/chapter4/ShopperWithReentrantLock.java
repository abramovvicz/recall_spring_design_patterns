package concurrency.java1.chapter4;

import java.util.concurrent.locks.ReentrantLock;

class Shopper extends Thread {

    static int garlicCount = 0;
    static int potatoCount = 0;
    static ReentrantLock pencil = new ReentrantLock();

    private void addGarlic() {
        pencil.lock();
        System.out.println("Hold count from addGarlic" + pencil.getHoldCount()); //ilość locków i unlocków
        garlicCount++;
        pencil.unlock();
    }

    private void addPotato() {
        pencil.lock();
        potatoCount++;
        addGarlic();
        pencil.unlock();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            addGarlic();
            addPotato();
        }
    }
}


public class ShopperWithReentrantLock {

    public static void main(String[] args) throws InterruptedException {

        Thread olivia = new Shopper();
        Thread baron = new Shopper();

        baron.start();
        olivia.start();


        baron.join();
        olivia.join();
        System.out.println("We should buy: " + Shopper.garlicCount + " garlic");
        System.out.println("We should buy: " + Shopper.potatoCount + " potato");


    }
}
