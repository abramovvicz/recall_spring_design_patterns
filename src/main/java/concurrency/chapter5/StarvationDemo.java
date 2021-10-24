package concurrency.chapter5;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PhilosophersStarvation extends Thread {
    private static int sushiCount = 500;
    private Lock firstChopstick;
    private Lock secondChopstick;

    public PhilosophersStarvation(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        int sushiEaten = 0;
        while (sushiCount > 0) { //mamy sushi na talerzu
            //pick up chopstick
            firstChopstick.lock();
            secondChopstick.lock();

            try {
                if (sushiCount > 0) {
                    sushiCount--;
                    sushiEaten++;
                    System.out.println(this.getName() + " took a piece ! Sushi remaining " + sushiCount);
                }

//                if (sushiCount == 0) {
//                    System.out.println(1 / 0);
//                }
            } finally {
                //put down the chopstick
                firstChopstick.unlock();
                secondChopstick.unlock();
            }
        }
        System.out.println(this.getName() + " took " + sushiEaten + " pieces");
    }
}

public class StarvationDemo {
    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();


        for (int i = 0; i < 400; i++) {
            PhilosophersStarvation baron = new PhilosophersStarvation("Baron", chopstickA, chopstickB);
            baron.start();
            PhilosophersStarvation olivia = new PhilosophersStarvation("Olivia", chopstickB, chopstickC);
            olivia.start();
            PhilosophersStarvation steve = new PhilosophersStarvation("Steve", chopstickA, chopstickC);
            steve.start();
        }
        //prioritiez chopstickA, then B and last C
    }
}
