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
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Long total = pool.invoke(new RecursiveSum(0, 100000));
        pool.shutdown();
        System.out.println("Total sum is: " + total);
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
            long mid = (hi - lo) / 2; // middle infex for split
            RecursiveSum left = new RecursiveSum(lo, mid);
            RecursiveSum right = new RecursiveSum(mid + 1, hi);
            left.fork(); //forked thread computes left half
            return  right.compute()+ left.join(); // current thread comptes right half
        }
    }
}
