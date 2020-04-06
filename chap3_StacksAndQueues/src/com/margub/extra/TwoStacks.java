package com.margub.extra;

import java.util.EmptyStackException;

/*
one thing we can do we divide array in two halves.

and fill the value in according to that

But it will cause an undesired behaviour of StackOverFlow error even if Array has free memory.

// first half is full and push1() call happened: StackOverFlow() error
// while second half does have memory.

// What can we do to avoid this situation
// we will not divide exactly but will push value from head and tail of array for S1 and S2 repsectively
//Both stack will grow towards center
 */
public class TwoStacks {

    int[] arr;
    private int[] top = new int[2];

    TwoStacks(int n) {
        arr = new int[n];
        top[0] = top[1] = -1;
    }

    Boolean isEmpty() {
        if (top[0] == top[1]) {
            return true;
        }
        return false;
    }

    Boolean isFull() {
        return (top[0] + 1 == top[1]);
    }

    void push(int item, int sn) {
        if (isFull()) {
            throw new StackOverflowError("stack is full");
        }

        if (sn == 1) {
            top[sn]++;
        } else {
            top[sn]--;
        }
        arr[top[sn]] = item;
    }

    int pop(int sn) {
        if (top[sn] == -1) {
            throw new EmptyStackException();
        }
        int pop = arr[top[sn]];
        if (sn == 1) {
            top[sn]++;
        } else {
            top[sn]--;
        }
        return pop;
    }


}
