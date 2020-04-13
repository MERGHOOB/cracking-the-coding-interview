package com.margub.problems;

import java.util.EmptyStackException;
import java.util.Stack;

public class Ch3_5SortStack {

    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    Stack<Integer> minStack = new Stack<>();

    public void push(Integer item) {
        if (minStack.isEmpty()) {
            minStack.push(item);
        }
        else if (minStack.peek() >= item) {
            minStack.push(item);
        }
        first.push(item);
    }

    public Integer pop() {
        if (first.isEmpty()) {
            throw new EmptyStackException();
        }
        while (!minStack.peek().equals(first.peek())) {
            second.push(first.pop());
        }
        minStack.pop();
        int val = first.pop();

        while (!second.isEmpty()) {
            push(second.pop());
        }

        return val;
    }

    public static void main(String[] args) {

        Ch3_5SortStack ch3_5SortStack = new Ch3_5SortStack();
        ch3_5SortStack.push(1);

        ch3_5SortStack.push(3);
        ch3_5SortStack.push(2);
        System.out.println(ch3_5SortStack.pop());

        ch3_5SortStack.push(-1);
        System.out.println(ch3_5SortStack.pop());
        System.out.println(ch3_5SortStack.pop());
        System.out.println(ch3_5SortStack.pop());
        System.out.println(ch3_5SortStack.pop());
    }

}
