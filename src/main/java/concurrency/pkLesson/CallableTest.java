package pkConcurrencyLesson1;

import java.util.concurrent.CompletableFuture;

public class CallableTest {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    System.out.println("task is run on " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 44;
                }).thenCompose(result -> CompletableFuture.supplyAsync(() -> result + 50))
                .thenAccept(result -> System.out.println(result + "  " + Thread.currentThread().getName()));

        System.out.println("Hello");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //sync T getData() Iterable<T> getData();
        //async Future<T> getData() Observable<T> getData();
    }
}
