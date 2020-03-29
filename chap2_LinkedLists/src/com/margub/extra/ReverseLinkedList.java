package com.margub.extra;

import com.margub.chap2.Node;

public class ReverseLinkedList {

    public Node reverse(Node head) {

        if (head == null) {
            return null;
        }
        Node temp = head.next;
        Node tempPrev = null;
        while (temp != null) {
            Node forward = temp.next;
            temp.next = head;
            head.next = tempPrev;
            tempPrev = head;
            head = temp;
            temp = forward;
        }
        return head;
    }



    public static void main(String[] args) {

        Node list = new ReverseLinkedList().createList(1, 2, 3);
        printList(list);
//        Node reverse = new ReverseLinkedList().reverse(list);
      list.recursiveReverse(list);
        printList(list.head);
    }

    private static void printList(Node head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private Node createList(Integer... integers) {
        Node head = null;
        Node last = null;
        for (int val : integers) {
            Node n = new Node(val);
            if (head == null) {
                head = n;
                last = n;
            }
            last.next = n;
            last = n;

        }
        return head;
    }


}
