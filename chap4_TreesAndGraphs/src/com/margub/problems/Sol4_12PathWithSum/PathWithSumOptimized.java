package com.margub.problems.Sol4_12PathWithSum;

import com.margub.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathWithSumOptimized {


    @SuppressWarnings("WeakerAccess")
    public int pathWithSumOptimized(TreeNode<Integer> root, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();
        return pathWithSumOptimized(root, map, targetSum, 0);

    }

    private int pathWithSumOptimized(TreeNode<Integer> root, Map<Integer, Integer> map, int targetSum, int runningSum) {
        if (root == null) {
            return 0;
        }
        runningSum += root.val;

        int sum = runningSum - targetSum;
        int totalPaths = map.getOrDefault(sum, 0);

        /*
        if running sum is equal to target sum , then there is path ending at root.

         */
        if (runningSum == targetSum) {
            totalPaths++;
        }
        updateHash(map, runningSum, 1); // it will udpate the value for running sum by 1;
        totalPaths += pathWithSumOptimized(root.left, map, targetSum, runningSum);
        totalPaths += pathWithSumOptimized(root.right, map, targetSum, runningSum);
        updateHash(map, runningSum, -1); // remove current root value from hashtable

        return totalPaths;

    }

    private void updateHash(Map<Integer, Integer> map, int runningSum, int increment) {
        int newCount = map.getOrDefault(runningSum, 0) + increment;
        if (newCount == 0) {
            map.remove(runningSum);
        } else
            map.put(runningSum, newCount);
    }


    public static void main(String[] args) {

        TreeNode<Integer> root = createTreeNode();

        int i = new PathWithSumOptimized().pathWithSumOptimized(root, 8);
        System.out.println(i);


    }

    static TreeNode<Integer> createTreeNode() {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.left.left = new TreeNode<>(3);
        root.left.left.right = new TreeNode<>(-2);

        root.left.right = new TreeNode<>(2);
        root.left.right.right = new TreeNode<>(1);

        root.right = new TreeNode<>(-3);
        root.right.right = new TreeNode<>(11);
        return root;
    }

}
