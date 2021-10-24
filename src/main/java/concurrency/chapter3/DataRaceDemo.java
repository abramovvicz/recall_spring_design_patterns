package concurrency.chapter3;

import java.util.concurrent.atomic.AtomicInteger;

class Shopper extends Thread {

    static AtomicInteger garlicCount = new AtomicInteger(0);
    //static Lock pencil = new ReentrantLock(); //lock jest mocno przestażały, pakiet Atomic zapewnia bezpieczeństwo concurrency
    //keyword synchronized added to method statement ensure that multiple invocation will not interleave

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //pencil.lock();
            garlicCount.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + " garlicCount " + garlicCount);
            //pencil.unlock();
            System.out.println(Thread.currentThread().getName() + " is thinking");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class DataRaceDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread olivia = new ShopperSecond();
        Thread baron = new ShopperSecond();

        baron.start();
        olivia.start();


        baron.join();
        olivia.join();
        System.out.println("We should buy: " + ShopperSecond.garlicCount + " garlic");


    }
}
