package concurrency.java1.chapter5;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosophers extends Thread {
    private static int sushiCount = 500_000;
    private Lock firstChopstick;
    private Lock secondChopstick;

    public Philosophers(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while (sushiCount > 0) { //mamy sushi na talerzu
            //pick up chopstick
            firstChopstick.lock();
            secondChopstick.lock();

            if (sushiCount > 0) {
                sushiCount--;
                System.out.println(this.getName() + " took a piece ! Sushi remaining " + sushiCount);
            }

            //put down the chopstick
            firstChopstick.unlock();
            secondChopstick.unlock();
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        PhilosophersAbandoned baron = new PhilosophersAbandoned("Baron", chopstickA, chopstickB);
        baron.start();
        PhilosophersAbandoned olivia = new PhilosophersAbandoned("Olivia", chopstickB, chopstickC);
        olivia.start();
        PhilosophersAbandoned steve = new PhilosophersAbandoned("Steve", chopstickA, chopstickC);
        steve.start();

        //prioritiez chopstickA, then B and last C
    }
}
