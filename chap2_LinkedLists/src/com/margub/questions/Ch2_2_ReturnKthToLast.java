package com.margub.questions;

import com.margub.chap2.Node;

public class Ch2_2_ReturnKthToLast {


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(1);
//        node.next.next.next = new Node(10);
//        node.next.next.next.next = new Node(2);
//        node.next.next.next.next.next = new Node(20);
//        node.next.next.next.next.next.next = new Node(22);
//        node.next.next.next.next.next.next.next = new Node(225);

        Node.printList(node); //1 2 1 10 2 20 22 225
        //Return 3rd not from last must be 20

        new Ch2_2_ReturnKthToLast().returnKthNodeToLast(node, 3);

    }

    private void returnKthNodeToLast(Node head, int k) {
        Node fast = head;
        while (--k != 0 && fast != null) {
            fast = fast.next;
//            k--;
        }
        if (fast == null) {
            throw new RuntimeException("No Kth node from last");
        }
        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(slow.val);

    }
}
