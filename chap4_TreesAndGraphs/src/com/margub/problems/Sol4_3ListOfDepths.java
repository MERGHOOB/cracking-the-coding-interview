package com.margub.problems;

import com.margub.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree: design an algorithm which creates a linked list of all the nodes at each depth
 */
public class Sol4_3ListOfDepths {


    public void createLinkedList(TreeNode<Integer> root, List<LinkedList<TreeNode>> listOfLinkedList, int level) {

        if (root == null) {
            return; // base case
        }

        LinkedList<TreeNode> levelList = null;
        if (listOfLinkedList.size() == level) { // level is not present in list
            /*
            Levels are always traversed in order, so if this is the first time for ith level, it means we have visited 0 to i-1th level
            So therefore we can safely add the list for the level
             */
            levelList = new LinkedList<TreeNode>();
            listOfLinkedList.add(levelList);
        } else {
            levelList = listOfLinkedList.get(level);
        }

        levelList.add(root);
        createLinkedList(root.left, listOfLinkedList, level + 1);
        createLinkedList(root.right, listOfLinkedList, level + 1);
    }

    public List<LinkedList<TreeNode>> createLevelLinkedList(TreeNode<Integer> root) {
        List<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLinkedList(root, lists, 0);
        return lists;

    }

    public List<LinkedList<TreeNode>> createLevelLinkedListUsingBFS(TreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        List<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }


        }

        return result;
    }
}
