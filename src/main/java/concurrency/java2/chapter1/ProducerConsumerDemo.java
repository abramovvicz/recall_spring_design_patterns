package concurrency.java2.chapter1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class SoupProducer extends Thread {

    private final BlockingQueue servingLine;

    public SoupProducer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                servingLine.add("Bowl of soup: " + i);
                System.out.printf("Soup of bowl served %d and capacity is %d \n", i, servingLine.remainingCapacity());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        servingLine.add("no soup!");
        servingLine.add("no soup!");
    }
}

class SoupConsumer extends Thread {

    private final BlockingQueue servingLine;

    public SoupConsumer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String bowl = (String) servingLine.take();
                if (bowl.equals("no soup!")) {
                    break;
                }
                System.out.printf("Consumer ate n the bowl %s \n", bowl);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ProducerConsumerDemo {
    public static void main(String[] args) {

        BlockingQueue servingLine = new ArrayBlockingQueue(5);
        new SoupConsumer(servingLine).start();
        new SoupConsumer(servingLine).start();
        new SoupProducer(servingLine).start();

    }


}
