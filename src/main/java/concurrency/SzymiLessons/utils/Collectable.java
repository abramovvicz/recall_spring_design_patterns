package concurrency.SzymiLessons.utils;

public interface Collectable<I, O> {
    void addCollector(Collector<I, O> collector);
}
