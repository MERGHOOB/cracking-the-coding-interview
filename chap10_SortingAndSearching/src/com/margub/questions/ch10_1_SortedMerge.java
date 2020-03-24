package com.margub.questions;


/*
two sorted arrays A and B
Merge both of them inplace

A have enough buffer to hold.
 */
public class ch10_1_SortedMerge {

    void sort(int [] a, int [] b) {

        int end = a.length-1;

        int bLast = b.length-1;
        int aLast = a.length-b.length-1;

        while(aLast >=0 && bLast >= 0) {
            if(a[aLast] > b[bLast]) {
                a[end--] = a[aLast--];
            }
            else {
                a[end--] = b[bLast--];
            }
        }
    }

}
