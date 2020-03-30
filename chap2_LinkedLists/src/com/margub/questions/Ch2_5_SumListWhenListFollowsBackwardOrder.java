package com.margub.questions;

import com.margub.chap2.Node;

public class Ch2_5_SumListWhenListFollowsBackwardOrder {


    public static void main(String[] args) {
        //617
        Node head = new Node(7);
        head.next = new Node(1);
        head.next.next = new Node(6);

        //295
        Node second = new Node(5);
        second.next = new Node(9);
        second.next.next = new Node(2);

        // answer must be : 912
        // List : 2->1->9

        Node node = new Ch2_5_SumListWhenListFollowsBackwardOrder().sumList(head, second);
        Node.printList(node);
    }

    private Node sumList(Node first, Node second) {

        int carry = 0;
        Node result = sumList(first, second, carry);
        return result;


    }

    private Node sumList(Node first, Node second, int carry) {

        if (first == null && second == null && carry == 0) {
            return null;
        }

        int val = carry;

        if (first != null) {
            val += first.val;
        }

        if (second != null) {
            val += second.val;
        }

        Node result = new Node(val % 10);

        if (first != null || second != null) {
            result.next = sumList(first == null ? null : first.next, second == null ? null : second.next, val / 10);
        }
        return result;


    }

}
