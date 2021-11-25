package concurrency.SzymiLessons.utils;

public interface Listenable<V> {
    void addCallback(FutureCallback<V> callback);
}
