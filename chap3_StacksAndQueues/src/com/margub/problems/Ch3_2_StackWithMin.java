package com.margub.problems;

import java.util.Stack;

public class Ch3_2_StackWithMin extends Stack<Integer> {

    Stack<Integer> minStack;

    Ch3_2_StackWithMin(int n) {
        minStack = new Stack<Integer>();
    }


    @Override
    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            minStack.pop();
        }
        return value;
    }

    @Override
    public Integer push(Integer val) {
        if (val <= min()) {
            minStack.push(val);
        }
        super.push(val);
        return val;
    }


    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException();
        } else {
            return minStack.peek();
        }
    }
}
