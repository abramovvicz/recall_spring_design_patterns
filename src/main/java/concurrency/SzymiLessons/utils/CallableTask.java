package concurrency.SzymiLessons.utils;

import java.util.concurrent.Callable;

/**
 * 
 * @author Szymon-SCAR-III szymon
 *
 * @param <I> input type
 * @param <O> output type
 */
public abstract class CallableTask<I, O> implements Callable<O> {
    private I input;

    public CallableTask(I input) {
        this.input = input;
    }

    @Override
    public O call() throws Exception {
        return execute(input);
    }

    protected abstract O execute(I input);
}