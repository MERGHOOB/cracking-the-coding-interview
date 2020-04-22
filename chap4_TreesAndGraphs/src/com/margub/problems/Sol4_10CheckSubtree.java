package com.margub.problems;

import com.margub.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Sol4_10CheckSubtree {

    public boolean isSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2) {

        List<TreeNode<Integer>> allNodes = new ArrayList<>();
        find(t1, t2.val, allNodes);

        for (TreeNode<Integer> candidate : allNodes) {
            if (isIdentical(candidate, t2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdentical(TreeNode<Integer> first, TreeNode<Integer> second) {

        if (first == null && second == null) {
            return true;
        }

        if (first != second) {
            return false;
        }

        return isIdentical(first.left, second.left) && isIdentical(first.right, second.right);

    }

    private void find(TreeNode<Integer> root, Integer val, List<TreeNode<Integer>> allNodes) {
        if (root == null) {
            return;
        }
        if (root.val.equals(val)) {
            allNodes.add(root);
        }
        find(root.left, val, allNodes);
        find(root.right, val, allNodes);

    }

    /*
    Option: pre-order traversal() of t2 must be a substring for pre-order of t1
    But what about 2 (left) 3 and 2--> 3 is same
    preOrder traversal of t1 and t2 is same 2,3

    How to avoid : we can consider null as part of traversal too: use some indicator : like "X"
     */


    public boolean checkSubtree(TreeNode<Integer> t1, TreeNode<Integer> t2) {

        String s1 = preOrderTraversal(t1);
        String s2 = preOrderTraversal(t2);

        return s1.contains(s2);
    }

    private String preOrderTraversal(TreeNode<Integer> root) {
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null) {
            stringBuilder.append('X');
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val);

        stringBuilder.append(preOrderTraversal(root.left));
        stringBuilder.append(preOrderTraversal(root.right));

        return stringBuilder.toString();
    }

}
