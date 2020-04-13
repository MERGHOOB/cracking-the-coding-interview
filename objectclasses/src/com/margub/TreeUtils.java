package com.margub;

public class TreeUtils {

    public static void InorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        InorderTraversal(root.left);
        System.out.println(root.val);
        InorderTraversal(root.right);
    }
}
