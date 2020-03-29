package com.margub.questions;

import com.margub.chap2.Node;

import java.util.HashSet;
import java.util.Set;

public class Ch2_1_RemoveDups {


    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(1);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(2);
        printList(node);

        new Ch2_1_RemoveDups().removeDuplicate(node);
//        new Ch2_1_RemoveDups().removeDuplicateWithoutUsingTemporaryBuffer(node);
        printList(node);

    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private void removeDuplicate(Node head) {

        Set<Integer> set = new HashSet<>();

        Node n = head;
        Node prev = null;

        while (n != null) {
            if (set.contains(n.val)) {
                prev.next = n.next;
                prev = prev.next;
            } else {
                set.add(n.val);
                prev = n;
            }

            n = n.next;
        }

    }

    private void removeDuplicateWithoutUsingTemporaryBuffer(Node head) {

//        Set<Integer> set = new HashSet<>();
// Wihtout using a temporray buffer this will be O(N2)

        Node iter = head;
        while (iter != null) {

            Node n = iter.next;
            Node prev = null;

            while (n != null) {
                if (n.val == iter.val) {
                    prev.next = n.next;
                    prev = prev.next;
                } else {
                    prev = n;
                }

                n = n.next;
            }
            iter = iter.next;
        }

    }
}
