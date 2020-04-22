package com.margub.problems;

import com.margub.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sol4_9BSTSequence {


    public static List<LinkedList<Integer>> allSequences(TreeNode<Integer> root) {

        List<LinkedList<Integer>> result = new ArrayList<>();

        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);
        /*
        Recurse on left and right subtree
         */
        List<LinkedList<Integer>> leftSequences = allSequences(root.left);
        List<LinkedList<Integer>> rightSequences = allSequences(root.right);

        /*
        Weave together with each list from left and right side
         */
        for (LinkedList<Integer> left : leftSequences) {
            for (LinkedList<Integer> right : rightSequences) {
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveList(left, right, prefix, weaved);
                result.addAll(weaved);
            }
        }
        return result;
    }

    private static void weaveList(LinkedList<Integer> left, LinkedList<Integer> right, LinkedList<Integer> prefix, List<LinkedList<Integer>> weaved) {


        /*
        if left or right is empty add the remainder(prefix clone) and store results

         */
        if (left.isEmpty() || right.isEmpty()) {

            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(left);
            result.addAll(right);

            weaved.add(result);
            return;
        }
        /* Recurse with head of first added to the prefix. Removing the
         * head will damage first, so we’ll need to put it back where we
         * found it afterwards. */
        Integer headLeft = left.removeFirst();
        prefix.addLast(headLeft);
        weaveList(left, right, prefix, weaved);
        prefix.removeLast();
        left.addFirst(headLeft);

        /* Do the same thing with second, damaging and then restoring
         * the list.*/
        Integer headRight = right.removeFirst();
        prefix.addLast(headRight);
        weaveList(left, right, prefix, weaved);
        prefix.removeLast();
        right.addFirst(headRight);


    }

    public static void main(String[] args) {
        TreeNode<Integer> node = new TreeNode<>(2);
//        int[] array = {100, 50, 20, 75, 150, 120, 170};
        int[] array = {2,1,3};
        for (int a : array) {
            if(a == node.val) { // this line is to avoid duplication of  root node.
                continue;
            }
            insertInOrder(a, node);
        }
        List<LinkedList<Integer>> allSeq = allSequences(node);
        for (LinkedList<Integer> list : allSeq) {
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }

    private static void insertInOrder(int d, TreeNode<Integer> node) {
        if (d <= node.val) {
            if (node.left == null) {
                node.left = new TreeNode<>(d);
            } else {
                insertInOrder(d, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode<>(d);
            } else {
                insertInOrder(d, node.right);
            }
        }
    }


}
