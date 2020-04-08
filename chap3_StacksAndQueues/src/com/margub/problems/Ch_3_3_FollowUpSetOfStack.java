package com.margub.problems;

import com.margub.implementations.MyStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ch_3_3_FollowUpSetOfStack extends Ch3_3_SetsOfStacks {


    List<Stackk> setOfStacks = new ArrayList<>();

    Ch_3_3_FollowUpSetOfStack(int capacity) {
        super(capacity);
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stackk stack = setOfStacks.get(index);
        int removedItem;
        if (removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();
        if (stack.isEmpty()) {
            setOfStacks.remove(index);
        } else if (setOfStacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }


    // Assumption all will run on full capacity but last
    private static class Stackk {
        int size;
        int capacity;
        private StackkNode top;
        private StackkNode bottom;

        Stackk(int capacity) {
            this.capacity = capacity;
        }

        public int pop() {
            StackkNode t = top;
            top = top.below;
            size--;
            return t.val;
        }

        public boolean push(int v) {
            if (size >= capacity) return false;
            size++;
            StackkNode stackkNode = new StackkNode(v);
            if (size == 1) {
                bottom = stackkNode;
            }
            join(stackkNode, top);
            top = stackkNode;
            return true;
        }

        public void join(StackkNode above, StackkNode below) {
            if (below != null) below.above = above;
            if (above != null) above.below = below;
        }

        public int removeBottom() {
            StackkNode stackkNode = bottom;
            bottom = bottom.above;
            if (bottom != null) bottom.below = null;
            size--;
            return stackkNode.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private static class StackkNode {
        StackkNode below;
        StackkNode above;
        int val;

        StackkNode(int val) {
            this.val = val;
        }
    }


}
