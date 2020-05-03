package ru.javaprojectkazan.dao;

import java.util.List;

public interface DAO<T> {

    void insert(T t);

    T get(String firstParam) throws Exception;

    T get(int firstParam) throws Exception;

    void update(T t);

    List<T> getAll();

}
