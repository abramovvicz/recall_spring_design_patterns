package concurrency.SzymiLessons.utils;

import concurrency.SzymiLessons.utils.ListenableCollectableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureCallbackCollectDemo {
    public static void main(String[] args) {
        List<String> wyrazy = Arrays.asList("Szymon", "Pjoter", "Adam", "Tomasz", "Karo", "AAAAAaaa", "Angelina");

        ExecutorService service = Executors.newFixedThreadPool(4);
        FutureExecutor executor = new FutureExecutor(service);
        Collector<Long, Long> kolektor = new Collector<Long, Long>(new CountDownLatch(wyrazy.size())) {
            
            @Override
            protected Long apply(Long input, Long output) {
                if (output == null) {
                    output = 0L;
                }
                output += input;
                return output;
            }
        };
        executor.submit(kolektor);
        for (String wyraz : wyrazy) {
            ListenableCollectableFuture<Long, Long> future = executor.submit(new ZliczaczA(wyraz));
            future.addCallback(new WypiszWynik());
            future.addCollector(kolektor);
        }

        service.shutdown();
    }

    public static class ZliczaczA extends CallableTask<String, Long> {

        public ZliczaczA(String input) {
            super(input);
        }

        @Override
        protected Long execute(String input) {
            return input.chars().filter(ch -> ch != 'a').count();
        }

    }

    public static class WypiszWynik implements FutureCallback<Long> {
        @Override
        public void onSuccess(Long result) {
            System.out.println("Result: " + result);
        }

        @Override
        public void onFailure(Throwable failure) {
            failure.printStackTrace();
        }
    }

}