package concurrency.java2.chapter1;

import java.util.concurrent.CountDownLatch;

class VegetableChopper implements Runnable {


    public VegetableChopper(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " chopped a vegetable");
    }


    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class ExecutorServiceDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new VegetableChopper("Some Name " + i).run();
        }
    }


    //newSingleThreadExecutor
    //creates an executor that uses a single thread to execute tasks

    //newFixedThreadPoll(int threads)
    //creates a threadPoll that reuses a fixed number of threads to execute tasks

}
