package concurrency.SzymiLessons.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class Collector<I, O> implements Callable<O> {

    private O collectedResult;
    private CountDownLatch latch;
    private ReadWriteLock lock;

    public Collector(CountDownLatch latch) {
        this.latch = latch;
        this.lock = new ReentrantReadWriteLock();
    }

    @Override
    public O call() {
        try {
            System.out.println("[" + Thread.currentThread().getName() + "] AWAITING FOR COLLECT");
            latch.await();
            System.out.println("[" + Thread.currentThread().getName() + "] ALL COLLECTED");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().lock();
        System.out.println("[" + Thread.currentThread().getName() + "] All collected: " + collectedResult);
        lock.readLock().unlock();
        return collectedResult;
    }

    public void collect(I input) {
        System.out.println("[" + Thread.currentThread().getName() + "] collect(" + input + ")");
        latch.countDown();
        lock.writeLock().lock();
        collectedResult = apply(input, collectedResult);
        lock.writeLock().unlock();
    }

    protected abstract O apply(I input, O output);
}
