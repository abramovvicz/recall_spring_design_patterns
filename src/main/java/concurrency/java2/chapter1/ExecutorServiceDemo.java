package concurrency.java2.chapter1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class VegetableChopper extends Thread {


    public VegetableChopper(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " chopped a vegetable");
    }

}


public class ExecutorServiceDemo {

    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {
        int numProcs = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numProcs);
        for (int i = 0; i < 100; i++) {
            pool.submit(new VegetableChopper("Some Name " + i));
        }
        pool.shutdown();
    }


    //newSingleThreadExecutor
    //creates an executor that uses a single thread to execute tasks

    //newFixedThreadPoll(int threads)
    //creates a threadPoll that reuses a fixed number of threads to execute tasks

}
