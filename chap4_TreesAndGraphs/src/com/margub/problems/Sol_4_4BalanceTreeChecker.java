package com.margub.problems;

import com.margub.TreeNode;
import com.margub.TreeUtils;

public class Sol_4_4BalanceTreeChecker {

    private boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (Math.abs(TreeUtils.getHeight(root.left) - TreeUtils.getHeight(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


}
