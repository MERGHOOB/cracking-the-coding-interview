package com.margub.questions;

import com.margub.chap2.Node;

/*
Write code to partition  a linked list around a value x, such that all nodes less that x must comes before all greater than or equal to x


input: 3,5,8,5,10,2,1
output: partition: 5: 3,1,2,10,5,5,8
 */
public class Ch2_4_Partition {


    private Node partitionAroundX(Node head, int x) {
        Node beforeListStart = null;
        Node beforeListEnd = null;

        Node afterListEnd = null;
        Node afterListStart = null;

        while (head != null) {
            if (head.val >= x) {
                if (afterListStart == null) {
                    afterListStart = head;
                    afterListEnd = afterListStart;
                } else {
                    afterListEnd.next = head;
                    afterListEnd = afterListStart.next;
                }
            } else {
                if (beforeListStart == null) {
                    beforeListStart = head;
                    beforeListEnd = beforeListStart;
                } else {
                    beforeListEnd.next = head;
                    beforeListEnd = beforeListEnd.next;
                }
            }
            head = head.next;
        }
        //Merge both list;
        if (beforeListStart == null) {
            return afterListStart;
        }

        beforeListEnd.next = afterListStart;

        return beforeListStart;
    }
}
