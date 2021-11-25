package concurrency.SzymiLessons.utils;

public class ListenableCollectableFuture<V, O> implements Listenable<V>, Collectable<V, O> {
    private FutureCallback<V> callback;
    private Collector<V, O> collector;
    private V result;
    private Throwable failure;
    private boolean isCompleted;

    public void addCallback(FutureCallback<V> callback) {
        this.callback = callback;
        resolve();
    }

    public void addCollector(Collector<V, O> collector) {
        this.collector = collector;
        collect();
    }

    public void setResult(V result) {
        this.result = result;
        isCompleted = true;
        resolve();
        collect();
    }

    public void setFailure(Throwable failure) {
        this.failure = failure;
        isCompleted = true;
        resolve();
        collect();
    }

    private void resolve() {
        if (callback != null && isCompleted) {
            if (failure == null) {
                callback.onSuccess(result);
            } else {
                callback.onFailure(failure);
            }
        }
    }

    private void collect() {
        if (collector != null && isCompleted) {
            if (failure == null) {
                collector.collect(result);
            } else {
                callback.onFailure(failure);
            }
        }


    }
}