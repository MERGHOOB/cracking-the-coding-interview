package com.iderserve;

import com.margub.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(7);
        root.left.right.right = new TreeNode<>(8);

        root.right = new TreeNode<>(3);


        TreeNode<Integer> lca = new LowestCommonAncestor().findLCA(root, root.left.left, root.right);
        System.out.println(lca.val);
    }

    private TreeNode<Integer> findLCA(TreeNode<Integer> current, TreeNode<Integer> first, TreeNode<Integer> second) {

        if (current == null) {
            return null;
        }
        if (current == first || current == second) {
            return current;
        }

        TreeNode<Integer> left_lca = findLCA(current.left, first, second);
        TreeNode<Integer> right_lca = findLCA(current.right, first, second);

        if (left_lca != null && right_lca != null) {
            return current;
        }
        return left_lca == null ? right_lca : left_lca;
    }
}
