package com.margub.interfaces;

public interface IStack<T> {

    boolean isFull();

    boolean isEmpty();

    T pop();

    void push(T val);
}
