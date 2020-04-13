package com.margub;

public class TreeNode<T> {
    public TreeNode left;
    public TreeNode right;
    public T val;

    public TreeNode(T val) {
        this.val = val;
        left = null;
        right = null;
    }

}
