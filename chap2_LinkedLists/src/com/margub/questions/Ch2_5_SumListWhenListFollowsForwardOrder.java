package com.margub.questions;

import com.margub.chap2.Node;

public class Ch2_5_SumListWhenListFollowsForwardOrder {

    public static void main(String[] args) {
        //716
        Node head = new Node(9);
        head.next = new Node(5);
        head.next.next = new Node(6);

        //592
        Node second = new Node(5);
//        second.next = new Node(9);
//        second.next.next = new Node(2);

        // answer must be : 1308
        // List : 1->3->0->8

        Node.printList(new Ch2_5_SumListWhenListFollowsForwardOrder().sumList(head, second));
    }

    private Node sumList(Node first, Node second) {

        int firstLen = Node.lengthOfList(first);
        int secondLen = Node.lengthOfList(second);

        Node Big, small;
        if (firstLen > secondLen) {
            Big = first;
            small = Node.padZerosAtHead(second, firstLen - secondLen);
        } else {
            Big = second;
            small = Node.padZerosAtHead(first, secondLen - firstLen);
        }

        return addListHelper(Big, small).toList();

    }

    private ResultNode addListHelper(Node big, Node small) {


        if (big == null) {
            return new ResultNode();
        }

        ResultNode resultNode = addListHelper(big.next, small.next);

        int val = big.val + small.val + resultNode.carry;

        ResultNode res = new ResultNode();
        res.setResult(new Node(val % 10));
        res.setCarry(val / 10);

        res.getResult().next = resultNode.getResult();
        return res;

    }


    private static class ResultNode {
        public ResultNode() {
            this.result = null;
            this.carry = 0;
        }

        public ResultNode(Node result, int carry) {
            this.result = result;
            this.carry = carry;
        }

        public Node getResult() {
            return result;
        }

        public void setResult(Node result) {
            this.result = result;
        }

        public int getCarry() {
            return carry;
        }

        public void setCarry(int carry) {
            this.carry = carry;
        }

        Node result;
        int carry;


        public Node toList() {
            Node carryNode = null;
            if (carry != 0) {
                carryNode = new Node(carry);
                carryNode.next = result;
            }
            return carryNode != null ? carryNode : result;
        }
    }
}
