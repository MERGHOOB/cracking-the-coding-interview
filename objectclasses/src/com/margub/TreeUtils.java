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

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /*
    This method consider parent is present
     */
    public static int getDepthForNodeIfParent(TreeNode first) {

        int height = 0;
        while (first != null) {
            first = first.parent;
            height++;
        }

        return height;
    }

    public static void swap(TreeNode first, TreeNode second) {
        TreeNode temp = first;first = second; second = temp;
    }
}
