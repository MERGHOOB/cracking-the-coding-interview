package com.margub.implementations;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T> {
        private T val;
        private QueueNode<T> next;

        private QueueNode(T val) {
            this.val = val;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        if (first == null) {
            first = new QueueNode<>(item);
            last = first;
        }
        last.next = new QueueNode<>(item);
    }

    public void remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        first = first.next;
        if (first == null) {
            last = null;
        }
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.val;
    }

    public Boolean isEmpty() {
        return first == null;
    }

}
