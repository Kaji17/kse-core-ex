package com.cocanTest.demo.logic;

public interface Crud<T> {

    T save(T entity);

    T update( T entity);

    T getById(Integer id);

    Iterable<T> getAll();

    void deleteById(Integer id);

}
