package com.margub.problems;

import com.margub.TreeNode;
import com.margub.TreeUtils;

public class Sol4_4BalanceTreeChecker {

    private boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (Math.abs(TreeUtils.getHeight(root.left) - TreeUtils.getHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /*
    for each node, getHeight is being called on each node.
    we need to cut some call of getHeight()
        public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    if we inspect getHeight() could actually check if the
    tree is balanced at the same time as it is checking
    heights. What we do when a subtree isn't balanced.
    Just return an error code;
     */

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; //Pass error code
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // return ERROR CODE
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


    boolean isBalancedON(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
