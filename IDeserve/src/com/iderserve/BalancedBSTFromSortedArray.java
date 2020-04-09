package com.iderserve;

import com.margub.TreeNode;

public class BalancedBSTFromSortedArray {

    public TreeNode createBalancedBST(int[] sorted) {

        return createBalancedBST(sorted, 0, sorted.length - 1);
    }

    private TreeNode createBalancedBST(int[] sorted, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode leftBST = createBalancedBST(sorted, start, mid - 1);
        TreeNode rightBST = createBalancedBST(sorted, mid + 1, end);

        TreeNode treeNode = new TreeNode(sorted[mid]);
        treeNode.left = leftBST;
        treeNode.right = rightBST;
        return treeNode;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 4, 5, 6, 7,8,9,10,11};
        TreeNode balancedBST = new BalancedBSTFromSortedArray().createBalancedBST(sorted);

        testHeight(balancedBST);
    }

    private static void testHeight(TreeNode balancedBST) {

        TreeNode left = balancedBST;
        int height = 0;
        while (left != null) {
            left = left.left;
            height++;
        }

        TreeNode right = balancedBST;
        while (right != null) {
            right = right.right;
            height--;
        }
        if (Math.abs(height) > 1) {

            throw new RuntimeException("Not Balanced");
        }
        System.out.println(height);
    }

}
