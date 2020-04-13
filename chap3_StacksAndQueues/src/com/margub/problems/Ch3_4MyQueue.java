package com.margub.problems;

import java.util.Stack;

public class Ch3_4MyQueue<T> {

    //First in first out
    private Stack<T> first = new Stack<>();
    private Stack<T> second = new Stack<>();


    public void add(T item) {
        first.add(item);
    }

    public T poll() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.add(first.pop());
            }
        }
        if (second.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        return second.pop();
    }

    public static void main(String[] args) {
        Ch3_4MyQueue<Integer> integerCh3_4MyQueue = new Ch3_4MyQueue<>();

        integerCh3_4MyQueue.add(1);
        integerCh3_4MyQueue.add(2);
        integerCh3_4MyQueue.add(3);
        integerCh3_4MyQueue.add(4);
        System.out.println(integerCh3_4MyQueue.poll());
        System.out.println(integerCh3_4MyQueue.poll());
        integerCh3_4MyQueue.add(20);
        integerCh3_4MyQueue.add(30);
        integerCh3_4MyQueue.add(40);
        System.out.println(integerCh3_4MyQueue.poll());
        System.out.println(integerCh3_4MyQueue.poll());
        System.out.println(integerCh3_4MyQueue.poll());
        System.out.println(integerCh3_4MyQueue.poll());
        System.out.println(integerCh3_4MyQueue.poll());
    }
}
