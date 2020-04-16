package com.margub.problems;

import com.margub.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Sol4_5ValidateBST {

    boolean isBST(TreeNode<Integer> root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left != null && root.right == null) {
            return ((Integer) root.left.val) <= root.val;
        }

        if (root.left == null && root.right != null) {
            return ((Integer) root.right.val) > root.val;
        }
        // In order traversal is sorted


        // two parts
        // read all values and store into an array

        List<Integer> values = new ArrayList<>();
        readInorder(root, values);
        // check whether array is sorted

        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i - 1) <= values.get(i) && values.get(i) < values.get(i + 1)) {
                continue;
            }
            return false;
        }
        return true;
    }

    private void readInorder(TreeNode<Integer> root, List<Integer> values) {
        if (root == null) {
            return;
        }
        readInorder(root.left, values);
        values.add(root.val);
        readInorder(root.right, values);
    }
}
