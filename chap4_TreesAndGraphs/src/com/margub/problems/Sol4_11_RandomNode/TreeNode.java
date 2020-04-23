package com.margub.problems.Sol4_11_RandomNode;

public class TreeNode {
    private int val;
    private TreeNode left = null, right = null;
    private int size = 0;

    TreeNode(int val) {
        this.val = val;
        incrementSize();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void decrementSize() {
        size--;
    }

    public void incrementSize() {
        size++;
    }
}
