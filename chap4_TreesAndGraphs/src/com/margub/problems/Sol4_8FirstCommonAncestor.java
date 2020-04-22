package com.margub.problems;

import com.margub.TreeNode;
import com.margub.TreeUtils;

public class Sol4_8FirstCommonAncestor {


    //Consider parent link is present
    public TreeNode firstCommonAncestor(TreeNode first, TreeNode second) {
        int firstDepth = TreeUtils.getDepthForNodeIfParent(first); // getDepth for first
        int secondDepth = TreeUtils.getDepthForNodeIfParent(second); // getDetph for second

        if (firstDepth < secondDepth) {
            TreeUtils.swap(first, second); // make first who is deeper
        }

        first = goUp(first, secondDepth - firstDepth); // level first to same as second

        while (first != second) {
            first = first.parent;
            second = second.parent;
        }
        return first;

    }

    private TreeNode goUp(TreeNode first, int delta) {
        while (delta-- != 0) {
            first = first.parent;
        }
        return first;
    }


    /*
    Root required if no parent link is present
     */
    public TreeNode fca(TreeNode root, TreeNode first, TreeNode second) {

        if (root == null) {
            return root; // Base case
        }
        if (root == first || root == second) {
            return root; // Base case
        }

        TreeNode left = fca(root.left, first, second);
        TreeNode right = fca(root.right, first, second);

        //Both side if we get NOT NULL, it means this root must be a Ancestor
        if (left != null && right != null) {
            return root;
        }
        // else who is non-null return that or both null then return null;
        return left != null ? left : right;


    }

    /* Optimized(better soltuion)
    Root required if no parent link is present
     */
    public TreeNode fcaOptimized(TreeNode root, TreeNode first, TreeNode second) {

        if (root == null) {
            return root; // Base case
        }
        if (root == first || root == second) {
            return root; // Base case
        }

        TreeNode left = fcaOptimized(root.left, first, second);
        if (left != null && left != first && left != second) { // this shows that left is common ancestor
            return left; //dont got for right subtree
        }
        TreeNode right = fcaOptimized(root.right, first, second);
        if (right != null && right != first && right != second) {//// this shows that left is common ancestor
            return right; // don't go further
        }
        //Both side if we get NOT NULL, it means this root must be a Ancestor
        if (left != null && right != null) {
            return root;
        }
        // else who is non-null return that or both null then return null;
        return left != null ? left : right;


    }

}
