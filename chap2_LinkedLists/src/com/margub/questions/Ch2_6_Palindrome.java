package com.margub.questions;

import com.margub.chap2.Node;

import java.util.Stack;

/*
To tell whether a list is palindrome or not

one thing we can just read all and get an array of that and use first and last pointer match until

if it is not allowed than can use
 */
public class Ch2_6_Palindrome {

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(0);

//        head.next.next.next = new Node(2);
//        head.next.next.next.next = new Node(1);
//        head.next.next.next.next.next = new Node(0);

        // reverse and clone than compare if equals than OK

        //Option2 put half into stack and then compare one by one
//        boolean palindrome = new Ch2_6_Palindrome().isPalindromeUsingStack(head);
        boolean palindrome = new Ch2_6_Palindrome().isPalindromeRecursive(head);
        System.out.println(palindrome);

    }

    private boolean isPalindromeUsingStack(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node f = head;
        Node s = head;
        stack.push(s.val);

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            stack.push(s.val);
        }
        if (f != null) {
            s = s.next;
        }
        stack.pop();

        while (!stack.isEmpty()) {
            if (s.val != stack.pop()) {
                return false;
            }
            s = s.next;
        }
        return true;
    }

    private boolean isPalindromeRecursive(Node head) {

        int length = Node.lengthOfList(head);
        Result result = isPalindromeRecursive(head, length);
        return result.result;
    }

    private Result isPalindromeRecursive(Node head, int length) {
       if(head == null || length <=0) {
           return new Result(head, true);
       }
       else if(length == 1) {
           return  new Result(head.next, true);
       }
       /* Recurse sublist*/

        Result res = isPalindromeRecursive(head.next, length-2);

        /**
         * if child calls are not palindrome, pass back a failure
         */
        if(!res.result || res.node == null) {
            return res;
        }

        res.result = (head.val == res.node.val);

        res.node = res.node.next;

        return res;


    }

    private class Result {
        Node node;
        boolean result;

        public Result(Node head, boolean b) {
            node = head;
            result = b;
        }
    }
}
