package it.unibo.inner.impl;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final IteratorWithoutPolicy<T> iterator;
    private final Predicate<T> predicate;
    private class IteratorWithoutPolicy<T> implements Iterator<T> {

        private final ArrayList<T> arrayToIterate;
        private int current;

        public IteratorWithoutPolicy(final T[] array) {
            this.arrayToIterate = new ArrayList<T>(Arrays.asList(array));
            this.current = 0;
        }

        @Override
        public T next() {
            return this.arrayToIterate.get(this.current++);
        }

        @Override
        public boolean hasNext() {
            return this.current < this.arrayToIterate.size();
        }
    };

    public IterableWithPolicyImpl(final T[] array) {
        this(array, null);
    }

    public IterableWithPolicyImpl(final T[] array, final Predicate<T> predicate) {
        this.iterator = new IteratorWithoutPolicy<T>(array);
        this.predicate = predicate;
    }

    @Override
    public void setIterationPolicy(final Predicate<T> filter) {

    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
}
