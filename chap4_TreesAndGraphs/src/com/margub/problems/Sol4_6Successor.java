package com.margub.problems;

import com.margub.TreeNode;

public class Sol4_6Successor {


    /*
    Considering unique values in BST
     */
    public TreeNode getSuccessor(TreeNode<Integer> root, TreeNode<Integer> node) {

        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return leftMostChild(node.right);
        }

        TreeNode<Integer> temp = node;
        while (temp.parent != null && temp != temp.parent.left) {
            temp = temp.parent;
        }
        if (temp.parent == null) {
            return null;
        } else {
            return temp.parent;
        }

    }

    private TreeNode leftMostChild(TreeNode<Integer> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
