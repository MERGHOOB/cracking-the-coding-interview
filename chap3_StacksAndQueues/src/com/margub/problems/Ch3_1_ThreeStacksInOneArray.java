package com.margub.problems;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Ch3_1_ThreeStacksInOneArray {

    private final int[] arr;
    private final int[] top;
    private final int[] next;
    private int free;

    public Ch3_1_ThreeStacksInOneArray(int n, int numberOfStacks) {
        arr = new int[n];
        top = new int[numberOfStacks];
        next = new int[n];
        Arrays.fill(top, -1);
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; // -1 is used to indicate of free list;
        free = 0;


    }


    void push(int item, int sn) {
        if (isFull()) {
            throw new StackOverflowError("full stack");
        }
        // fill the free spot
        int currentFree = free;
        free = next[currentFree];
        //
        next[currentFree] = top[sn]; // first element push, so no next element which next[curreent elem] = -1;
        top[sn] = currentFree;   // second element push, so next element will be first, which is current top and now update the top;

        //
        arr[currentFree] = item;


    }

    int pop(int sn) {
        if (isEmpty(sn)) {
            throw new EmptyStackException();
        }

        int currentTop = top[sn]; // store current top

        top[sn] = next[currentTop]; // update top of stack which is next of current top

        next[currentTop] = free; // update the next of current top will free;
        free = currentTop; // update the free to current top

        return arr[currentTop];
    }

    private boolean isEmpty(int i) {
        return top[i] == -1;
    }

    private boolean isFull() {

        return free == -1;
    }

    public static void main(String[] args) {

    }
}
