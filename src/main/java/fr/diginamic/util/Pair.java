package fr.diginamic.util;

/**
 * Pair is a data structure can can store two values.
 *
 * @param <T> the first value
 * @param <U> the second value
 */
public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns the first value.
     */
    public T getFirst() {
        return this.first;
    }

    /**
     * Returns the second value.
     */
    public U getSecond() {
        return this.second;
    }
}
