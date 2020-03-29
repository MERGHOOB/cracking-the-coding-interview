package com.margub.chap2;

public class Node {

    public Node next = null;
    public int val;
    public Node head;


    public Node(int val) {
//        this.next = null;
        this.val = val;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;
        if (n.val == d) {
            head = n.next;
            n.next = null;
            return head;
        }
        while (n.next != null) {
            if (n.next.val == d) {
                n = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }


    public void recursiveReverse(Node curr) {

        if(curr == null) {
            return;
        }

        if(curr.next == null) {
            this.head = curr;
            return;
        }
        recursiveReverse(curr.next);
        curr.next.next = curr;
        curr.next = null;
    }

}
