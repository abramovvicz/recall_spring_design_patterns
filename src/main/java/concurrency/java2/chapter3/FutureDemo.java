package concurrency.java2.chapter3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) {
        System.out.println("Baron ask Olivia how may v is in pantry");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(new HowManyVegetables());
        System.out.println("Baron can do other things waiting for the result...");
        try {
            System.out.println("Olivia respond with:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    //placeholder for result that will be available later

    //mechanism to access the result of an asynchronous operation
}


class HowManyVegetables implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Olivia is counting vegetables");
        Thread.sleep(3000);
        return 33;
    }
}


