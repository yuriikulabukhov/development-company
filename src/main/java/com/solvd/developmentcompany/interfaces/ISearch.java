package com.solvd.developmentcompany.interfaces;

@FunctionalInterface
public interface ISearch<T> {
    boolean search(T item);
}
