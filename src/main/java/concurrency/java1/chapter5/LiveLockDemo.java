package concurrency.java1.chapter5;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PhilosophersLiveLockDemo extends Thread {
    private static int sushiCount = 500_000;
    private Lock firstChopstick;
    private Lock secondChopstick;
    private Random rps = new Random();

    public PhilosophersLiveLockDemo(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while (sushiCount > 0) { //mamy sushi na talerzu
            //pick up chopstick
            firstChopstick.lock();
            if (!secondChopstick.tryLock()) {
                System.out.println(this.getName() + " released their first chopstick");
                firstChopstick.unlock();
                try {
                    Thread.sleep(rps.nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
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
}

public class LiveLockDemo {
    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();

        PhilosophersLiveLockDemo baron = new PhilosophersLiveLockDemo("Baron", chopstickA, chopstickB);
        baron.start();
        PhilosophersLiveLockDemo olivia = new PhilosophersLiveLockDemo("Olivia", chopstickB, chopstickC);
        olivia.start();
        PhilosophersLiveLockDemo steve = new PhilosophersLiveLockDemo("Steve", chopstickA, chopstickC);
        steve.start();

        //prioritiez chopstickA, then B and last C
    }
}
