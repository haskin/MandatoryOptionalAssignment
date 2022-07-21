package org.example;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class JOptional<T> {

    private final T value;

    private JOptional(T t) {
        value = t;
    }

    public static <T> JOptional<T> ofNullable(T t) {
        return new JOptional<>(t);
    }

    public <U> JOptional<U> map(Function<T, U> mapper) {
        return new JOptional<U>(mapper.apply(value));
    }

    public Stream<T> stream() {
        return Stream.of(this.get());
    }

    public T get() throws NoSuchElementException {
        if (value == null)
            throw new NoSuchElementException();
        return value;
    }

    public T orElse(T backup) {
        if (value == null)
            return backup;
        return value;
    }

    public T orElseGet(Supplier<T> backupCallback) {
        if (value == null)
            return backupCallback.get();
        return value;
    }
}
