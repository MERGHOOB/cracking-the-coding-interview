package com.margub.problems;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Ch3_3_SetsOfStacks {

    List<Stack<Integer>> stackList = new ArrayList<>();

    int threshold = 0;

    Ch3_3_SetsOfStacks(int capacity) {
        this.threshold = capacity;
    }


    public int pop() {
        Stack<Integer> last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.isEmpty()) {
            stackList.remove(stackList.size() - 1);
        }
        return v;
    }

    private Stack<Integer> getLastStack() {
        return stackList.get(stackList.size() - 1);
    }

    public void push(int item) {
        Stack<Integer> last = getLastStack();
        if (last != null && !(threshold == last.size())) {
            last.push(item);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(item);
            stackList.add(stack);
        }
    }

    public int top() {
        return getLastStack().peek();
    }


}
