package com.margub.questions;

import com.margub.chap2.Node;

public class Ch2_7_Intersection {


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        Node node2 = new Node(1);
        node2.next = node.next.next.next;


        System.out.println(new Ch2_7_Intersection().findIntersection(node, node2));
    }

    private boolean findIntersection(Node list1, Node list2) {

        int length1 = Node.lengthOfList(list1);
        int length2 = Node.lengthOfList(list2);

        Node big, small;
        if (length1 > length2) {
            big = list1;
            small = list2;
        } else {
            big = list2;
            small = list1;
        }
        int diff = Math.abs(length1 - length2);
        while (diff != 0) {
            big = big.next;
            diff--;
        }

        while (big != null) {
            if (big == small) {
                return true;
            }
            big = big.next;
            small = small.next;
        }
        return false;

    }
}
