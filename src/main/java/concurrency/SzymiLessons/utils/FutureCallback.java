package concurrency.SzymiLessons.utils;

public interface FutureCallback<V> {
    void onSuccess(V result);

    void onFailure(Throwable failure);
}