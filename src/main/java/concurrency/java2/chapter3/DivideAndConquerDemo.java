package concurrency.java2.chapter3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DivideAndConquerDemo {


    //wyobraź sobie, listę paragonów jest ich bardzo dużo i masz policzyć sumę zakupów
    //niestety jest tyle tego, że samemu ciężko ci to wszystko zliczyć
    //prosisz kumpla i dzielicie się robotą dajesz mu połowe paragonów
    //teraz kumpel liczy i ty liczysz
    //ale hej kumpel ma tego za dużo i ty też
    //bierzecie kolejnego kumpla i dzielicie sobie robotę `
    //itd aż dotrzecie to base case - czyli najmniejszej podzielnej porcji do wykonania zadania
    //taką base case można definiować sobie nie zawsze musi być najmniejsza
    //a potem robicie sobie sumowanie swoich obliczeń i macie podliczone wydatki :)
    //fork join framework
    //ExecutorService that executes ForkJoinTasks
    //fork() - asynchronusealy execute taks in ForkJoinPool

    //join() - combine results of computation when it is done
    public static void main(String[] args) {

        final int NUM_OF_RUNS = 10;
        final long SUM_VALUE = 100000L;

        long resultWarmUp = sequentialSum(0, SUM_VALUE);//warmUp
        double sequentialTime = 0;
        System.out.println("resultWarmUp " + resultWarmUp);
        for (int i = 0; i < NUM_OF_RUNS; i++) {
            long start = System.currentTimeMillis();
            resultWarmUp = sequentialSum(0, SUM_VALUE);
            sequentialTime += System.currentTimeMillis() - start;
        }

        sequentialTime /= NUM_OF_RUNS;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new RecursiveSum(0, SUM_VALUE)); //warmUp
        pool.shutdown();

        double parallelTime = 0;
        for (int i = 0; i < NUM_OF_RUNS; i++) {
            long start = System.currentTimeMillis();
            ForkJoinPool poolParallel = ForkJoinPool.commonPool();
            pool.invoke(new RecursiveSum(0, SUM_VALUE));
            poolParallel.shutdown();
            parallelTime += System.currentTimeMillis() - start;
        }

        parallelTime /= NUM_OF_RUNS;

        System.out.println("Sequential time " + sequentialTime);
        System.out.println("Parallel time " + parallelTime);
        double speedUp = sequentialTime / parallelTime;
        System.out.println("SPEED UP IS: " + speedUp);
        double efficiency = speedUp / SUM_VALUE;
        System.out.println("Efficiency is: " + 100 * (efficiency / Runtime.getRuntime().availableProcessors()));

        double v = 1 / ((1 - 0.7) + (0.7 / 4));
        System.out.println(v);
    }

    public static long sequentialSum(int lo, long hi) {
        long total = 0;
        for (int i = lo; i < hi; i++) {
            total += i;
        }
        return total;
    }
}

class RecursiveSum extends RecursiveTask<Long> {

    private long lo;
    private long hi;

    public RecursiveSum(long lo, long hi) {
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    protected Long compute() {
        if (hi - lo <= 100_000) {  // base case
            long total = 0;
            for (int i = 0; i < hi; i++) {
                total += i;
            }
            return total;
        } else {
            long mid = (hi - lo) / 2; // middle index for split
            RecursiveSum left = new RecursiveSum(lo, mid);
            RecursiveSum right = new RecursiveSum(mid + 1, hi);
            left.fork(); //forked thread computes left half
            return right.compute() + left.join(); // current thread comptes right half
        }
    }
}
