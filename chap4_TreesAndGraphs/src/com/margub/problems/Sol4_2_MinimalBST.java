package com.margub.problems;

import com.margub.TreeNode;
import com.margub.TreeUtils;

public class Sol4_2_MinimalBST {

    public TreeNode createMinimalBST(int[] sorted) {
        if (sorted == null || sorted.length == 0) {
            return null;
        }
        return createMinimalBST(sorted, 0, sorted.length - 1);
    }

    private TreeNode createMinimalBST(int[] sorted, int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode<Integer> root = new TreeNode<>(sorted[mid]);
        TreeNode minimalBSTLeft = createMinimalBST(sorted, left, mid - 1);
        if (minimalBSTLeft != null) {
            root.left = minimalBSTLeft;
        }

        TreeNode minimalBSTRight = createMinimalBST(sorted, mid + 1, right);
        if (minimalBSTRight != null) {
            root.right = minimalBSTRight;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        TreeNode minimalBST = new Sol4_2_MinimalBST().createMinimalBST(arr);
        TreeNode temp = minimalBST;
        int height = 0;
        while (temp != null) {
            temp = temp.left;
            height++;
        }
        temp = minimalBST;
        while (temp != null) {
            temp = temp.right;
            height--;
        }
//        System.out.println(height);

        TreeUtils.InorderTraversal(minimalBST);
    }
}
