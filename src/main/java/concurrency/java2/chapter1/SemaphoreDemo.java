package concurrency.java2.chapter1;


import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

class CellPhone extends Thread {

    private static final Semaphore charger = new Semaphore(4);

    public CellPhone(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            charger.acquire();
            System.out.println("available" + charger.getQueueLength());
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            System.out.println(this.getName() + " is charging ... ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.getName() + " charged");
            charger.release();
        }
    }
}

public class SemaphoreDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            new CellPhone("Phone: " + i).start();
        }
    }
}
