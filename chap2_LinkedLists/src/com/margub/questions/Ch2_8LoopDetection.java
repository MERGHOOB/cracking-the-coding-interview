package com.margub.questions;

import com.margub.chap2.Node;

public class Ch2_8LoopDetection {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = node.next; // 4-2
        System.out.println(new Ch2_8LoopDetection().isLoopPresent(node));
    }

    private boolean isLoopPresent(Node head) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;


    }

}
