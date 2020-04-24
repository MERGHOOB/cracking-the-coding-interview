package com.margub.problems.Sol4_12PathWithSum;


import com.margub.TreeNode;

public class PathWithSum {


    private int countPathSum(TreeNode<Integer> root, int sum) {

        if (root == null) {
            return 0;
        }

        /*
        count path from root node
         */
        int totalPaths = countPathSumFromNode(root, sum, 0);
        totalPaths += countPathSum(root.left, sum);
        totalPaths += countPathSum(root.right, sum);

        return totalPaths;
    }

    private int countPathSumFromNode(TreeNode<Integer> root, int sum, int currentSum) {
        if (root == null) {
            return 0;
        }

        currentSum += root.val;
        int totalPaths = 0;
        if (currentSum == sum) {
            totalPaths++;
        }
        totalPaths += countPathSumFromNode(root.left, sum, currentSum);
        totalPaths += countPathSumFromNode(root.right, sum, currentSum);

        return totalPaths;
    }


    public static void main(String[] args) {


        int i = new PathWithSum().countPathSum(PathWithSumOptimized.createTreeNode(), 8);
        System.out.println(i);


    }
}
