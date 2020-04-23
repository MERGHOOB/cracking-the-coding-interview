package com.margub.problems.Sol4_11_RandomNode;

import java.util.Random;

public class BinarySearchTreeImpl {

    public TreeNode root = null;


    public TreeNode getRandomNode() {
        return getRandomNode(root);

    }

    private TreeNode getRandomNode(TreeNode root) {
        if (root == null) {
            throw new IllegalStateException("should not come here");
        }

        Random random = new Random();
        int index = random.nextInt(root.getSize());
        int leftSize = root.getLeft() == null ? 0 : root.getLeft().getSize();
        if (index < leftSize) {
            return getRandomNode(root.getLeft());
        }
        if (index == leftSize) {
            return root;
        }
        return getRandomNode(root.getRight());
    }


    public void insert(int val) {

        insert(new TreeNode(val), root);

    }


    public TreeNode find(int toFind) {

        return find(toFind, root);

    }


    public void delete(int toDelete) {
        deleteNode(toDelete, root);
    }

    private void deleteNode(int toDelete, TreeNode root) {
        if (root == null) {
            throw new IllegalStateException("Not found");
        }
        if (toDelete == root.getVal()) {

            if (root.getRight() == null) {
                /**
                 * update the root
                 */
                root = root.getLeft();
            } else {
                TreeNode rootRight = root.getRight();
                TreeNode rootRightLeft = rootRight.getLeft();
                rootRight.setLeft(root.getLeft());
                insert(rootRightLeft, rootRight);
                root = rootRight;

            }
        } else if (toDelete < root.getVal()) {
            deleteNode(toDelete, root.getLeft());
        } else {
            deleteNode(toDelete, root.getRight());
        }
    }


    private TreeNode find(int toFind, TreeNode root) {
        if (root == null) {
            throw new IllegalStateException("NOT FOUND");
        }

        if (toFind == root.getVal()) {
            return root;
        }
        if (toFind < root.getVal()) {
            return find(toFind, root.getLeft());
        }
        return find(toFind, root.getRight());
    }


    private void insert(TreeNode toInsert, TreeNode root) {

        if (toInsert == null) {
            return;
        }
        if (root == null) {
            root = toInsert;
        } else {
            root.incrementSize();
            if (toInsert.getVal() <= root.getVal()) {
                insert(toInsert, root.getLeft());
            } else {
                insert(toInsert, root.getRight());
            }
        }

        root.incrementSize();

    }


}
