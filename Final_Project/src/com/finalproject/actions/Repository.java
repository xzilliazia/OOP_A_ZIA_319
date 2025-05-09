package com.finalproject.actions;

public interface Repository<T> {
    void save(T item);

    void remove(T item);

    void update(T item);

    T find(int id);
}
