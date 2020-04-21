package com.margub;

public class TreeNode<T> {
    public TreeNode<T> left;
    public TreeNode<T> right;
    public T val;
    public TreeNode<T> parent;

    public TreeNode(T val) {
        this.val = val;
        left = null;
        right = null;
    }

}
