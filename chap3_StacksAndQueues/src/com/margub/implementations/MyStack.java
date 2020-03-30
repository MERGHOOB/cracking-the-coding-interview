package com.margub.implementations;

import java.util.EmptyStackException;

public class MyStack<T> {

    private StackNode<T> top;
    public T pop()  {
        if(top == null) {
            throw new EmptyStackException();
        }
        T item = top.val;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> tStackNode = new StackNode<>(item);
        tStackNode.next = top;
        top = tStackNode;
    }

    public T peek() {
        if(top == null) {
            throw new EmptyStackException();
        }
        return top.val;
    }

    public boolean isEmpty() {
        return top != null;
    }

    private static class StackNode<T> {
        private T val;
        private StackNode<T> next;

        public StackNode(T val) {
            this.val = val;
        }
    }
}
